package control.layer;

import db.layer.CompanyDb;
import model.layer.Company;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ManageCompany {
    private final CompanyDb companyDb;

    public ManageCompany() {
        companyDb = new CompanyDb();
    }

    public void create(String id, String name, String phNr, String email, String companyType, String address) {
        companyDb.create(id, name, phNr, email, companyType, address);
    }

    public void update(String id, String name, String phNr, String email, String companyType, String address) {
        Company company = new Company(id, name, phNr, email, companyType, address);
        companyDb.update(company, id);
    }

    public ArrayList<Company> readAll() {
        ArrayList<Company> allcompanies = null;
        try {
            allcompanies = companyDb.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allcompanies;
    }


    public void delete(String id) {
        try {
            companyDb.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
