package Offer;

public class Offer44 {
    public static void main(String[] args) {
        System.out.println(findNthDigit(2147483647));
    }

    public static int findNthDigit(int n) {
        if (n < 10) return n;
        long num = n + 1;
        int last = 10;
        for (int i = 2; i < 10; i++) {
            int cur = (int) (9 * Math.pow(10, i - 1) * i + last);
            if (num > last && num <= cur) {
                // i位数的第几个
                long loc = (long) Math.ceil((double) (num - last) / i);
                // loc的第几位
                int numLoc = (int) ((num - last) % i);
                if (numLoc == 0) numLoc = i;
                char a = String.valueOf(loc + Math.pow(10, i -1) - 1).charAt(numLoc - 1);
                return a - '0';
            }
            last = cur;
        }
        return -1;
    }

    public int findNthDigitNo(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }
}
