

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HashIndexTest. Note: getters and setters untested
 *
 * @author  Henry Grote
 * @version 12/03/2020
 */
public class HashIndexTest
{
    @Test
    public void size0()
    {
        HashIndex treeInde1 = new HashIndex();
        assertEquals(0, treeInde1.size());
    }

    @Test
    public void size1()
    {
        HashIndex treeInde1 = new HashIndex();
        assertEquals(true, treeInde1.searchAndAdd("hello", 0));
        assertEquals(1, treeInde1.size());
    }

    @Test
    public void searchAndAddEmptyList()
    {
        HashIndex treeInde1 = new HashIndex();
        assertEquals(true, treeInde1.searchAndAdd("a", 1));
        assertEquals(1, treeInde1.size());
    }

    @Test
    public void searchAndAddNonEmptyList()
    {
        HashIndex treeInde1 = new HashIndex();
        assertEquals(true, treeInde1.searchAndAdd("a", 0));
        assertEquals(true, treeInde1.searchAndAdd("b", 4));
        assertEquals(2, treeInde1.size());
    }
    
    @Test
    public void searchAndAddSameWord()
    {
        HashIndex treeInde1 = new HashIndex();
        assertEquals(true, treeInde1.searchAndAdd("a", 0));
        assertEquals(true, treeInde1.searchAndAdd("a", 4));
        assertEquals(1, treeInde1.size());
    }
    
    @Test
    public void searchAndAddNull()
    {
        HashIndex treeInde1 = new HashIndex();
        assertEquals(false, treeInde1.searchAndAdd(null, 0));
        assertEquals(0, treeInde1.size());
    }
}
