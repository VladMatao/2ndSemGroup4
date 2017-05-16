package DBLayer;

        import ModelLayer.Company;

        import java.sql.SQLException;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public interface  CompanyDBIF {

    void create(String id, String name, String phNr, String email, String companyType, String address) throws SQLException;
    boolean update (Company company, String id ) throws SQLException;
    boolean delete (String id) throws SQLException;
    Company read(String id) throws SQLException;
}
