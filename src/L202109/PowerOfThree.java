package L202109;

/*
* 2021.09.23
* Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3x.*/

public class PowerOfThree {
    public static void main(String[] args) {
        int n = 81;
        System.out.println(isPowerOfThree(n));
    }
    public static boolean isPowerOfThree(int n) {
        /*while (n != 0 && n % 3 == 0) {
            n = n/3;
        }
        return n == 1;*/
        return n > 0 && 1162261467 % n == 0;
    }
}
