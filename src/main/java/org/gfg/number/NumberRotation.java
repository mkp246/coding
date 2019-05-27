package org.gfg.number;

public class NumberRotation {
    public static int[] countEvenAndOddRotations(int number) {
        int even = 0, odd = 0;
        int digit;
        while (number != 0) {
            digit = number % 10;
            number /= 10;

            if (digit % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return new int[]{even, odd};
    }

    public static int[] getAllRotation(int number) {
        int digits = numDigits(number);
        int[] rotations = new int[digits - 1];
        int powTen = (int) Math.pow(10, digits - 1);
        for (int i = 0; i < digits - 1; i++) {
            number = (number % powTen) * 10 + (number / powTen);
            rotations[i] = number;
        }
        return rotations;
    }

    public static int numDigits(int number) {
        int digits = 0;
        while (number != 0) {
            digits++;
            number /= 10;
        }
        return digits;
    }

    /**
     * digits starting from rightmost place must always be in non-increasing order
     * this ensures that the number's rotation will always that MSB digit is always
     * higher than current one,
     */
    public static boolean isAllRotationsGreaterOrEqual(int number) {
        boolean result = true;
        int lastDigit = 9; //single digit can't be greater than 9
        int digit;
        while (number != 0) {
            digit = number % 10;
            number /= 10;
            if (digit > lastDigit) {
                result = false;
                break;
            } else {
                lastDigit = digit;
            }
        }
        return result;
    }
}
