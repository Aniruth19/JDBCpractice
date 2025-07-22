package Servlet;

import Dao.StudentDAO;
import Model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("studentName");
        if (name != null && !name.trim().isEmpty()) {
            Student student = new Student(name.trim());
            new StudentDAO().addStudent(student);
        }
        res.sendRedirect("add-student.html");
    }
}
