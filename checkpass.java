import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class checkpass extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
  protected void processResponse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            String n=request.getParameter("Uname");
            String pass=request.getParameter("Pass");
            out.println("<html><head></head><body>");
            out.println("</body></html>");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaServ","root","Ojun04864@");
            Statement stm = conn.createStatement();
            ResultSet rs=stm.executeQuery("select * from user where name=\""+n+"\"");
            if(rs.next())
            {
                String rpass=rs.getString("password");
                if(rpass.equals(pass))
                {
                    out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head> <title>"
                    + "Servlet CourseReg</title><link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"></head>");
            out.println("<body><form id=\"login\" method=\"get\" action=\"\">  \n" +
"        <h1>Welcome +  </h1>\n" +
"        <label><b>User Name&emsp;&emsp;&emsp;&nbsp;</label>    \n" +
"        <input type=\"text\" name=\"Uname\" id=\"Uname\" placeholder=\"Username\">    \n" +
"        <br>\n" +
"        \n" +
"        <label><b>Roll Number&emsp;&emsp;&nbsp;&nbsp;</label>    \n" +
"        <input type=\"text\" name=\"Uname\" id=\"Uname\" placeholder=\"Username\">    \n" +
"        <br>\n" +
"        \n" +
"        <label><b>Year&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;</label>    \n" +
"        <input type=\"text\" name=\"Uname\" id=\"Uname\" placeholder=\"Username\">    \n" +
"        <br>\n" +
"        \n" +
"        <label><b>Semester&emsp;&emsp;&emsp;&emsp;</label>    \n" +
"        <input type=\"text\" name=\"Uname\" id=\"Uname\" placeholder=\"Username\">    \n" +
"        <br>\n" +
"        \n" +
"        <label><b>Course&emsp;&emsp;&emsp;&emsp;&emsp;</label>    \n" +
"        <input type=\"text\" name=\"Uname\" id=\"Uname\" placeholder=\"Username\">    \n" +
"        <br>\n" +
"        \n" +
"        <label><b>Password &emsp;&nbsp;&emsp;&emsp;</label>    \n" +
"        <input type=\"Password\" name=\"Pass\" id=\"Pass\" placeholder=\"Password\">    \n" +
"        <br><br>   \n" +
"        \n" +
"        <button type=\"submit\" name=\"log\" id=\"sin\" value=\"Sign In\" formaction=\"Regist.html\">Sign In </button>&emsp;&emsp;&emsp;&emsp;&emsp;\n" +
"        <button type=\"submit\" name=\"log\" id=\"sup\" value=\"Sign Up\" >Sign Up</button>\n" +
"        <br><br>        \n" +
"  \n" +
"    </form>");
              
      
            out.println("</body>");
            out.println("</html>");
                }
                else
                {
                    out.println("wrong password");
                }
            }
            else
            {
                out.println("No user Found");
            }
            out.close(); 
            
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}