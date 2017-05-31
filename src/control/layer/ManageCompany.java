package control.layer;

import db.layer.CompanyDb;
import model.layer.Company;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public class ManageCompany {
    private CompanyDb companyDb;

    public ManageCompany() {
        companyDb = new CompanyDb();
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

    public boolean update(String id, String name, String phNr, String email, String companyType, String address){
        Company company = new Company(id, name, phNr, email, companyType, address);
        try {
            return companyDb.update(company,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<Company> readAll(){
    	ArrayList<Company> allcompanies = null;
    	try {
    		allcompanies = companyDb.readAll();
    	} catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	return allcompanies;
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
