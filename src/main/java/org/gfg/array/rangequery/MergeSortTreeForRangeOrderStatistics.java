package org.gfg.array.rangequery;

import org.gfg.array.OrderStatistics.Pair;
import org.gfg.array.Util;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSortTreeForRangeOrderStatistics {
    private Pair[] tree;
    private int[] array;
    private int arrayLength;
    private Pair<Integer, Integer>[] pairs;

    public MergeSortTreeForRangeOrderStatistics(int[] array) {
        this.array = array;
        arrayLength = array.length;
        int height = Util.log2Floor(arrayLength) + 1;
        int maxSize = 2 * (int) Math.pow(2, height) - 1;
        tree = new Pair[maxSize];

        pairs = new Pair[arrayLength];
        for (int i = 0; i < array.length; i++) {
            pairs[i] = new Pair<>(array[i], i);
        }
        Arrays.sort(pairs, Comparator.comparing(Pair::getKey));
        constructUntil(pairs, 0, arrayLength - 1, 0);

    }

    private void constructUntil(Pair<Integer, Integer>[] pairs, int segStart, int segEnd, int currentIndex) {
        if (segStart == segEnd) {
            tree[currentIndex] = pairs[currentIndex];
        } else {
            int mid = Util.getMid(segStart, segEnd);
            constructUntil(pairs, segStart, mid, 2 * currentIndex + 1);
            constructUntil(pairs, mid + 1, segEnd, 2 * currentIndex + 2);
            merge(segStart, mid, mid + 1, segEnd);
        }
    }

    private void merge(int s1, int e1, int s2, int e2) {
        
    }

    public int query(int start, int end, int k) {
        return 0;
    }
}
