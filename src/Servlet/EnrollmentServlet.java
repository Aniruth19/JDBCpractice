package Servlet;

import Dao.EnrollmentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/enrollStudent")
public class EnrollStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            int studentId = Integer.parseInt(req.getParameter("studentId"));
            int courseId = Integer.parseInt(req.getParameter("courseId"));
            new EnrollmentDAO().enrollStudent(studentId, courseId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        res.sendRedirect("enroll-student.html");
    }
}
