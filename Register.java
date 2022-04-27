package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet { 
        public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
        {
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
            out.print("<form action='register' method='post'>"); 
            out.print("<br>Username<input type='text' class='form-control' name='username'>");
            out.print("<br>Password<input type='password' class='form-control' name='password'>");
            out.print("<br>Confirm Password<input type='password' class='form-control' name='cpassword'>");
            out.print("<br><input class='btn btn-primary' type='submit' value='submit'>");
            out.print("</form>");
            out.print("<div>");
            out.print("<br><a href='/Lab-2/login'>Login</a>");
            
            out.print("</body>\n"
            		+ "</html>");
            out.close(); 
            
        }
        
        public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
        {	
        	String username = req.getParameter("username");
            String password = req.getParameter("password");
            String cpassword = req.getParameter("cpassword");
            
            PrintWriter out=res.getWriter();
            
            
            try {
            	if (username.isEmpty() || password.isEmpty() || cpassword.isEmpty()) {
            		throw new Exception("Fill all the fields");
            	}

            	else if (!password.equals(cpassword)) {
            		throw new Exception("Password do not match");
            	}
            
        		Class.forName("com.mysql.jdbc.Driver");
        		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "password");
        		String query = "INSERT INTO user_details (Username, Pwd) values(?, ?)";
        		PreparedStatement ps = con.prepareStatement(query);
        		
        		ps.setString(1, username);
        		ps.setString(2, password);
        		
        		ps.executeUpdate();
        		out.println("Welcome " + username);
        	} catch(Exception e) {
        		out.println(e.getMessage());
        	}
        }

}