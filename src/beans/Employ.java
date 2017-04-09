package beans;

import java.util.Date;

/**
 * Created by mihail on 04.04.17.
 */
public class Employ {
    private long id;
    private long idDepartment;
    private String name;
    private String email;
    private int number;
    private Date date = new Date();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(long idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDate(String dateTypeString) throws Exception {
        String[] date = dateTypeString.split("-|/|\\.| ");

        if (date.length != 3) {
            this.date = null;
        }
        else if(date[0].length() != 2 || date[1].length() != 2 || date[2].length() != 4){
            this.date = null;
        }else {
            this.date.setDate(Integer.valueOf(date[0]));
            this.date.setMonth(Integer.valueOf(date[1]) - 1);
            this.date.setYear(Integer.valueOf(date[2]));
        }
    }

    public Date correctDate() {
        this.date.setYear(this.date.getYear() + 1900);
        return this.date;
    }
}
