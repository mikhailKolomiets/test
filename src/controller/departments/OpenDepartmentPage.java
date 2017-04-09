package controller.departments;

import beans.Department;
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
 * Created by mihail on 03.04.17.
 */
@WebServlet(urlPatterns = "/department/*")
public class OpenDepartmentPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number = req.getPathInfo().substring(1);

        try {
            Department department = new DepartmentQuery().findDepartmentById(new Long(number));
            if (department == null) {
                resp.sendRedirect("/");
            } else {
                ArrayList employs  = new EmployQuery().getEmploysInDepartment(new Long(number));

                if(req.getParameter("idEmploy") != null) {
                    req.setAttribute("viewEmploy", new Long(req.getParameter("idEmploy")));
                }

                req.setAttribute("employs", employs);
                req.setAttribute("department", department);
                req.getRequestDispatcher("/department-page.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
