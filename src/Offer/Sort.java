package Offer;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};
        quickSort(nums, 0, nums.length - 1);
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 直接插入
    public static int[] directInsert(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int j;
            for (j = i - 1; j >= 0 && cur < nums[j]; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = cur;
        }
        return nums;
    }
    // 折半插入
    public static int[] binaryInsert(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = i - 1;
            int cur = nums[i];
            while (left <= right) {
                int mid = (left + right)/2;
                if (cur >= nums[mid]) left = mid + 1;
                if (cur < nums[mid]) right = mid - 1;
            }
            int j;
            for (j = i - 1; j >= left; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = cur;
        }
        return nums;
    }
    // 希尔排序
    // 冒泡排序
    public static int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }
            }
        }
        return nums;
    }

    // 快速排序
    public static void quickSort(int[] nums, int low, int high) {
        if(low >= high){
            return;
        }
        int left = low;
        int right = high;
        int base = nums[left];
        while (left < right) {
            while (left < right && nums[right] > base) right--;
            if (left < right) {
                nums[left] = nums[right];
                left++;
            }
            while (left < right && nums[left] <= base) left++;
            if (left < right) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = base;
        quickSort(nums, low, left - 1);
        quickSort(nums, left + 1, high);
    }
    // 简单选择排序
    // 堆排序
    // 归并排序
    // 基数排序
    // 桶排序
}
