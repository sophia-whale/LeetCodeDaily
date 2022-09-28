package ACWing.Chapter1BasicAlgorithm;

import java.util.Arrays;

public class MergeSort {
//        int[] nums = {50,43,63,97,30,89,89,94,30,33};// 50,43,63,97,30,89,89,94,30,33   2,4,1,5,3

    public static int[] tmp = new int[1000010];
    public static void main(String[] args) {
        int[] nums = {5,3,6,7,2,4,1,32,67,10,45};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid, r);
        int k = 0;
        int i = l;
        int j = mid + 1;
        while (i <= mid && j <= r) {
             if (nums[i] <= nums[j]) tmp[k++] = nums[i++];
             else tmp[k++] = nums[j++];
        }
        while (i <= mid) tmp[k++] = nums[i++];
        while (j <= r) tmp[k++] = nums[j++];

        for (int a = l, m = 0; a <= r; m++) {
            nums[a] = tmp[m];
        }
    }
}
