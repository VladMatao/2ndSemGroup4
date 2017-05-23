package DBLayer;

import ModelLayer.Employee;
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
public class EmployeeDBTest {
    private EmployeeDB employeeDB;
    @Before
    public void setUp(){
        employeeDB=new EmployeeDB();
    }

    @Test
    public void testA_create() throws Exception {
        employeeDB.create("1","gica","ionnel",197123,"strada","9123","Vaslui","Employee",22.5,"Vidanjor");
        assertNotNull(employeeDB.read("1"));
    }

    @Test
    public void testB_update() throws Exception {
        Employee employee = new Employee("1","update","update",111,"vej","123","Rahat","Rahat",33.4,"mare");
        assertNotNull(employeeDB.read("1"));
        employeeDB.update(employee,"1");
        assertEquals("update",employeeDB.read("1").getF_name());
    }

    @Test
    public void testC_read() throws Exception {
        assertNotNull(employeeDB.read("1"));
    }

    @Test
    public void testD_delete() throws Exception {
        employeeDB.delete("1");
        assertNull(employeeDB.read("1"));
    }

}