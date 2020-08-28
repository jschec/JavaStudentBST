import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test for the Student class
 *
 * @author      Joshua Scheck
 * @version     2020-07-26
 */
public class StudentTest {

    /**
     * Default constructor for StudentTest class
     */
    public StudentTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }

    //--------------------------------------------------------------
    //      General Tests
    //--------------------------------------------------------------
    @Test
    public void testConstructorAndGets() {
        Student testStudent = new Student("ABC-2486", "Dylan, Bob");

        assertEquals("ABC-2486", testStudent.getId());
        assertEquals("Dylan, Bob", testStudent.getName());
    }

    @Test
    public void testCompareTo() {
        Student testStudent1 = new Student("ABC-2486", "Dylan, Bob");
        Student testStudent2 = new Student("ABC-2486", "Hendrix, Jimi");
        Student testStudent3 = new Student("DAG-9845", "Young, Angus");
        Student testStudent4 = new Student("ABC-1234", "McCartney. Paul");

        assertEquals(testStudent1.compareTo(testStudent2), 0);
        assertTrue(testStudent1.compareTo(testStudent3) < 0);
        assertTrue(testStudent1.compareTo(testStudent4) > 0);
    }

    @Test
    public void testToString() {
        Student testStudent1 = new Student("ABC-2486", "Dylan, Bob");
        Student testStudent2 = new Student("DAG-9845", "Young, Angus");

        assertEquals(testStudent1.toString(), 
        "Student{id='ABC-2486', name='Dylan, Bob'}");
        assertEquals(testStudent2.toString(), 
        "Student{id='DAG-9845', name='Young, Angus'}");
    }

    //--------------------------------------------------------------
    //      Precondition Tests
    //--------------------------------------------------------------
    @Test (expected = IllegalArgumentException.class)
    public void testConstrIdNull() { Student testStudent = new Student(null, 
        "Dylan, Bob"); }

    @Test (expected = IllegalArgumentException.class)
    public void testConstrIdEmpty() {
        Student testStudent = new Student("", "Dylan, Bob");
    }
}
