package Algorithm.Sort;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class L0347 {
    public static void main(String[] args) {
        int[] nums = {};
        int k = 3;
        System.out.println();
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // 思路一 新建哈希表记录每个数字出现的频率 以及对应的数字
        // 更正 新建二维数组存储数字及频率
        // 对哈希表进行排序 输出前k个数字
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[][] twoDimen = new int[2][];
        if (nums.length == 0) return new int[0];
        int cur = nums[0];
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != cur) {
                hashMap.put(cur, times);
                cur = nums[i];
            }
            times++;
        }

        System.out.println(hashMap.keySet());

        int[] rNums = new int[k];
        for (int i = 0; i < k; i++) {
            rNums[i] = 0;
        }
        return rNums;
    }
}
