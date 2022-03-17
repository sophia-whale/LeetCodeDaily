package Offer;

import java.util.Arrays;

public class Offer39 {
    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        // 出现最多的那个数超过数组长度的一半 故位于中间的数一定是element
        /*int count = 1;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count > nums.length / 2) return num;
            if (nums[i] == num) {
                count++;
            } else {
                num = nums[i];
                count = 1;
            }
        }*/
        return nums[nums.length / 2];
    }
}
