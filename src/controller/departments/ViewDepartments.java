package controller.departments;

import beans.Department;
import db.mysql.DepartmentQuery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mihail on 02.04.17.
 */
@WebServlet(urlPatterns = "/")
public class ViewDepartments extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Department> departments = new ArrayList<Department>();
        try {
            departments = new DepartmentQuery().getAllDepartments();
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("departments", departments);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
