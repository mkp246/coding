package gfg.array;

public class Search {
    public static int binarySearch(int[] array, int low, int high, int key) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (key == array[mid]) return mid;
        if (key > array[mid]) {
            return binarySearch(array, mid + 1, high, key);
        } else {
            return binarySearch(array, low, mid - 1, key);
        }
    }

    public static int findPivot(int[] array, int low, int high) {
        if (low > high) return -1;
        if (low == high) return low;
        int mid = (low + high) / 2;
        if (mid < high && array[mid] > array[mid + 1]) {
            return mid;
        }
        if (mid > low && array[mid - 1] > array[mid]) {
            return mid - 1;
        }
        if (array[low] >= array[mid]) {
            return findPivot(array, low, mid - 1);
        } else {
            return findPivot(array, mid + 1, high);
        }
    }
}
