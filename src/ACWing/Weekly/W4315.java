package ACWing.Weekly;

import java.util.Arrays;
import java.util.Scanner;

public class W4315 {
    static int[] a;
    static int[] b;
    static int n;
    static int s;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        a = new int[n];
        b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 1; i < a[0] + 1; i++) {
            backtracking(0, 0, a[0], i);
        }
        System.out.println(Arrays.toString(b));
    }

    public static void backtracking(int index, int sum, int curCount, int num) {
        if (sum > s) {
            return;
        }
        if (index > n - 1) return;
        sum += num;
        if (index == n - 1 && sum < s) {
            return;
        }
        if (index == n - 1 && sum == s) {
            return;
        }
        if (index < n - 2) {
            for (int i = 1; i < a[index] + 1; i++) {
                backtracking(index + 1, sum, a[index + 1], i);
            }
        }

    }
}
