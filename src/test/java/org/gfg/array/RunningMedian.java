package org.gfg.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {
    private PriorityQueue<Integer> smaller = new PriorityQueue<>(Comparator.reverseOrder());//max Heap
    private PriorityQueue<Integer> larger = new PriorityQueue<>();                          //min Heap
    private double median = 0;

    /**
     * adds elements and returns new median
     *
     * @param element
     * @return new median after adding the element
     */
    public double addAndGetMedian(int element) {
        if (smaller.size() == 0 && larger.size() == 0) {
            smaller.add(element);
            median = element;
        } else if (smaller.size() == larger.size()) {
            if (element < median) {
                smaller.add(element);
                median = smaller.peek();
            } else {
                larger.add(element);
                median = larger.peek();
            }
        } else if (smaller.size() > larger.size()) {
            if (element < median) {
                larger.add(smaller.poll());
                smaller.add(element);
            } else {
                larger.add(element);
            }
            median = (smaller.peek() + larger.peek()) / (double) 2;
        } else {
            if (element < median) {
                smaller.add(element);
            } else {
                smaller.add(larger.poll());
                larger.add(element);
            }
            median = (smaller.peek() + larger.peek()) / (double) 2;
        }
        return getMedian();
    }

    public double getMedian() {
        return median;
    }
}
