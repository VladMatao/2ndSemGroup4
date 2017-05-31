package db.layer;

import model.layer.Product;
import org.junit.*;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDbTest {
    private ProductDb productDb;
    private ProductLineDb productLineDb;
    @Before
    public void setUp(){
        productDb =new ProductDb();
        productLineDb =new ProductLineDb();
    }

    @Test
    public void testA_create() throws Exception {
        productDb.create("nike", "2", 1.5, 10, 100, "1");
        assertNotNull(productDb.read("2"));
    }

    @Test
    public void testB_update() throws Exception {
        Product product = new Product("test", "4", 3.5, 12, 25, "4");
        assertNotNull(productDb.read("2"));
        productDb.update(product,"2");
        assertNotNull(productDb.read("4"));
    }

    @Test
    public void testC_read() throws Exception {
        assertNotNull(productDb.read("4"));
    }

    @Test
    public void testD_delete() throws Exception {
        productDb.delete("2");
        assertNull(productDb.read("2"));
    }

    @Test
    public void testE_productLineDBTest() throws Exception {
        productLineDb.create("1",10,"2");
        productLineDb.create("1",20,"4");
        productLineDb.deleteProductFromProductLine("1","2");
    }
}