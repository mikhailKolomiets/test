package controller.departments;

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

            new DepartmentQuery().deleteDepartmentById(idDepartment);

        } catch (Exception e) {

        }
        resp.sendRedirect("/");
    }
}
