package db.layer;

import model.layer.Employee;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDbTest {
    private EmployeeDb employeeDb;
    @Before
    public void setUp(){
        employeeDb =new EmployeeDb();
    }

    @Test
    public void testA_create() throws Exception {
        employeeDb.create("1","gica","ionnel",197123,"strada","9123","Vaslui","Employee",22.5,"Vidanjor");
        assertNotNull(employeeDb.read("1"));
    }

    @Test
    public void testB_update() throws Exception {
        Employee employee = new Employee("1","update","update",111,"vej","123","Rahat","Rahat",33.4,"mare");
        assertNotNull(employeeDb.read("1"));
        employeeDb.update(employee,"1");
        assertEquals("update", employeeDb.read("1").getF_name());
    }

    @Test
    public void testC_read() throws Exception {
        assertNotNull(employeeDb.read("1"));
    }

    @Test
    public void testD_delete() throws Exception {
        employeeDb.delete("1");
        assertNull(employeeDb.read("1"));
    }

}