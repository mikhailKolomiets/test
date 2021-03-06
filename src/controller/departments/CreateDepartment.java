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
 * Created by mihail on 02.04.17.
 */
@WebServlet(urlPatterns = "/create-department")
public class CreateDepartment extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf8");
        String name = req.getParameter("departmentName");

        try {
            String validationMassage = DepartmentCreateValidation.check(name);
            if(validationMassage == null) {
                new DepartmentQuery().addNewDepartment(name);
                ArrayList<Department> departments = new DepartmentQuery().getAllDepartments();
                req.setAttribute("departments", departments);
                req.setAttribute("message", "Department " + name + " success create");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
            else {
                req.setAttribute("dangerMessage", validationMassage);
                req.setAttribute("name", name);
                req.getRequestDispatcher("/create-department.jsp").forward(req,resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
