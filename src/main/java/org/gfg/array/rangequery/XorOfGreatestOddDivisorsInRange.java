package org.gfg.array.rangequery;

public class XorOfGreatestOddDivisorsInRange {
    private int[] prefixXor; // to store prefix xor

    public XorOfGreatestOddDivisorsInRange(int[] array) {
        this.prefixXor = array;
        array[0] = getGreatestOddDivisor(array[0]);
        for (int i = 1; i < array.length; i++) {
            array[i] = getGreatestOddDivisor(array[i]);
            array[i] ^= array[i - 1];
        }
    }

    public int getQuery(int left, int right) {
        return prefixXor[right] ^ (left == 0 ? 0 : prefixXor[left - 1]);
    }

    private int getGreatestOddDivisor(int x) {
        if ((x & 1) == 1) {
            return x; //odd
        } else {
            return x >> Integer.numberOfTrailingZeros(x); // x is even
        }
    }
}
