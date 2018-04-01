package gfg.tree;

import java.util.BitSet;

public class BIT {
    private int BITree[] = new int[1000];
    private int size = 1000;

    public void constuctBITree(int[] array) {
        size = array.length;
        for (int i = 0; i < array.length; i++) {
            updateBITree(i, array[i]);
        }
    }

    /**
     * data is delta from previous data
     *
     * @param pos
     * @param data
     */
    public void updateBITree(int pos, int data) {
        pos++;
        while (pos <= size) {
            BITree[pos] += data;
            pos += (pos & (-pos));
        }
    }

    public int getSum(int index) {
        int sum = 0;
        index++;
        while (index > 0) {
            sum += BITree[index];
            index -= index & (-index);
        }
        return sum;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        int freq[] = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
        BIT bit = new BIT();
        bit.constuctBITree(freq);
        System.out.println(bit.getSum(5));
        freq[3] += 6;
        bit.updateBITree(3, 6);
        System.out.println(bit.getSum(5));
    }
}
