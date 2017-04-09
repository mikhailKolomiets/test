package controller.departments;

import beans.Department;
import db.mysql.DepartmentQuery;
import validation.DepartmentCreateValidation;

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
@WebServlet(urlPatterns = "/edit-department/*")
public class EditDepartment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number = req.getPathInfo().substring(1);

        try {
            Department department = new DepartmentQuery().findDepartmentById(new Long(number));
            if (department == null) {
                resp.sendRedirect("/");
            } else {
                req.setAttribute("department", department);
                req.getRequestDispatcher("/edit-department.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");

        Department department = new Department();
        String departmentId = req.getParameter("id");
        String editDepartmentName = req.getParameter("name");

        try {
            String validationMessage = DepartmentCreateValidation.check(editDepartmentName);
            if (validationMessage == null) {
                DepartmentQuery departmentQuery = new DepartmentQuery();
                department = departmentQuery.findDepartmentById(new Long(departmentId));
                departmentQuery.changeDepartmentName(editDepartmentName, new Long(departmentId));

                ArrayList<Department> departments = departmentQuery.getAllDepartments();


                req.setAttribute("message", "Department " + department.getName() + " success edit to " + editDepartmentName);
                req.setAttribute("departments", departments);
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            } else {
                req.setAttribute("message", validationMessage);

                department.setId(new Long(departmentId));
                department.setName(editDepartmentName);

                req.setAttribute("department", department);
                req.getRequestDispatcher("/edit-department.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
