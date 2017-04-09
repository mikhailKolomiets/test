package controller.departments;

import beans.Department;
import beans.Employ;
import db.mysql.EmployQuery;
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
@WebServlet (urlPatterns = "/add-free-employ/*")
public class AddFreeEmploy extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            EmployQuery query = new EmployQuery();
            long idDepartment = new Long(req.getPathInfo().substring(1));
            String idEmploy = req.getParameter("id");

            Employ employ = query.getEmployById(idEmploy);
            employ.setIdDepartment(idDepartment);
            employ.correctDate();

            query.updateEmploy(employ);

            Department department = new DepartmentQuery().findDepartmentById(idDepartment);

            req.setAttribute("employs", query.getEmploysInDepartment(idDepartment));
            req.setAttribute("department", department);
            req.getRequestDispatcher("/department-page.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("/");
        }
    }
}
