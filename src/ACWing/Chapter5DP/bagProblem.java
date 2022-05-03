package ACWing.Chapter5DP;

import java.util.Arrays;
import java.util.Scanner;

public class bagProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[N + 1];
        int[] w = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        bag1(N, V, v, w);
        bag2(N, V, v, w);
        fullBag(N, V, v, w);
    }

    public static void bag1(int N, int V, int[] v, int[] w) {
        int[][] f = new int[N + 1][V + 1];
        f[0][0] = 0;
        int max = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= v[i]) f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - v[i]] + w[i]);
            }
        }
        System.out.println(f[N][V]);
    }

    public static void bag2(int N, int V, int[] v, int[] w) {
        int[] f = new int[V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= v[i]; j--) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }
        System.out.println(f[V]);
    }

    public static void fullBag(int N, int V, int[] v, int[] w) {
        int[] f = new int[V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = v[i]; j <= V; j++) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }
        System.out.println(f[V]);
    }
}
