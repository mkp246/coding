package gfg.array;

import java.util.Arrays;

public class SegmentTree {
    private int st[];
    private int size;

    public SegmentTree(int[] array) {
        int x = (int) Math.ceil(Math.log(array.length) / Math.log(2));
        int maxSize = (int) (Math.pow(2, x + 1) - 1);
        st = new int[maxSize];
        size = array.length;
        constructSTUntil(array, 0, array.length - 1, 0);
    }

    private int constructSTUntil(int[] array, int ss, int se, int si) {
        if (ss == se) {
            st[si] = array[ss];
            return st[si];
        }
        int mid = getMid(ss, se);
        st[si] = constructSTUntil(array, ss, mid, 2 * si + 1)
                + constructSTUntil(array, mid + 1, se, 2 * si + 2);
        return st[si];
    }

    private int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    public int getSum(int qs, int qe) {
        if (qs < 0 || qe > size - 1 || qs > qe) {
            System.out.println("invalid query");
            return -1;
        }
        return getSumUntil(0, size - 1, qs, qe, 0);
    }

    private int getSumUntil(int ss, int se, int qs, int qe, int si) {
        if (ss >= qs && se <= qe) return st[si];
        else if (ss > qe || se < qs) return 0;
        int mid = getMid(ss, se);
        return getSumUntil(ss, mid, qs, qe, 2 * si + 1) + getSumUntil(mid + 1, se, qs, qe, 2 * si + 2);
    }

    public void updateValue(int pos, int diff) {
        if (pos < 0 || pos > size) return;
        updateValueUntil(0, size - 1, pos, diff, 0);
    }

    private void updateValueUntil(int ss, int se, int pos, int diff, int si) {
        if (pos > se || ss > pos) return;
        st[si] += diff;
        if (se != ss) {
            int mid = getMid(ss, se);
            updateValueUntil(ss, mid, pos, diff, 2 * si + 1);
            updateValueUntil(mid + 1, se, pos, diff, 2 * si + 2);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(st);
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 7, 9, 11};
        SegmentTree segmentTree = new SegmentTree(arr);
        System.out.println(segmentTree);
        System.out.println("sum 1,3 :" + segmentTree.getSum(1, 3));
        segmentTree.updateValue(1, 7);
        System.out.println("after update sum 1,3 :" + segmentTree.getSum(1, 3));
    }
}
