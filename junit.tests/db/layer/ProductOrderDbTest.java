package db.layer;

import model.layer.ProductOrder;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductOrderDbTest {

    private ProductOrderDb productOrderDb;

    @Before
    public void setUp() {
        productOrderDb = new ProductOrderDb();
    }

    @Test
    public void testA_create() throws Exception {
        productOrderDb.create("1", 10.3, "bun", "10", "1", "222",100.12);
        assertNotNull(productOrderDb.read("1"));
    }

    @Test
    public void testB_update() throws Exception {
        ProductOrder productOrder = new ProductOrder("1", "12", "update", 111, "1",123.123, "123");
        assertNotNull(productOrderDb.read("1"));
        productOrderDb.update(productOrder, "1");
        assertEquals("update", productOrderDb.read("1").getOrderStatus());
        assertEquals("123", productOrderDb.read("1").getProductLineId());
    }

    @Test
    public void testC_read() throws Exception {
        assertNotNull(productOrderDb.read("1"));
    }

    @Test
    public void testD_delete() throws Exception {
        productOrderDb.delete("1");
        assertNull(productOrderDb.read("1"));
    }
}


