package db.mysql;

import beans.Employ;

import java.util.ArrayList;


/**
 * Created by mihail on 04.04.17.
 */
public class EmployQuery extends MySqlConnect {

    public Employ createEmploy(Employ employ) throws Exception {

        String date = employ.getDate().getYear() + "-" + (employ.getDate().getMonth() + 1) + "-" + employ.getDate().getDate();
        connection = connectDB();
        statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO employs VALUES (0," + employ.getIdDepartment() + ",'" + employ.getName() +
                "','" + employ.getEmail() + "'," + employ.getNumber() + ",'" + date + "')");
        closeConnection();
        long employId = getIdByEmail(employ.getName());
        employ.setId(employId);
        return employ;
    }

    public void deleteEmployById(String id) throws Exception {
        connection = connectDB();
        statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM employs WHERE id=" + id);
        connection.close();
    }

    public Employ updateEmploy(Employ employ) throws Exception {
        String date = employ.getDate().getYear() + "-" + (employ.getDate().getMonth() + 1) + "-" + employ.getDate().getDate();

        connection = connectDB();
        statement = connection.createStatement();
        statement.executeUpdate("UPDATE employs SET idDepartment = '" + employ.getIdDepartment() + "', name='" +
                employ.getName() + "', email='" + employ.getEmail() + "', number=" + employ.getNumber() + ", date='" +
                date + "' WHERE id=" + employ.getId());

        employ = getEmployById(employ.getId() + "");

        closeConnection();
        return employ;
    }

    public long getIdByEmail(String email) throws Exception {
        connection = connectDB();
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM employs WHERE email = '" + email + "'");
        if (resultSet.next()) {
            long id = resultSet.getLong("id");
            closeConnection();
            return id;
        }
        closeConnection();
        return 0;
    }

    public ArrayList getEmploysInDepartment(long departmentId) throws Exception {
        ArrayList<Employ> employs = new ArrayList<Employ>();

        connection = connectDB();
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM employs WHERE idDepartment = " + departmentId);

        while (resultSet.next()) {
            Employ employ = new Employ();
            employ.setId(resultSet.getLong("id"));
            employ.setIdDepartment(departmentId);
            employ.setName(resultSet.getString("name"));
            employ.setEmail(resultSet.getString("email"));
            employ.setNumber(resultSet.getInt("number"));
            employ.setDate(resultSet.getDate("date"));
            employs.add(employ);
        }

        closeConnection();

        return employs;
    }

    public Employ getEmployByName(String name) throws Exception {
        connection = connectDB();
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM employs WHERE name = '" + name + "'");
        if (resultSet.next()) {
            Employ employ = new Employ();

            employ.setId(resultSet.getLong("id"));
            employ.setIdDepartment(resultSet.getLong("idDepartment"));
            employ.setName(resultSet.getString("name"));
            employ.setEmail(resultSet.getString("email"));
            employ.setNumber(resultSet.getInt("number"));
            employ.setDate(resultSet.getDate("date"));

            closeConnection();
            return employ;
        }

        closeConnection();
        return null;
    }

    public Employ getEmployById(String id) throws Exception {
        connection = connectDB();
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM employs WHERE id =" + id);
        if (resultSet.next()) {
            Employ employ = new Employ();

            employ.setId(resultSet.getLong("id"));
            employ.setIdDepartment(resultSet.getLong("idDepartment"));
            employ.setName(resultSet.getString("name"));
            employ.setEmail(resultSet.getString("email"));
            employ.setNumber(resultSet.getInt("number"));
            employ.setDate(resultSet.getDate("date"));

            closeConnection();
            return employ;
        }

        closeConnection();
        return null;
    }

}
