package L202201;

import java.util.Arrays;
import java.util.OptionalInt;

public class LargestNumberAtLeastTwiceOfOthers {
    public static void main(String[] args) {
        int[] nums = {3,6,1,0};
        System.out.println(dominantIndex(nums));
    }

    public static int dominantIndex(int[] nums) {
        int max = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[max] < nums[i]) max = i;
        }

        for (int i = 0; i < length; i++) {
            if (nums[i] * 2 > nums[max] && i != max) return -1;
        }
        return max;
    }
}
