package DBLayer;

import ModelLayer.Company;

import java.sql.SQLException;

/**
 * Created by Admin on 3/29/2017.
 */
public interface  CompanyDBIF {

    boolean create(String id, String name, String phNr, String email, String companyType, String address) throws SQLException;
    boolean update (Company company ) throws SQLException;
    boolean delete (String id) throws SQLException;
    Company read(String id) throws SQLException;
}
