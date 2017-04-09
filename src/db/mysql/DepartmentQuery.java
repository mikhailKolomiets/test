package db.mysql;

import beans.Department;

import java.util.ArrayList;

/**
 * Created by mihail on 01.04.17.
 */
public class DepartmentQuery extends MySqlConnect {

    public String addNewDepartment(String name) throws Exception {
        connection = connectDB();
        statement = connection.createStatement();
        String sql = "INSERT INTO departments VALUES (0, '" + name + "')";
        statement.executeUpdate(sql);
        closeConnection();
        return null;
    }

    public ArrayList<Department> getAllDepartments() throws Exception {
        ArrayList<Department> departments = new ArrayList<Department>();

        connection = connectDB();
        statement = connection.createStatement();
        String sql = "SELECT * FROM departments";
        resultSet = statement.executeQuery(sql);
        if (!resultSet.next()) {
            closeConnection();
            return null;
        }
        do {
            Department department = new Department();
            department.setId(resultSet.getLong("id"));
            department.setName(resultSet.getString("name"));
            departments.add(department);
        }
        while (resultSet.next());
        closeConnection();
        return departments;
    }

    /**
     * @param name
     * @return true if name is present
     * @throws Exception
     */
    public boolean findDepartmentByName(String name) throws Exception {

        connection = connectDB();
        statement = connection.createStatement();
        String sql = "SELECT * FROM departments WHERE name = '" + name + "'";
        resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            closeConnection();
            return true;
        }
        closeConnection();
        return false;
    }

    public Department findDepartmentById(long id) throws Exception {
        connection = connectDB();
        statement = connection.createStatement();
        String sql = "SELECT * FROM departments WHERE id = '" + id + "'";
        resultSet = statement.executeQuery(sql);
        Department department = new Department();
        if (resultSet.next()) {
            department.setId(resultSet.getLong("id"));
            department.setName(resultSet.getString("name"));
        }
        closeConnection();
        return department;
    }

    public void changeDepartmentName(String name, long id) throws Exception {
        connection = connectDB();
        statement = connection.createStatement();
        statement.executeUpdate("UPDATE departments SET name = '" + name
                + "' WHERE id=" + id);
        closeConnection();
    }

    public void deleteDepartmentById(String idDepartment) throws Exception {
        connection = connectDB();
        statement = connection.createStatement();
        statement.executeUpdate("UPDATE employs SET idDepartment = 0 WHERE idDepartment=" + idDepartment);
        statement.executeUpdate("DELETE FROM departments WHERE id=" + idDepartment);
        connection.close();
    }
}
