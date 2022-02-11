package Algorithm.DoublePointer;

import java.util.Arrays;

public class L0088 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        // merge1(nums1, m, nums2, n);
        merge2(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        // 思路一 直接插入
        int first = m - 1;
        for (int i = 0; i < n; i++) {
            int cur = nums2[i];
            while (first >= 0 && nums1[first] > cur) {
                nums1[first + 1] = nums1[first];
                nums1[first] = cur;
                first--;
            }
            nums1[first + 1] = cur;
            first = m + i;
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        // 思路二 逆向双指针 一个标记当前到nums1的数据的哪个位置 一个标记当前到nums2的哪个位置
        int first = m - 1;
        int second = n - 1;
        int cur = m + n - 1;
        while (second >= 0) {
            if (first < 0 || nums1[first] <= nums2[second]) {
                nums1[cur--] = nums2[second--];
            } else {
                nums1[cur--] = nums1[first--];
            }
        }
    }
}
