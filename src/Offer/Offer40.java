package Offer;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Offer40 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,2,2,1,3,6,3,1,8,2,5,3,11,4,11,12,6,2,7,19,20,16,23,6,23,4,3,25,19,15,15,17,26,30,24,31,2,26,32,6,27,21,3,6,18,46,14,13,43,19,17,50,46,40,13,2,10,43,6,5,8,23,41,21,58,10,28,22,25,63,7,40,64,50,7,57,61,43,45,64,78,50,49,15,45,10,27,66,14,68,81,48,51,33,17,35,71,31};
        System.out.println(Arrays.toString(getLeastNumbers(arr, 24)));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        // 冒泡
        if (k == arr.length) return arr;
        int[] nums = new int[k];
        for (int i = 0; i < k; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] <= arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
            nums[i] = arr[i];
        }
        return nums;
    }

    public static int[] heap(int[] arr, int k) {
        int[] nums = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < arr.length; i++) {
            if (queue.size() < k) {
                queue.offer(arr[i]);
            }

        }
        return nums;
    }
}
