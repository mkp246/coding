package gfg.array;

import gfg.tree.BIT;

public class OrderStatBit {
    BIT bit = new BIT();

    public void insertElement(int number) {
        bit.updateBITree(number, 1);
    }

    public void deleteElement(int number) {
        bit.updateBITree(number, -1);
    }

    public int findKthSmallest(int k) {
        int l = 0;
        int h = bit.size();
        while (l < h) {
            int mid = (l + h) / 2;
            if (k <= bit.getSum(mid)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int findRank(int number) {
        return bit.getSum(number);
    }

    public static void main(String[] args) {
        OrderStatBit orderStatBit = new OrderStatBit();
        orderStatBit.insertElement(20);
        orderStatBit.insertElement(30);
        orderStatBit.insertElement(50);
        orderStatBit.insertElement(40);
        System.out.println("2nd smallest :" + orderStatBit.findKthSmallest(2));
        System.out.println("Rank of 40:" + orderStatBit.findRank(40));
        orderStatBit.deleteElement(30);
        System.out.println("Rank of 50:" + orderStatBit.findRank(50));
    }
}
