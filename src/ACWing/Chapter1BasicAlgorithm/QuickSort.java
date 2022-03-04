package ACWing.Chapter1BasicAlgorithm;

import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int left = 0;
        int right = n - 1;
        int cur = nums[0];
        int start = 0;
        while (left < right) {
            while (nums[right] > cur) right--;
            if (left < right && nums[right] < cur) nums[start] = nums[right];
            while (nums[left] < cur) left++;
            if (left < right && nums[left] > cur) nums[right] = nums[left];
        }
        nums[left] = cur;
    }
}
