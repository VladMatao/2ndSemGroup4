package DBLayer;

import ModelLayer.Company;
import ModelLayer.Product;
import org.junit.*;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompanyDBTest {
    private CompanyDB companyDB;
    @Before
    public void setUp(){
        companyDB=new CompanyDB();
    }

    @Test
    public void testA_create() throws Exception {
        companyDB.create("1","NuFuramSRL","91919191","nu_furam@smr.com","Client","123 st");
        assertNotNull(companyDB.read("1"));
    }

    @Test
    public void testB_update() throws Exception {
        Company company = new Company("2","PeBune","12121212","peBune@smr.com","Supplier","456 st");
        assertNotNull(companyDB.read("1"));
        companyDB.update(company,"1");
        assertNotNull(companyDB.read("2"));
    }

    @Test
    public void testC_read() throws Exception {
        assertNotNull(companyDB.read("2"));
    }

    @Test
    public void testD_delete() throws Exception {
        companyDB.delete("1");
        assertNull(companyDB.read("1"));
    }
}