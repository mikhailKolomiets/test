package controller.departments;

import beans.Department;
import db.mysql.DepartmentQuery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mihail on 08.04.17.
 */
@WebServlet(urlPatterns = "/delete-department/*")
public class DeleteDepartment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String idDepartment = req.getPathInfo().substring(1);
            Department department = new DepartmentQuery().findDepartmentById(new Long(idDepartment));

            new DepartmentQuery().deleteDepartmentById(idDepartment);

            req.setAttribute("message", department.getName() + " success deleted");
            req.getRequestDispatcher("/").forward(req,resp);
        } catch (Exception e) {
            resp.sendRedirect("/");
        }
    }
}
