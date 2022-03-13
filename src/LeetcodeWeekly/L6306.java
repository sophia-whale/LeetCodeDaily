package LeetcodeWeekly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L6306 {
    public static void main(String[] args) {
        L6306 l = new L6306();
        int[] nums = {2,2,2,2,2};
        System.out.println(l.findKDistantIndices(nums, 1, 1));
    }

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> list = new ArrayList<>();
        int length = nums.length;
        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (nums[i] == key) {
                indexs.add(i);
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < indexs.size(); j++) {
                if (Math.abs(i - indexs.get(j)) <= k) {
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }
}
