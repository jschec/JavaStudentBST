import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test the SearchTreeSet class
 *
 * @author      Joshua Scheck
 * @version     2020-07-26
 */
public class SearchTreeSetTest {
    private SearchTreeSet<Integer> testTreeOne;
    private SearchTreeSet<Integer> testTreeTwo;
    private SearchTreeSet<Integer> testTreeThree;

    /**
     * Default constructor for SearchTreeSetTest class
     */
    public SearchTreeSetTest() {
        testTreeOneSetUp();
        testTreeTwoSetUp();
        testTreeThreeSetUp();
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
     * Assigns values to testTreeOne Search tree set
     *
     * 8 unique values; 2 duplicates
     */
    private void testTreeOneSetUp() {
        testTreeOne = new SearchTreeSet<Integer>();
        testTreeOne.add(82);
        testTreeOne.add(100);
        testTreeOne.add(74);
        testTreeOne.add(11);
        testTreeOne.add(26);
        testTreeOne.add(1);
        testTreeOne.add(34);
        testTreeOne.add(1);
        testTreeOne.add(100);
        testTreeOne.add(9);
    }

    /**
     * Assigns values to testTreeTwo Search tree set
     *
     * 1 unique values; 10 duplicates
     */
    private void testTreeTwoSetUp() {
        testTreeTwo = new SearchTreeSet<Integer>();
        testTreeTwo.add(1);
        testTreeTwo.add(1);
        testTreeTwo.add(1);
        testTreeTwo.add(1);
        testTreeTwo.add(1);
        testTreeTwo.add(1);
        testTreeTwo.add(1);
        testTreeTwo.add(1);
        testTreeTwo.add(1);
        testTreeTwo.add(1);
    }

    /**
     * Assigns values to testTreeThree Search tree set
     *
     * 10 unique values; 0 duplicates
     */
    private void testTreeThreeSetUp() {
        testTreeThree = new SearchTreeSet<Integer>();
        testTreeThree.add(79);
        testTreeThree.add(84);
        testTreeThree.add(74);
        testTreeThree.add(11);
        testTreeThree.add(25);
        testTreeThree.add(12);
        testTreeThree.add(99);
        testTreeThree.add(1);
        testTreeThree.add(17);
        testTreeThree.add(9);
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
    public void testCountNodes() {
        SearchTreeSet<Integer> emptyTree = new SearchTreeSet<Integer>();

        // test empty tree
        assertEquals(emptyTree.countNodes(), 0);

        // test tree with single node
        assertEquals(testTreeTwo.countNodes(), 1);

        // test tree with multiple nodes
        assertEquals(testTreeOne.countNodes(), 8);
        assertEquals(testTreeThree.countNodes(), 10);
    }

    @Test
    public void testContains() {
        SearchTreeSet<Integer> emptyTree = new SearchTreeSet<Integer>();

        // test empty tree
        assertFalse(emptyTree.contains(1));
        assertFalse(emptyTree.contains(null));

        // testTreeOne tests
        assertFalse(testTreeOne.contains(-1));
        assertFalse(testTreeOne.contains(111));
        assertTrue(testTreeOne.contains(82));       // overallRoot
        assertTrue(testTreeOne.contains(1));        // min value
        assertTrue(testTreeOne.contains(34));       // middle value
        assertTrue(testTreeOne.contains(100));      // max value

        // testTreeTwo tests
        assertFalse(testTreeTwo.contains(0));
        assertFalse(testTreeTwo.contains(3));
        assertFalse(testTreeTwo.contains(10));
        assertTrue(testTreeTwo.contains(1));        // only value

        // testTreeThree tests
        assertFalse(testTreeThree.contains(-11));
        assertFalse(testTreeThree.contains(101));
        assertTrue(testTreeThree.contains(79));     // overallRoot
        assertTrue(testTreeThree.contains(1));      // min value
        assertTrue(testTreeThree.contains(17));     // middle value
        assertTrue(testTreeThree.contains(99));     // max value
    }

    @Test
    public void testAdd() {
        SearchTreeSet<Integer> testTree = new SearchTreeSet<Integer>();
        testTree.add(1);
        testTree.add(9);
        testTree.add(5);
        testTree.add(11);

        // checks if correct number of nodes are added and that all
        // of the added values are contained in the search tree set
        assertEquals(testTree.countNodes(), 4);
        assertTrue(testTree.contains(1));
        assertTrue(testTree.contains(9));
        assertTrue(testTree.contains(5));
        assertTrue(testTree.contains(11));
    }


    @Test
    public void testGetInOrderList() {
        SearchTreeSet<Integer> emptyTree = new SearchTreeSet<Integer>();

        String expTreeOneOutput = "1\n9\n11\n26\n34\n74\n82\n100\n";
        String expTreeOneOutputRev = "100\n82\n74\n34\n26\n11\n9\n1\n";
        String expTreeTwoOutput = "1\n";

        // test empty tree
        assertEquals(emptyTree.getInOrderList(true), "");
        assertEquals(emptyTree.getInOrderList(false), "");

        // test tree with single node
        assertEquals(testTreeTwo.getInOrderList(true), expTreeTwoOutput);
        assertEquals(testTreeTwo.getInOrderList(false), expTreeTwoOutput);

        // test tree with multiple nodes
        assertEquals(testTreeOne.getInOrderList(true), expTreeOneOutput);
        assertEquals(testTreeOne.getInOrderList(false), expTreeOneOutputRev);
    }

    //--------------------------------------------------------------
    //      Precondition Tests
    //--------------------------------------------------------------
    @Test (expected = IllegalArgumentException.class)
    public void testAddNull() {
        SearchTreeSet<Integer> testTree = new SearchTreeSet<Integer>();
        testTree.add(null);
    }
}
