package Offer.bytedance;

import java.util.Arrays;

public class L42 {
    public static void main(String[] args) {
        int[] height = {9,2,9,3,2,2,1,4,8};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        // 第i个柱子的前面和后面的柱子都比它高即可留住雨水
        // 记录开始降低的转折点以及增长的终点 以及当前谷底

        // 设置接雨水flag，若在一次遍历中有高低差则flag为true
        //循环遍历到弥补到
        //不出现 第i个柱子的前面和后面的柱子都比它高
        int count = 0;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 1; i < height.length - 1; i++) {
                if (height[i] < height[i - 1]) {
                    if (height[i] < height[i + 1]) {
                        int tmp = height[i];
                        height[i] = Math.min(height[i - 1], height[i + 1]);
                        count += (height[i] - tmp);
                        flag = true;
                    } else if (height[i] == height[i + 1]) {
                        int k = i + 1;
                        while (k < height.length - 1 && height[k] == height[i]) {
                            k++;
                        }
                        int tmp = height[i];
                        if (height[k] < tmp) continue;
                        int num = Math.min(height[i - 1], height[k]);
                        int dif = num - tmp;
                        for (int j = i; j < k; j++) {
                            height[j] = num;
                            count += dif;
                        }

                        if (dif == 0) break;
                        i = k;
                        flag = true;
                    }
                }
            }
            System.out.println(Arrays.toString(height));
        }
        return count;
    }

    public static int trap1(int[] height) {
        // 按行求
        int count = 0;
        return count;
    }

    /*public static int trap2(int[] height) {

    }

    public static int trapDyna(int[] height) {

    }*/
}
