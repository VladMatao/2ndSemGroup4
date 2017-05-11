package DBLayer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

/**
 * Created by Vlad Mataoanu.
 */
public class DBConnectionTest {
    private DBConnection connection;

    @Before
    public void initialize() throws Exception{
        connection = DBConnection.getInstance();
    }
    @Test
    public void test() throws Exception{
        assertNotNull("Connected - connection cannot be null", connection);

        DBConnection.closeConnection();
        boolean wasNullified = (DBConnection.getDBcon()==null);
        assertTrue("Disconnected - instance set to null", wasNullified);
    }

    @After
    public void closeCOnn() throws Exception{
        DBConnection.closeConnection();
    }
}