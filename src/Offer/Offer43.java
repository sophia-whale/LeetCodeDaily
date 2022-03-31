package Offer;

import java.util.Arrays;

public class Offer43 {
    public static void main(String[] args) {
        System.out.println(countDigitOne(1000));
        System.out.println(countDigitOneExa(1234));
    }

    public static int countDigitOne(int n) {
        int count = 0;
        // 求出n的位数i 数学方法 在1~i位上计算全部排列组合 如在五位数上 c54即选择四个位置为1 剩下一个位置有9种选择
        // 即可产生 c54 * 9 * 4个1
        int[] nums = new int[11];
        int[] loc = new int[11];
        int i = 0;
        int multi = 1;
        while (n > 0) {
            nums[i] = multi;
            i++;
            loc[i] = n % 10;
            multi *= i;
            n = n / 10;
        }

        System.out.println(Arrays.toString(loc) + " " + i);

        for (int j = 1; j < i; j++) {
            int sel = nums[i - 1] / (nums[j] * nums[i - j - 1]);
            count += sel * Math.pow(9, i - j - 1) * j;
        }

        for (int j = 1; j < i; j++) {
            int sel = 3;
            count += (loc[i] + 1) * sel;
        }

        return count;
    }

    public static int countDigitOneExa(int n) {
        int count = 0;
        long i = 1;        // 从个位开始遍历到最高位
        while(n / i != 0) {
            long high = n / (10 * i);  // 高位
            long cur = (n / i) % 10;   // 当前位
            long low = n - (n / i) * i;
            if(cur == 0) {
                count += high * i;
            }else if(cur == 1) {
                count += high * i + (low + 1);
            }else {
                count += (high + 1) * i;
            }
            i = i * 10;
        }
        return count;
    }
}
