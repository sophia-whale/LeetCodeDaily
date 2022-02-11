package L202109;
/*
2021.09.15
162. Find Peak Element
A peak element is an element that is strictly greater than its neighbors.
Given an integer array nums, find a peak element, and return its index.
If the array contains multiple peaks, return the index to any of the peaks.
You may imagine that nums[-1] = nums[n] = -∞.
You must write an algorithm that runs in O(log n) time.*/

public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(findPeakElement(nums));
    }
    //二分查找
    public static int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        if (high == 0) {
            return 0;
        }
        while (low < high) {
            mid = (low + high)/2;
            if (mid - 1 < 0) {
                if (nums[mid] > nums[mid + 1]) {
                    return 0;
                }
            }
            if (mid + 1 > nums.length) {
                if (nums[mid] > nums[mid - 1]) {
                    return nums.length - 1;
                }
            }
            if (nums[mid] < nums[mid + 1]) {
                low = mid+ 1;
            } else {
                high = mid;
            }
        }
        return high;
    }
}
