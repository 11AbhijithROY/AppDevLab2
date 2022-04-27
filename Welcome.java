import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Welcome extends jakarta.servlet.http.HttpServlet {

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
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            String n=request.getParameter("Uname");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head> <title>"
                    + "Servlet CourseReg</title><link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"></head>");
            out.println("<body><form id=\"login\" method=\"get\" action=\"Lastimage.html\">  \n" +
"        <h1 align=\"center\">Welcome" + " " + n + "</h1>\n" +
"        <input type=\"hidden\" name=\"Uname\" id=\"Uname\" value="+n+">\n" +
"        <br>\n");    
            out.println("</body>");
            out.println("</html>");
            out.close(); 
            
        }        } 
        }
        
        
    




  



 
