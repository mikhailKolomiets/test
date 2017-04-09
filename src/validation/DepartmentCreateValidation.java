package validation;

import db.mysql.DepartmentQuery;

/**
 * Created by mihail on 02.04.17.
 */
public class DepartmentCreateValidation {

    public static String check(String name) throws Exception{

        String result = null;

        if(name.length() == 0)
            result = "Name is empty";
        if(name.length() > 100)
            result = "Name some long";
        if(new DepartmentQuery().findDepartmentByName(name))
            result = "Name " + name + " is present";
        return result;
    }
}
