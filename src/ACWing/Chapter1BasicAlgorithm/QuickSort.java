package ACWing.Chapter1BasicAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        quickSort(nums, 0, n - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end)return;
        int base = nums[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && nums[right] > base) right--;
            if (left < right) nums[right] = nums[right];
            while (left < right && nums[left] < base) left++;
            if (left < right) nums[left] = nums[right];
        }
        nums[left] = base;
        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
    }
}
