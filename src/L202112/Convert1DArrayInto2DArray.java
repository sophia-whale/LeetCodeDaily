package L202112;

import java.util.Arrays;

/*
* You are given a 0-indexed 1-dimensional (1D) integer array original, and two integers, m and n.
* You are tasked with creating a 2-dimensional (2D) array with m rows and n columns using all the elements from original.
* The elements from indices 0 to n - 1 (inclusive) of original should form the first row of the constructed 2D array,
* the elements from indices n to 2 * n - 1 (inclusive) should form the second row of the constructed 2D array, and so on.
*/
public class Convert1DArrayInto2DArray {
    public static void main(String[] args) {
        int m = 2;
        int n = 2;
        int[] original = {1,2,3,4};
        int[][] array = construct2DArray(original, m, n);
        System.out.println(array);
    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        // 判断是否符合转换标准 尺寸是否合适
        // 遍历一维数组存入二维数组
        int length = original.length;
        int[][] array = new int[m][n];
        if (m * n != length) return new int[0][0];
        for (int i = 0; i < length; i++) {
            int row = i / n;
            int column = i % n;
            array[row][column] = original[i];
        }
        return array;
    }
}
