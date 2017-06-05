package db.layer;

import model.layer.Company;

import java.sql.SQLException;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
interface CompanyDbIf {

    void create(String id, String name, String phNr, String email, String companyType, String address);

    boolean update(Company company, String id);

    boolean delete(String id) throws SQLException;

    Company read(String id) throws SQLException;
}
