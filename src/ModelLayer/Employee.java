package ModelLayer;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by Vlad Mataoanu on 03.05.2017.
 */
public class Employee extends Person{

    private Date schedule;
    private String department;

    public Employee(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage, Date schedule, String department) {
        super(id, f_name, l_name, CNP, address, phNr, city, position, wage);
        this.schedule=schedule;
        this.department=department;
    }

    public Date getSchedule() {
        return schedule;
    }

    public void setSchedule(Date schedule) {
        this.schedule = schedule;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
