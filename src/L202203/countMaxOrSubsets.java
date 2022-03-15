package L202203;

import java.util.ArrayList;
import java.util.List;

public class countMaxOrSubsets {
    public static void main(String[] args) {
        int[] nums = {3,1};
        System.out.println(countMaxOrSubsets(nums));
    }

    static int max = Integer.MIN_VALUE;
    static int maxCount = 0;
    static List<Integer> curList = new ArrayList<>();
    public static int countMaxOrSubsets(int[] nums) {
        backtracking(0, nums);
        return maxCount;
    }

    public static void backtracking(int cur, int[] nums) {
        if (cur == nums.length) {
            int res = bitOperation(curList);
            if (res > max && res > 0) {
                max = res;
                maxCount = 0;
            }
            if (res == max) maxCount++;
            return;
        }
        curList.add(nums[cur]);
        backtracking(cur + 1, nums);
        curList.remove(curList.size() - 1);
        backtracking(cur + 1, nums);
    }

    public static int bitOperation(List<Integer> nums) {
        if (nums.size() == 0) return -1;
        int res = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            res |= nums.get(i);
        }
        return res;
    }
}
