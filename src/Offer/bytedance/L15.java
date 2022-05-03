package Offer.bytedance;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L15 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        int l = nums.length;
        if (l < 3) return lists;
        Arrays.sort(nums);
        for (int i = 0; i < l; i++) {
            if (i < l - 1 && nums[i] == nums[i + 1]) {
                for (int k = i + 2; k < l; k++) {
                    if (nums[i] * 2 + nums[k] > 0) break;
                    if (nums[i] * 2 + nums[k] == 0) {
                        List<Integer> cur = new LinkedList<>();
                        cur.add(nums[i]);
                        cur.add(nums[i]);
                        cur.add(nums[k]);
                        lists.add(cur);
                    }
                }
                continue;
            }
            for (int j = i + 1; j < l; j++) {
                if (nums[i] + nums[j] > 0) break;
                if (j < l - 1 && nums[j] == nums[j + 1]) {
                    if (nums[i] + 2 * nums[j] == 0) {
                        List<Integer> cur = new LinkedList<>();
                        cur.add(nums[i]);
                        cur.add(nums[j]);
                        cur.add(nums[j]);
                        lists.add(cur);
                    }
                    continue;
                }
                for (int k = j + 1; k < l; k++) {
                    if (nums[i] + nums[j] + nums[k] > 0) break;
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> cur = new LinkedList<>();
                        cur.add(nums[i]);
                        cur.add(nums[j]);
                        cur.add(nums[k]);
                        lists.add(cur);
                    }
                }
            }
        }
        return lists;
    }
}
