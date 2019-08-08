package org.gfg.array;

public class Util {
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    public static int log2Floor(int x) {
        return 31 - Integer.numberOfLeadingZeros(x);
    }

    public static int getMid(int start, int end) {
        return start + (end - start) / 2;
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
