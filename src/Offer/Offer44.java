package Offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.SplittableRandom;

public class Offer44 {
    public static void main(String[] args) {
        System.out.println(findNthDigit(2147483647));
        System.out.println(reverse("acbdefg","dcf"));
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

    public static String reverse (String s1, String s2) {
        // write code here
        Set<Character> hashSet=new HashSet<>();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for (char c : c2) {
            hashSet.add(c);
        }
        int left = 0;
        int right = c1.length - 1;
        while (left < right) {
            while (!hashSet.contains(c1[left])) left++;
            while (!hashSet.contains(c1[right])) right--;
            char tmp = c1[right];
            c1[right] = c1[left];
            c1[left] = tmp;
            right--;
            left++;
        }
        return String.valueOf(c1);
    }

    public static String reverse1(String s1, String s2) {
        // write code here
        int low = 0;
        int high = s2.length() - 1;
        char[] c1 = s1.toCharArray();
        while (low <= high) {
            int lowF = s1.indexOf(s2.charAt(low));
            int lowL = s1.lastIndexOf(s2.charAt(low));
            int highF = s1.indexOf(s2.charAt(high));
            int highL = s1.lastIndexOf(s2.charAt(high));
            int min = Math.min(lowL, highL);
            int max = Math.max(lowF, highF);
            char tmp = c1[min];
            c1[min] = c1[max];
            c1[max] = tmp;
            System.out.println(Arrays.toString(c1));
            s1 = String.valueOf(c1);
            low++;
            high--;
        }
        return s1;
    }
}
