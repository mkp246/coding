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
}
