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

    /**
     * Reverse/ extended euclidean algorithm for GCD <br>
     * x and y satisfy the equation ax+by=gcd(a,b)
     *
     * @param a first number
     * @param b second number
     * @return array [gcd, x, y]
     */
    public static int[] extendedEuclidean(int a, int b) {
        if (a == 0) {
            return new int[]{b, 0, 1};
        } else {
            int[] result = extendedEuclidean(b % a, a);
            int y = result[1];  // y=x'
            int x = result[2] - (b / a) * result[1]; // x = y' - floor(b/a)*x'
            return new int[]{result[0], x, y};
        }
    }

    /**
     * using extended euclidean algorithm
     * a*x=1 (mod m)
     *
     * @param a
     * @param m
     * @return
     */
    public static int modularMultiplicativeInverse(int a, int m) {
        int[] extendedEuclidean = extendedEuclidean(a, m);
        if (extendedEuclidean[0] != 1) {
            throw new RuntimeException("inverse does not exists");
        }
        if (extendedEuclidean[1] < 0) {
            extendedEuclidean[1] += m;
        }
        return extendedEuclidean[1]; // return a of ax+by=gcd(a,b)
    }

    /**
     * if m is prime then only it works, whereas euclidean algo works always if a,m coprime
     * a^(m-1) = 1 (mod m)
     *
     * @param a
     * @param m
     * @return
     */
    public static int modularMultiplicativeInverseUsingFermatsLittleTheorem(int a, int m) {
        return pow(a, m - 2, m);
    }

    private static int pow(int a, int p, int mod) {
        int result = 1;
        for (int i = 0; i < p; i++) {
            result = (result * a) % mod;
        }
        return result;
    }
}
