package org.gfg.array;

import com.mkp.ALT;
import com.mkp.GFG;
import com.mkp.GFGMethod;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@GFG(date = "25-05-2019", topic = "array diff pair", url = "/count-pairs-difference-equal-k", impls = DiffPair.class)
public class DiffPairTest {

    @Ignore("TODO")
    @Test
    @GFGMethod(date = "25-05-19", algo = "Use Self-balancing BST like AVL tree or Red Black tree")
    public void testCountDiffPairUsingSefBalancingBST() {
        int[] array = {1, 2, 3, 4, 5};
        int result = DiffPair.countDiffPairUsingSefBalancingBST(array, 3);
        Assert.assertEquals(2, result);
    }

    @Test
    @GFGMethod(date = "25-05-19", algo = "using hashing index based not hashMap/Set")
    public void testCountDiffPairUsingHashing() {
        int[] array = {1, 5, 3, 4, 2};
        int count = DiffPair.countDiffPairUsingHashing(array, 3);
        Assert.assertEquals(2, count);
    }

    @Test
    @ALT(url = "find-a-pair-with-the-given-difference/")
    @GFGMethod(date = "25-05-19", algo = "using sorting")
    public void testCountDiffPairUsingSorting() {
        int[] array = {1, 5, 3, 4, 2};
        int count = DiffPair.countDiffPairUsingSorting(array, 3);
        Assert.assertEquals(2, count);
    }
}
