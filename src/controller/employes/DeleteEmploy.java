package controller.employes;

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
import java.util.ArrayList;

/**
 * Created by mihail on 08.04.17.
 */
@WebServlet(urlPatterns = "/delete-employ/*")
public class DeleteEmploy extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String employId = req.getPathInfo().substring(1);
        long departmentId;

        try {
            EmployQuery query = new EmployQuery();
            Employ employ = query.getEmployById(employId);
            departmentId = employ.getIdDepartment();
            int action = Integer.valueOf(req.getParameter("action"));

            if (action == 1) {
                employ.setIdDepartment(0);
                employ.correctDate();
                query.updateEmploy(employ);
            }
            if (action == 2) {
                query.deleteEmployById(employId);
            }

            Department department = new DepartmentQuery().findDepartmentById(departmentId);
            ArrayList employs = query.getEmploysInDepartment(departmentId);

            req.setAttribute("employs", employs);
            req.setAttribute("department", department);
            req.getRequestDispatcher("/department-page.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
