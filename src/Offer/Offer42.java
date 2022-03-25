package Offer;

import java.util.Arrays;
import java.util.HashMap;

public class Offer42 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
        System.out.println(firstUniqChar("abaccdeff"));
    }

    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            res = Math.max(res, pre);
        }
        return res;
    }

    public static char firstUniqChar(String s) {
        int[] times = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a';
            times[cur] += 1;
        }
        for (int i = 0; i < times.length; i++) {
            if (times[i] == 1) return (char) ('a' + i);
        }
        return ' ';
    }
}
