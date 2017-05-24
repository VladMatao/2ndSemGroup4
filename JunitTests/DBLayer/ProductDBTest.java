package DBLayer;

import ModelLayer.Product;
import org.junit.*;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDBTest {
    private ProductDB productDB;
    private ProductLineDB productLineDB;
    @Before
    public void setUp(){
        productDB=new ProductDB();
        productLineDB=new ProductLineDB();
    }

    @Test
    public void testA_create() throws Exception {
        productDB.create("nike", "2", 1.5, 10, 100, "1");
        assertNotNull(productDB.read("2"));
    }

    @Test
    public void testB_update() throws Exception {
        Product product = new Product("test", "4", 3.5, 12, 25, "4");
        assertNotNull(productDB.read("2"));
        productDB.update(product,"2");
        assertNotNull(productDB.read("4"));
    }

    @Test
    public void testC_read() throws Exception {
        assertNotNull(productDB.read("4"));
    }

    @Test
    public void testD_delete() throws Exception {
        productDB.delete("2");
        assertNull(productDB.read("2"));
    }

    @Test
    public void testE_productLineDBTest() throws Exception {
        productLineDB.create("1",10,"2");
        productLineDB.create("1",20,"4");
        productLineDB.deleteProductFromProductLine("1","2");
    }
}