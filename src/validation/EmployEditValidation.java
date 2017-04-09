package validation;

import beans.Employ;

/**
 * Created by mihail on 08.04.17.
 */
public class EmployEditValidation {
    public static String check(String name, String email, String number, String date) {
        if (name.length() == 0)
            return "name is empty";

        if (name.length() > 100)
            return "name is so long";

        if (number.length() > 20)
            return "number is so long";

        String[] partEmail = email.split("@| ");
        if (partEmail.length != 2 || partEmail[1].split("\\.").length != 2) {
            return "incorrect e-mail";
        }

        try {
            Employ employ = new Employ();
            employ.setDate(date);
            if (employ.getDate() == null) {
                return "date input incorrect, please formatting by DD-MM-YYYY";
            }
        } catch (Exception e) {
            return e.toString();
        }

        return null;
    }
}
