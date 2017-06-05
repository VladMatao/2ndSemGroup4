package model.layer;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class Company {
    private final String id;
    private final String name;
    private final String phNr;
    private final String email;
    private final String companyType;
    private final String address;

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

    public String getName() {
        return name;
    }

    public String getPhNr() {
        return phNr;
    }

    public String getEmail() {
        return email;
    }

    public String getCompanyType() {
        return companyType;
    }

    public String getAddress() {
        return address;
    }

}
