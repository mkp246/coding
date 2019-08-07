package org.gfg.array;

public class Util {
    static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    public static int log2Floor(int x) {
        return 31 - Integer.numberOfLeadingZeros(x);
    }

    public static int getMid(int start, int end) {
        return start + (end - start) / 2;
    }
}
