package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Success extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String username = req.getParameter("uname");
        String rollno = req.getParameter("rollno");
        String year = req.getParameter("year");
        String semester = req.getParameter("semester");
        String course = req.getParameter("course");
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "password");
    		String query = "INSERT INTO courses (Username, Rollno, Yearr, Semester, Course) values(?, ?, ?, ?, ?)";
    		PreparedStatement ps = con.prepareStatement(query);
    		
    		ps.setString(1, username);
    		ps.setString(2, rollno);
    		ps.setString(3, year);
    		ps.setString(4, semester);
    		ps.setString(5, course);
    		
    		ps.executeUpdate();
    		out.println("Course registration successfull");
        } catch (Exception e) {
        	out.println("Course registration failed");
        }
        

        

    }
}
