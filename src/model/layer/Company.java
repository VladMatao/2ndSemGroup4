package model.layer;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class Company {
    private String id;
    private String name;
    private String phNr;
    private String email;
    private String companyType;
    private String address;

    public Company(String id, String name, String phNr, String email, String companyType, String address) {
        this.id = id;
        this.name = name;
        this.phNr = phNr;
        this.email = email;
        this.companyType = companyType;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhNr() {
        return phNr;
    }

    public void setPhNr(String phNr) {
        this.phNr = phNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getcompanyType() {
        return companyType;
    }

    public void setcompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
