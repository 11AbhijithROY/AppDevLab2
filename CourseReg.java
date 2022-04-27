import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dilip
 */
public class CourseReg extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(CourseReg.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String s = request.getParameter("Uname");
            String pass = request.getParameter("Pass");
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaServ","root","Ojun04864@");
            Statement stm = conn.createStatement();
            ResultSet rs=stm.executeQuery("select * from user where name=\""+s+"\"");
            
            if(rs.next())
            {
                String rpass=rs.getString("password");
                if(rpass.equals(pass))
                {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head> <title>"
                    + "Servlet CourseReg</title><link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"></head>");
            out.println("<body><form id=\"login\" method=\"get\" action=\"Welcome\">  \n" +
"        <h1 align=\"center\">Welcome" + " " + s + "</h1>\n" +
"        <input type=\"hidden\" name=\"Uname\" id=\"Uname\" value=" + s +">    \n" +
"        <br>\n" +
"        \n" +
"        <label><b>Roll Number&emsp;&emsp;&nbsp;&nbsp;</label>    \n" +
"        <input type=\"text\" name=\"Uname\" id=\"Uname\" placeholder=\"Roll Number\">    \n" +
"        <br><br>\n" +
"        \n" +
"        <label><b>Year&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;</label>    \n" +
"        <input type=\"text\" name=\"Uname\" id=\"Uname\" placeholder=\"Year Of Study\">    \n" +
"        <br><br>\n" +
"        \n" +
"        <label><b>Semester&emsp;&emsp;&emsp;&emsp;</label>    \n" +
"        <input type=\"text\" name=\"Uname\" id=\"Uname\" placeholder=\"Semester\">    \n" +
"        <br><br>\n" +
"        \n" +
"        <label><b>Course&emsp;&emsp;&emsp;&emsp;&emsp;</label>    \n" +
"        <input type=\"text\" name=\"Uname\" id=\"Uname\" placeholder=\"Course\">    \n" +
"        <br><br>\n" +
"        \n" + "<br><br>"+ 
"        <button type=\"submit\" name=\"log\" id=\"sup\" value=\"Sign Up\" >Submit</button>\n" +
"        <br><br>        \n" +
"  \n" +
"    </form>");
              
      
            out.println("</body>");
            out.println("</html>");
        }
                else
                {
                    out.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>WEEK 2</title>\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n" +
"    </head>\n" +
"    <body align=\"center\">\n" + "<img src=\"13.png\" width=\"270\" height=\"270\">"+
"        <form id=\"login1\" method=\"get\" action=\"signupprocedure.html\">    \n" +
         "<h4 align=\"center\">&emsp;Wrong Password&emsp;Please Try Again!</h4>"+
"        <label><b>User Name  &emsp;</label>    \n" +
"        <input type=\"text\" name=\"Uname\" id=\"Uname\" placeholder=\"Username\">    \n" +
"        <br><br>    \n" +
"        <label><b>Password &emsp;&nbsp;    \n" +
"        </label>    \n" +
"        <input type=\"Password\" name=\"Pass\" id=\"Pass\" placeholder=\"Password\">    \n" +
"        <br><br>    \n" +
"        <button type=\"submit\" name=\"log\" id=\"sin\" value=\"Sign In\" formaction=\"CourseReg\">Sign In </button>\n" +
"        <button type=\"submit\" name=\"log\" id=\"sup\" value=\"Sign Up\" >Sign Up</button>\n" +
"        <br><br>        \n" +
"  \n" +
"    </form>  \n" +
"    </body>\n" +
"</html>");
              
                }
            }
            else
            {
                out.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>WEEK 2</title>\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n" +
"    </head>\n" +
"    <body align=\"center\">\n" + "<img src=\"13.png\" width=\"270\" height=\"270\">"+
"        <form id=\"login1\" method=\"get\" action=\"signupprocedure.html\">    \n" +
         "<h4 align=\"center\">&emsp;No User Found&emsp;Please Sign Up!</h4>"+
"        <label><b>User Name  &emsp;</label>    \n" +
"        <input type=\"text\" name=\"Uname\" id=\"Uname\" placeholder=\"Username\">    \n" +
"        <br><br>    \n" +
"        <label><b>Password &emsp;&nbsp;    \n" +
"        </label>    \n" +
"        <input type=\"Password\" name=\"Pass\" id=\"Pass\" placeholder=\"Password\">    \n" +
"        <br><br>    \n" +
"        <button type=\"submit\" name=\"log\" id=\"sin\" value=\"Sign In\" formaction=\"CourseReg\">Sign In </button>\n" +
"        <button type=\"submit\" name=\"log\" id=\"sup\" value=\"Sign Up\" >Sign Up</button>\n" +
"        <br><br>        \n" +
"  \n" +
"    </form>  \n" +
"    </body>\n" +
"</html>");
            
           
            out.close();
            }
    
    
   }
}
}
