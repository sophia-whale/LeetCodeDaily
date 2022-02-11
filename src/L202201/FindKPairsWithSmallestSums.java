package L202201;

import java.util.*;

public class FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {};
        int k = 3;
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        /* 思路一 优先队列
        * nums1 和 nums2都是递增序列 故最小一定为nums1[0],nums2[0]
        * 设置长度为k的优先队列 将nums1中的k个加入队列
        *
        * */

        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> nums1[a[0]] + nums2[a[1]]));

        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            heap.offer(new int[] {i, 0});
        }

        List<List<Integer>> result = new ArrayList<>();

        while (k > 0 && !heap.isEmpty()) {
            int[] pos = heap.poll();

            result.add(Arrays.asList(nums1[pos[0]], nums2[pos[1]]));

            // 将 index2 加 1 之后继续入队
            if (++pos[1] < nums2.length) {
                heap.offer(pos);
            }

            k--;
        }
        return result;
    }
}
