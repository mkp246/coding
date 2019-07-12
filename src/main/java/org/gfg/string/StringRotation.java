package org.gfg.string;

import java.util.ArrayList;
import java.util.Comparator;

public class StringRotation {

    public static int maxContiguous1sInBinaryStringAfterSubStringRotations(String string, int rotateTimes) {
        ArrayList<Integer> list = new ArrayList<>();
        int count;
        for (int i = 0; i < string.length(); ) {
            if (string.charAt(i) == '1') {
                count = 0;
                while (i < string.length() && string.charAt(i) == '1') {
                    count++;
                    i++;
                }
                list.add(count);
            } else {
                i++;
            }
        }

        list.sort(Comparator.reverseOrder());
        int result = 0;
        for (int i = 0; i <= rotateTimes && i < list.size(); i++) {
            result += list.get(i);
        }
        return result;
    }

    public static boolean isRotationUsingKMPlpsAlgo(String a, String b) {
        if (a.length() != b.length()) return false;
        int length = a.length();
        int[] lps = new int[length];
        int bPos = 0, aPos = 1;
        lps[0] = 0;

        while (aPos < length) {
            if (a.charAt(aPos) == b.charAt(bPos)) {
                lps[aPos++] = ++bPos; //increment both positions
            } else {
                if (bPos == 0) {
                    lps[aPos++] = 0;
                } else {
                    bPos = lps[bPos - 1]; //no clue
                }
            }
        }
        aPos = 0;
        for (bPos = lps[length - 1]; bPos < length; ++bPos) {
            if (b.charAt(bPos) != a.charAt(aPos++)) {
                return false;
            }
        }
        return true;
    }
}
