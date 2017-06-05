package model.layer;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class Person {
    private final String id;
    private final String f_name;
    private final String l_name;
    private final int CNP;
    private final String address;
    private final String phNr;
    private final String city;
    private final String position;
    private final double wage;

    public Person(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage) {
        this.id = id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.CNP = CNP;
        this.address = address;
        this.phNr = phNr;
        this.city = city;
        this.position = position;
        this.wage = wage;
    }

    public String getId() {
        return id;
    }

    public String getF_name() {
        return f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public int getCNP() {
        return CNP;
    }

    public String getAddress() {
        return address;
    }

    public String getPhNr() {
        return phNr;
    }

    public String getCity() {
        return city;
    }

    public String getposition() {
        return position;
    }

    public double getWage() {
        return wage;
    }

}
