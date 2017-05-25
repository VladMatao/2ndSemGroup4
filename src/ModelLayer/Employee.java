package ModelLayer;

import java.util.Date;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class Employee extends Person{
    private String department;

    public Employee(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage, String department) {
        super(id, f_name, l_name, CNP, address, phNr, city, position, wage);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
