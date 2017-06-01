package db.layer;

import model.layer.Person;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonDbTest {
    private PersonDb personDb;

    @Before
    public void setUp() {
        personDb = new PersonDb();
    }

    @Test
    public void testA_create() throws Exception {
        personDb.create("1", "gica", "ionnel", 197123, "strada", "9123", "Vaslui", "Person", 22.5);
        assertNotNull(personDb.read("1"));
    }

    @Test
    public void testB_update() throws Exception {
        Person person = new Person("1", "update", "update", 111, "vej", "123", "Rahat", "Rahat", 33.4);
        assertNotNull(personDb.read("1"));
        personDb.update(person, "1");
        assertEquals("update", personDb.read("1").getF_name());
    }

    @Test
    public void testC_read() throws Exception {
        assertNotNull(personDb.read("1"));
    }

    @Test
    public void testD_delete() throws Exception {
        personDb.delete("1");
        assertNull(personDb.read("1"));
    }

}