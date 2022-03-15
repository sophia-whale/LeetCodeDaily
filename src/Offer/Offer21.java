package Offer;

import java.util.Arrays;

public class Offer21 {
    public static void main(String[] args) {
        int[] nums = {1,3,5};
        System.out.println(Arrays.toString(exchange(nums)));
    }

    public static int[] exchange(int[] nums) {
        // 奇数在前半部分 偶数在后半部分
        int left = 0;
        int right = nums.length - 1;
        int temp = 0;
        while (left < right) {
            while (left < right && nums[right] % 2 == 0) right--;
            if (left < right) {
                temp = nums[right];
            }
            while (left < right && nums[left] % 2 == 1) left++;
            if (left < right) {
                nums[right] = nums[left];
                nums[left] = temp;
            }
        }
        return nums;
    }
}
