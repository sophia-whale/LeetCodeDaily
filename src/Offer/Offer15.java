package Offer;

public class Offer15 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(-3));
        System.out.println(hammingWeight2(-3));
        System.out.println(hammingWeight3(-3));
    }

    public static int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
        }
        return count;
    }

    public static int hammingWeight2(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            // 1 << i 表示1的二进制表示中的所有位向左移动n位
            // 0000 0001 移动3位即 0000 1000相当于原数乘以2的n次方
            // 在本题中通过1的移动可验证n中第i位是否为1
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    public static int hammingWeight3(int n) {
        // n & (n−1)，结果恰为把n的二进制位中的最低位的 1 变为 0 之后的结果
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }
}
