package ControlLayer;

import DBLayer.CompanyDB;
import ModelLayer.Company;

import java.sql.SQLException;
/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ManageCompany {
    private CompanyDB companyDb;

    public ManageCompany() {
        companyDb = new CompanyDB();
    }

    public boolean create(String id, String name, String phNr, String email, String companyType, String address){
        try {
            companyDb.create(id,name,phNr,email,companyType,address);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Company read(String id){
        Company company = null;
        try {
            company = companyDb.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }

    public boolean update(Company company,String id){

        try {
            return companyDb.update(company,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id){
        boolean aux = false;
        try {
            aux = companyDb.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aux;
    }
}
