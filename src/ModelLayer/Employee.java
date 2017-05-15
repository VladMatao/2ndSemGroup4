package ModelLayer;

import java.util.Date;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class Employee extends Person{
    private Date shiftOn;
    private String department;

    public Employee(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage, Date shiftOn, String department) {
        super(id, f_name, l_name, CNP, address, phNr, city, position, wage);
        this.shiftOn = shiftOn;
        this.department = department;
    }

    public Date getShiftOn() {
        return shiftOn;
    }

    public void setShiftOn(Date schedule) {
        this.shiftOn = shiftOn;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
