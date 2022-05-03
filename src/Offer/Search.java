package Offer;

import java.util.Arrays;

public class Search {
    private static int a = 7;
    public static void main(String[] args) {
        int[] nums = {11,15,16,12,8,16,18,17,11,10};
        int target = 12;
        System.out.println(search(nums, target));
        System.out.println(Arrays.toString(stocks(10, nums)));
        Search.a--;
        System.out.println(a);
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

    public static int[] stocks (int n, int[] stocks) {
        // write code here
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int cur = 0;
            int j;
            for (j = i; j < n; j++) {
                if (stocks[j] > stocks[i]) break;
                cur++;
            }
            if (j == n) res[i] = 0;
            else res[i] = cur;
        }
        return res;
    }

    public int maxarea (int n, int[] array) {
        // write code here
        return 0;
    }
}
