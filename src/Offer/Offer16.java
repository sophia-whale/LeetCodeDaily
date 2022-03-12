package Offer;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Offer16 {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, -2));
        System.out.println(Arrays.toString(printNumbers(3)));
    }

    public static double myPow(double x, int n) {
        if (x == 0)return 0;
        double res = 1;
        // 防止n越界
        long nL = n;
        if (n < 0) {
            x = 1/x;
            nL = -nL;
        }
        while (nL > 0) {
            if (nL % 2 == 1) res *= x;
            x *= x;
            nL = nL / 2;
        }
        return res;
    }

    public static int[] printNumbers(int n) {
        int length = 1;
        for (int i = 0; i < n; i++) {
            length *= 10;
        }
        int[] nums = new int[length - 1];
        for (int i = 0; i < length - 1; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }

    // 大数操作
    static String[] nums;
    public static String[] printNumbers2(int n) {
        int length = 1;
        for (int i = 0; i < n; i++) {
            length *= 10;
        }
        nums = new String[length - 1];
        dfs(0, n);
        return nums;
    }

    public static void dfs(int cur, int n) {

    }
}
