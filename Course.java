package app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Course extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("text/html");

        String user = req.getParameter("uname");

        PrintWriter out = res.getWriter();

        if (user == null || user.isEmpty()) {
            out.println("denied");
            res.sendRedirect("login");
        }
        
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
        out.println("WELCOME " + user);
        out.print("<form action='success' method='post'>");
        out.print("<input type='hidden' name='uname' class='form-control' value='" + user + "'>");
        out.print("<br>Username:<input type='text' name='usernae' class='form-control' value='" + user + "' readonly>");
        out.print("<br>RollNo:<input type='text' class='form-control' name='rollno'>");
        out.print("<br>Year:<input type='text' class='form-control' name='year'>");
        out.print("<br>Semester:<input type='text' class='form-control' name='semester'>");
        out.print("<br>Course:<input type='text' class='form-control' name='course'>");

        out.print("<br><input class='btn btn-primary' type='submit' value='submit'>");
        out.print("</form>");
        out.print("<div>");
        
        out.print("</body>\n"
        		+ "</html>");

        out.close();

    }
}
