package ControlLayer;
import DBLayer.*;
import ModelLayer.*;
import java.sql.SQLException;
/**
 * Created by Group 4  on 09.05.2017.
 */
public class CompanyController {
    CompanyDB companyDb;

    public CompanyController() {
        companyDb = new CompanyDB();
    }

    public boolean create(String id, String name, String phNr, String email, String companyType, String adress){
        try {
            companyDb.create(id,name,phNr,email,companyType,adress);
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

    public boolean update(Company company){

        try {
            return companyDb.update(company);
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
