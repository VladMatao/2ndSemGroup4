package db.layer;

import model.layer.Company;
import org.junit.*;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompanyDbTest {
    private CompanyDb companyDb;
    @Before
    public void setUp(){
        companyDb =new CompanyDb();
    }

    @Test
    public void testA_create() throws Exception {
        companyDb.create("1","NuFuramSRL","91919191","nu_furam@smr.com","Client","123 st");
        assertNotNull(companyDb.read("1"));
    }

    @Test
    public void testB_update() throws Exception {
        Company company = new Company("2","PeBune","12121212","peBune@smr.com","Supplier","456 st");
        assertNotNull(companyDb.read("1"));
        companyDb.update(company,"1");
        assertNotNull(companyDb.read("2"));
    }

    @Test
    public void testC_read() throws Exception {
        assertNotNull(companyDb.read("2"));
    }

    @Test
    public void testD_delete() throws Exception {
        companyDb.delete("1");
        assertNull(companyDb.read("1"));
    }
}