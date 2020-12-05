

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit Tests for Entry. Note: getters and setters untested
 *
 * @author  Henry Grote
 * @version 12/04/2020
 */
public class EntryTest
{
    /**
     * Default constructor for test class EntryTest
     */
    public EntryTest()
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
    public void newEntry()
    {
        Entry entry1 = new Entry("a", 0);
        assertEquals("a [1]", entry1.toString());
    }

    @Test
    public void AddLine()
    {
        Entry entry1 = new Entry("a", 1);
        entry1.addLine(6);
        assertEquals("a [1, 6]", entry1.toString());
    }
}


