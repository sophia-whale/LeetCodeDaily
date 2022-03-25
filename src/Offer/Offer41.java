package Offer;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Offer41 {

    public static class MedianFinder {
        List<Integer> nums = new LinkedList<>();
        PriorityQueue<Integer> low = new PriorityQueue<>();
        PriorityQueue<Integer> high = new PriorityQueue<>((x, y) -> (y - x));
        public MedianFinder() {

        }

        // test1 超时 添加元素时采用了直接插入 时间复杂度高，且冗余扫描
        public void addNum1(int num) {
            if (nums.size() == 0 || num > nums.get(nums.size() - 1)) {
                nums.add(num);
                return;
            }
            for (int i = 0; i < nums.size(); i++) {
                if (num <= nums.get(i)) {
                    nums.add(i, num);
                    break;
                }
            }
        }

        // test2 超时+1 使用二分查找优化为logN
        public void addNum2(int num) {
            if (nums.size() == 0 || num > nums.get(nums.size() - 1)) {
                nums.add(num);
                return;
            }
            int left = 0;
            int right = nums.size() - 1;
            int mid = (left + right) / 2;
            while (left < right) {
                if (mid > num) right = mid - 1;
                if (mid < num) left = mid + 1;
            }
            nums.add(mid, num);
        }

        // test3 借助大顶堆、小顶堆进一步优化
        public void addNum(int num) {
            if(low.size() != high.size()) {
                low.add(num);
                high.add(low.poll());
            } else {
                high.add(num);
                low.add(high.poll());
            }
        }

        public double findMedian12() {
            int size = nums.size();
            if (size % 2 == 0 && size != 0) {
                int a = nums.get(size/2 - 1);
                int b = nums.get(size/2);
                return (double) (a + b)/2;
            }
            return nums.get(size/2);
        }
        public double findMedian() {
            if (low.size() != high.size()) return low.peek();
            return (low.peek() + high.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder median = new MedianFinder();
        median.addNum(1);
        median.addNum(2);
        System.out.println(median.findMedian());
        median.addNum(3);
        System.out.println(median.findMedian());
    }
}
