package validation;

import db.mysql.EmployQuery;

/**
 * Created by mihail on 05.04.17.
 */
public class EmployCreateValidation {

    public static String check(String name, String email, String number, String date) {

        String editValidation = EmployEditValidation.check(name, email, number, date);

        if (editValidation != null)
            return editValidation;

        try {
            if (new EmployQuery().getIdByEmail(email) != 0) {
                return "Employ with email " + email + " is present";
            }
        } catch (Exception e) {
            return e.toString();
        }

        return null;
    }
}
