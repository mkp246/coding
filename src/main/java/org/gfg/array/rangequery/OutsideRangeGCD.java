package org.gfg.array.rangequery;

import org.gfg.array.Util;

public class OutsideRangeGCD {
    private int[] gcdToLeft;
    private int[] gcdToRight;

    public OutsideRangeGCD(int[] array) {
        gcdToLeft = new int[array.length + 1]; // first element 0
        gcdToRight = new int[array.length + 1]; // last element 0

        for (int i = 0; i < array.length; i++) {
            gcdToLeft[i + 1] = Util.gcd(gcdToLeft[i], array[i]);
        }

        for (int i = array.length - 1; i >= 0; i--) {
            gcdToRight[i] = Util.gcd(gcdToRight[i + 1], array[i]);
        }
    }

    public int getQuery(int left, int right) {
        return Util.gcd(gcdToLeft[left], gcdToRight[right + 1]);
    }
}
