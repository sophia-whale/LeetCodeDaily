package Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};
        shell(nums);
        System.out.println(Arrays.toString(nums));
        directInsert(nums);
        selection(nums);
        System.out.println(Arrays.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        hanoi(8, "H1", "H2", "H3");
    }

    public static void hanoi(int n, String from, String buffer, String to) {
        if (n == 1) {
            System.out.println("from " + from + " to " + to);
            return;
        }

        hanoi(n - 1, from, to, buffer);
        hanoi(1, from, buffer, to);
        hanoi(n - 1, buffer, from, to);
    }

    // 直接插入
    public static void directInsert(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int j;
            for (j = i - 1; j >= 0 && cur < nums[j]; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = cur;
        }
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
    public static void shell(int[] nums) {
        int n = nums.length;
        int h = 1;

        while (h < n/3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && nums[j] < nums[j - h]; j-=h) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
            h = h/3;
        }
    }

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
    public static void selection(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min]) min = j;
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }

    // 堆排序

    // 归并排序
    public static void mergeSort(int[] nums) {

    }

    // 基数排序

    // 桶排序
}
