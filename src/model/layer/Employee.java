package model.layer;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class Employee {
    private String id;
    private String f_name;
    private String l_name;
    private int CNP;
    private String address;
    private String phNr;
    private String city;
    private String position;
    private double wage;
    private String department;

    public Employee(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage, String department) {
        this.id = id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.CNP = CNP;
        this.address = address;
        this.phNr = phNr;
        this.city = city;
        this.position = position;
        this.wage = wage;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public int getCNP() {
        return CNP;
    }

    public void setCNP(int CNP) {
        this.CNP = CNP;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhNr() {
        return phNr;
    }

    public void setPhNr(String phNr) {
        this.phNr = phNr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getposition() {
        return position;
    }

    public void setposition(String position) {
        this.position = position;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
