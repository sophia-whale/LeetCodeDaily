package Offer;

public class Offer14 {
    public static void main(String[] args) {
        System.out.println(cuttingRope2(200));
    }

    public static int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else if (n == 4) {
            return 4;
        } else if (n == 5) {
            return 6;
        } else if (n == 6) {
            return 9;
        }
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;
        int e = 1000000007;

        for (int i = 7; i < n + 1; i++) {
            dp[i] = Math.max(2 * dp[i - 2], 3 * dp[i - 3]);
        }
        return dp[n];
    }

    public static int cuttingRope2(int n) {
        long res = 1;
        long e = 1000000007;
        if (n < 4) return n - 1;
        if (n == 4) return 4;
        while (n > 4) {
           res = (res * 3) % e;
           n -= 3;
        }
        res = (res * n) % e;
        return (int) res;
    }
}
