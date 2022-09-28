package ACWing.Chapter1BasicAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5,3,6,7,2,4,1,32,67,10,45};
//        int[] nums = {50,43,63,97,30,89,89,94,30,33};// 50,43,63,97,30,89,89,94,30,33   2,4,1,5,3
        System.out.println(topK(nums, 9, 0, nums.length - 1));
        System.out.println(Arrays.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int base = nums[start];
        int l = start;
        int r = end;

        while (l < r) {
            while (l < r && nums[r] > base) r--;
            while (l < r && nums[l] <= base) l++;
            if (l < r) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
        }
        nums[start] = nums[l];
        nums[l] = base;
        quickSort(nums, start, l - 1);
        quickSort(nums, l + 1, end);
    }

    public static void quickSortNon(int[] nums) {
        int base = nums[0];
        int left = 0;
        int right = nums.length - 1;
//        while (left)
    }

    public static int topK(int[] nums, int k, int start, int end) {
        if (start >= end) return nums[k];
        int base = nums[start];
        int l = start;
        int r = end;
        while (l < r) {
            while (l < r && nums[r] >= base) r--;
            while (l < r && nums[l] < base) l++;
            if (l < r) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
        }

        if (k <= r) {
            return topK(nums, k, start, r - 1);
        } else {
            return topK(nums, k, r + 1, end);
        }
    }
}
