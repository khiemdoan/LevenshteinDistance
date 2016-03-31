package core;

/**
 * Created by Khiem on 3/28/2016.
 */
public class LevenshteinDistanceCore {

    private char[] array1;
    private char[] array2;
    private int[][] result;

    public int compute(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();

        array1 = new char[length1];
        array2 = new char[length2];

        str1.getChars(0, length1, array1, 0);
        str2.getChars(0, length2, array2, 0);

        result = new int[length1 + 1][length2 + 1];

        for (int i = 0; i <= length1; i++)
            result[i][0] = i;
        for (int j = 1; j <= length2; j++)
            result[0][j] = j;

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                int int1 = result[i - 1][j] + 1;
                int int2 = result[i][j - 1] + 1;
                int int3 = result[i - 1][j - 1] + ((array1[i - 1] == array2[j - 1]) ? 0 : 1);
                result[i][j] = minimum(int1, int2, int3);
            }
        }

        return result[length1][length2];
    }

    public int getNumberRows() {
        return array1.length + 1;
    }

    public int getNumberColunms() {
        return array2.length + 1;
    }

    public int[][] getTableResult() {
        return result;
    }

    private static int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
