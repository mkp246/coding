package org.gfg.string;

import static org.junit.Assert.*;

import com.mkp.GFGMethod;
import org.junit.Test;

public class StringRearrangementTest {

    @Test
    @GFGMethod(date = "22-07-2019", algo = "count 0s and 1s, both until exhausted append to result",
            url = "/rearrange-binary-string-alternate-x-y-occurrences/")
    public void testRearrangeBinaryStringAsAlternateXYOccurance() {
        String string = "0011";
        String result = StringRearrangement.rearrangeBinaryStringAsAlternateXYOccurance(string, 1, 1);
        assertEquals("0101", result);

        string = "1011011";
        result = StringRearrangement.rearrangeBinaryStringAsAlternateXYOccurance(string, 1, 1);
        assertEquals("0101111", result);

        string = "01101101101101101000000";
        result = StringRearrangement.rearrangeBinaryStringAsAlternateXYOccurance(string, 1, 2);
        assertEquals("01101101101101101000000", result);
    }
}
