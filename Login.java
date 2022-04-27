package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet { 
	
		private int hitCount;
	
	    public void init() {
	        hitCount = 0;
	    }
	    
        public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
        {	
        	hitCount++;
            res.setContentType("text/html");
            PrintWriter out=res.getWriter();
            out.print("<!DOCTYPE html>\n"
            		+ "<html>\n"
            		+ "<head>\n"
            		+ "<!-- CSS only -->\n"
            		+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\n"
            		+ "<meta charset=\"UTF-8\">\n"
            		+ "<title>Register</title>\n"
            		+ "</head>\n"
            		+ "<body>");
            
            out.print("<div style='width: 30rem; margin: 0 auto'>");
            out.print("<form action='login' method='post'>");
            out.print("<br>Username<input type='text' class='form-control' name='username'>");
            out.print("<br>Password<input type='text' class='form-control' name='password'>");
            out.print("<br><input class='btn btn-primary' type='submit' value='submit'>");
            out.print("</form>"); 
            out.print("<div>");
            out.print("<br><a href='register'>Register</a>");
            out.print("<br>");
            out.print("Hit Count: " + hitCount);
            out.print("</body>\n"
            		+ "</html>");
            out.close(); 
            
        }
        
        public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
        {
        	res.setContentType("text/html");
            PrintWriter out = res.getWriter();

            String username = req.getParameter("username");
            String password = req.getParameter("password");
            try {
            	if (username.isEmpty() || password.isEmpty()) {
                    throw new Exception("Fill all fields");
                }
            	
            	Class.forName("com.mysql.jdbc.Driver");
        		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "password");
        		Statement stmt = con.createStatement();
        		String query = "SELECT * FROM user_details where Username='"+username+"' AND pwd='"+password+"'";
        		ResultSet rs = stmt.executeQuery(query);
        		
        		if(!rs.next()) {
        			throw new Exception("Wrong Username and Password");
        		}

                out.println("WELCOME " + req.getParameter("username"));
                out.print("<form action='course' method='post'>");
                out.print("<input type='hidden' name='uname' value='" + username + "'>");
                out.print("<input type='submit' value='Continue to course registration'>");
                out.print("</form>");

                out.close();
            } catch (Exception e) {
            	out.println(e.getMessage());
            }
        }

}