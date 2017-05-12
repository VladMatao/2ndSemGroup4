package ModelLayer;

import java.util.Date;

/**
 * Created by Vlad Mataoanu on 03.05.2017.
 */
public class Employee{
    Person person;
    private int id;
    private Date schedule;
    private String department;

    public Employee(String id, Date schedule, String department) {
        id = person.getId();
        this.schedule = schedule;
        this.department = department;
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
