package org.gfg.string;

public class StringRearrangement {

    public static String rearrangeBinaryStringAsAlternateXYOccurance(String string, int x, int y) {
        int zeroCount = 0, oneCount;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '0') {
                zeroCount++;
            }
        }
        oneCount = string.length() - zeroCount;

        StringBuilder builder = new StringBuilder();
        while (zeroCount > 0 || oneCount > 0) {
            for (int i = 0; i < x && zeroCount > 0; i++, zeroCount--) {
                builder.append('0');
            }
            for (int i = 0; i < y && oneCount > 0; i++, oneCount--) {
                builder.append('1');
            }
        }
        return builder.toString();
    }
}
