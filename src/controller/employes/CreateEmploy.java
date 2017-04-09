package controller.employes;

import beans.Department;
import beans.Employ;
import beans.InputData;
import db.mysql.EmployQuery;
import db.mysql.DepartmentQuery;
import validation.EmployCreateValidation;

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
@WebServlet(urlPatterns = "/create-employ/*")
public class CreateEmploy extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setCharacterEncoding("utf8");
            String idDepartment = req.getPathInfo().substring(1);
            System.out.println(idDepartment);
            ArrayList freeEmploys = new EmployQuery().getEmploysInDepartment(0);
            req.setAttribute("freeEmploys", freeEmploys);
            req.getRequestDispatcher("/create-employ.jsp?idDepartment=" + idDepartment).forward(req, resp);//todo without param!!
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("/");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Employ employ = new Employ();

        req.setCharacterEncoding("utf8");

        try {
            EmployQuery query = new EmployQuery();

            if(req.getPathInfo() == null || req.getPathInfo().length() == 0)
                employ.setIdDepartment(0);
            else
                employ.setIdDepartment(new Long(req.getPathInfo().substring(1)));

            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String number = req.getParameter("number");
            String date = req.getParameter("date");

            String validationMessage = EmployCreateValidation.check(name, email, number, date);

            if (validationMessage == null) {
                employ.setName(name);
                employ.setEmail(email);
                employ.setNumber(Integer.valueOf(req.getParameter("number")));
                employ.setDate(req.getParameter("date"));

                employ = query.createEmploy(employ);
                req.setAttribute("message", "Employ " + employ.getName() + " success created.");
                Department department = new DepartmentQuery().findDepartmentById(employ.getIdDepartment());
                ArrayList employs = query.getEmploysInDepartment(employ.getIdDepartment());


                req.setAttribute("employs", employs);
                req.setAttribute("department", department);
                req.getRequestDispatcher("/department-page.jsp").forward(req, resp);
            } else {
                InputData inputData = new InputData();
                inputData.setName(name);
                inputData.setEmail(email);
                inputData.setNumber(number);
                inputData.setDate(date);
                req.setAttribute("message", validationMessage);
                req.setAttribute("employ", inputData);

                req.getRequestDispatcher("/create-employ.jsp?idDepartment=" + employ.getIdDepartment()).forward(req,resp);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }



    }
}
