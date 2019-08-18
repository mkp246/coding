package org.gfg.array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

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

    public static void sortArrayAccordingToAbsoluteDiffWithGivenValueUsingSelfBalancingBST(int[] array, int x) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>(); // key = abs diff with x, value=list of elements
        for (int i = 0; i < array.length; i++) {
            int diff = Math.abs(array[i] - x);
            if (!map.containsKey(diff)) {
                map.put(diff, new ArrayList<>());
            }
            map.get(diff).add(array[i]);
        }
        int resultPos = 0;
        for (List<Integer> list : map.values()) {
            for (Integer element : list) {
                array[resultPos++] = element;
            }
        }
    }
}
