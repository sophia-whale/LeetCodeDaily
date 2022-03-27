package Offer;

public class Search {
    public static void main(String[] args) {
        int[] nums = {};
        int target = 12;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (target == nums[mid]) return mid;
            if (target > nums[mid]) left = mid + 1;
            if (target < nums[mid]) right = mid - 1;
        }
        return -1;
    }
}
