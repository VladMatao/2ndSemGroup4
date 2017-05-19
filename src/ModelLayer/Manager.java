package ModelLayer;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class Manager extends Person{
    private String password;

    public Manager(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage, String password) {
        super(id, f_name, l_name, CNP, address, phNr, city, position, wage);
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
