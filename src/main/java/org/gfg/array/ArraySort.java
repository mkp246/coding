package org.gfg.array;

import java.util.PriorityQueue;

public class ArraySort {

    public static void sortKSortedArrayUsingInsertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void sortKSortedArrayUsingMinHeap(int[] array, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //insert first k+1 element
        for (int i = 0; i <= k; i++) {
            minHeap.add(array[i]);
        }
        int resultPos = 0;
        //remove min, put it in the result, add new element from remaining
        for (int i = k + 1; i < array.length; i++) {
            array[resultPos++] = minHeap.poll();
            minHeap.add(array[i]);
        }
        while (!minHeap.isEmpty()) {
            array[resultPos++] = minHeap.poll();
        }
    }
}
