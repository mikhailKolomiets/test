package controller.employes;

import beans.Employ;
import beans.InputData;
import db.mysql.EmployQuery;
import validation.EmployCreateValidation;
import validation.EmployEditValidation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mihail on 08.04.17.
 */
@WebServlet(urlPatterns = "/edit-employ/*")
public class EditEmploy extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            Employ employ = new EmployQuery().getEmployById(req.getPathInfo().substring(1));

            req.setAttribute("employ", employ);
            req.getRequestDispatcher("/edit-employ.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        try {
            Employ employ = new EmployQuery().getEmployById(req.getPathInfo().substring(1));

            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String number = req.getParameter("number");
            String date = req.getParameter("date");
            String message;

            if (email.equals(employ.getEmail()))
                message = EmployEditValidation.check(name, email, number, date);
            else
                message = EmployCreateValidation.check(name, email, number, date);

            if (message == null) {

                employ.setName(name);
                employ.setEmail(email);
                employ.setNumber(Integer.valueOf(number));
                employ.setDate(date);

                employ = new EmployQuery().updateEmploy(employ);

                resp.sendRedirect("/department/" + employ.getIdDepartment() + "?idEmploy=" + employ.getId());
            } else {
                InputData inputData = new InputData();

                inputData.setName(name);
                inputData.setEmail(email);
                inputData.setNumber(number);
                inputData.setDate(date);

                req.setAttribute("employ", employ);
                req.setAttribute("inputData", inputData);
                req.setAttribute("message", message);
                req.getRequestDispatcher("/edit-employ.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("/");
        }
    }
}
