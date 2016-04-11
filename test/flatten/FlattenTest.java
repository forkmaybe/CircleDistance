package flatten;

import static flatten.Flatten.flatten;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luke
 */
public class FlattenTest {

    public FlattenTest() {
    }

    @Test
    public void testFlatten() {

        // test for null
        Assert.assertNull(flatten(null));

        // empty array
        Assert.assertArrayEquals(
                "empty array",
                new Integer[]{},
                toArray(flatten(new Object[]{}))
        );

        // un-nested array
        Assert.assertArrayEquals(
                "flat Array",
                new Integer[]{1, 2, 3, 4, 5},
                toArray(flatten(new Object[]{1, 2, 3, 4, 5}))
        );

        // two level nested array
        Assert.assertArrayEquals(
                "flatten a two level nested array",
                new Integer[]{1, 2, 3, 4, 5, 6, 7},
                toArray(flatten(new Object[]{1, 2, new Object[]{3, 4, 5}, 6, 7}))
        );

        // three level nested array
        Assert.assertArrayEquals(
                "flatten a three level nested array",
                new Integer[]{1, 2, 3, 4, 5, 6, 7},
                toArray(flatten(new Object[]{1, 2, new Object[]{3, new Object[]{4, 5}}, 6, 7}))
        );

    }

    /**
     * Helper-method for testing.
     *
     * @param list - flat list of Integers.
     * @return - array with the same objects.
     */
    private static Integer[] toArray(List<Integer> list) {
        return list.toArray(new Integer[list.size()]);
    }

}
