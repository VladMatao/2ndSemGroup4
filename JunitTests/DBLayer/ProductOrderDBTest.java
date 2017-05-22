package DBLayer;

import ModelLayer.ProductOrder;
import ModelLayer.Person;
import ModelLayer.Product;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductOrderDBTest {

    private ProductOrderDB productOrderDB;

    @Before
    public void setUp() {
        productOrderDB = new ProductOrderDB();
    }

    @Test
    public void testA_create() throws Exception {
        productOrderDB.create("1", 10.3, "bun", "10", "1", "222");
        assertNotNull(productOrderDB.read("1"));
    }

    @Test
    public void testB_update() throws Exception {
        ProductOrder productOrder = new ProductOrder("1", "12", "update", 111, "1", "123");
        assertNotNull(productOrderDB.read("1"));
        productOrderDB.update(productOrder, "1");
        assertEquals("update", productOrderDB.read("1").getOrderStatus());
    }

    @Test
    public void testC_read() throws Exception {
        assertNotNull(productOrderDB.read("1"));
    }

    @Test
    public void testD_delete() throws Exception {
        productOrderDB.delete("1");
        assertNull(productOrderDB.read("1"));
    }
}


