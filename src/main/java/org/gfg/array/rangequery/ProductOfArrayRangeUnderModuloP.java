package org.gfg.array.rangequery;

import org.gfg.array.Util;

public class ProductOfArrayRangeUnderModuloP {
    private final int[] product;
    private final int[] inverseProduct;
    private final int p;

    public ProductOfArrayRangeUnderModuloP(int[] array, int p) {
        product = new int[array.length];
        inverseProduct = new int[array.length];
        this.p = p;

        product[0] = array[0] % p;
        inverseProduct[0] = Util.modularMultiplicativeInverse(array[0], p);
        for (int i = 1; i < array.length; i++) {
            product[i] = (product[i - 1] * array[i]) % p;
            inverseProduct[i] = (inverseProduct[i - 1] * Util.modularMultiplicativeInverse(array[i], p)) % p;
        }
    }

    /**
     * 1 based indexing for start and end
     *
     * @param start
     * @param end
     * @return
     */
    public int getQuery(int start, int end) {
        end--;
        start--;
        return product[end] * (start == 0 ? 1 : inverseProduct[start - 1]);
    }
}
