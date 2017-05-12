package DBLayer;

import ModelLayer.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * Created by Vlad Mataoanu.
 */
public class ProductDBTest {
    @Before
    public void setUp() throws Exception {
        Connection conn = DBConnection.getInstance().getDBcon();
    }

    @After
    public void tearDown() throws Exception {
        
    }

    @Test
    public void create() throws Exception {
        new ProductDB().create("nike", "2", 1.5, 10, 100, "1");
        assertNotNull("Create() Method Failed",new ProductDB().read("2"));
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void read() throws Exception {
    }

}