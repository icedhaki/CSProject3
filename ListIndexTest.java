

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ListIndexTest. Note: getters and setters untested
 *
 * @author  Henry Grote
 * @version 12/03/2020
 */
public class ListIndexTest
{
    /**
     * Default constructor for test class ListIndexTest
     */
    public ListIndexTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void size0()
    {
        ListIndex treeInde1 = new ListIndex();
        assertEquals(0, treeInde1.size());
    }

    @Test
    public void size1()
    {
        ListIndex treeInde1 = new ListIndex();
        assertEquals(true, treeInde1.searchAndAdd("hello", 0));
        assertEquals(1, treeInde1.size());
    }

    @Test
    public void searchAndAddEmptyList()
    {
        ListIndex treeInde1 = new ListIndex();
        assertEquals(true, treeInde1.searchAndAdd("a", 1));
        assertEquals(1, treeInde1.size());
    }

    @Test
    public void searchAndAddNonEmptyList()
    {
        ListIndex treeInde1 = new ListIndex();
        assertEquals(true, treeInde1.searchAndAdd("a", 0));
        assertEquals(true, treeInde1.searchAndAdd("b", 4));
        assertEquals(2, treeInde1.size());
    }
    
    @Test
    public void searchAndAddSameWord()
    {
        ListIndex treeInde1 = new ListIndex();
        assertEquals(true, treeInde1.searchAndAdd("a", 0));
        assertEquals(true, treeInde1.searchAndAdd("a", 4));
        assertEquals(1, treeInde1.size());
    }
    
    @Test
    public void searchAndAddNull()
    {
        ListIndex treeInde1 = new ListIndex();
        assertEquals(false, treeInde1.searchAndAdd(null, 0));
        assertEquals(0, treeInde1.size());
    }
}
