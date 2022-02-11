package L202202;

import java.util.Arrays;

public class MinimumDifference {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 8, 5};
        int k = 3;
        System.out.println(minimumDifference(nums, k));
    }

    public static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int cur = 0;
        int minPlus = Integer.MAX_VALUE;
        while (cur + k - 1 < nums.length) {
            int curPlus = nums[cur + k - 1] - nums[cur];
            if (curPlus < minPlus) minPlus = curPlus;
            cur++;
        }
        return minPlus;
    }
}
