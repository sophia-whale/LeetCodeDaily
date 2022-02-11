package L202201;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        int[] nums = {2,4,-2,-3};
        System.out.println(increasingTriplet(nums));
        System.out.println(increasingTriplet2(nums));
    }

    public static boolean increasingTriplet(int[] nums) {
        /*
        思路一
        特殊性 上升子序列长度为3 即数组中存在一元素
        该元素i的左侧存在比该元素小的元素iL 即i左侧的最小元素小于i
        该元素的右侧存在比该元素大的元素iR 即i右侧的最大元素大于i
        故创建leftMin数组和rightMax数组 分别保存i元素左侧的最小元素以及右侧的最大元素
        */
        int length = nums.length;
        int[] leftMin = new int[length];
        int[] rightMax = new int[length];
        if (length < 3) return false;

        leftMin[0] = nums[0];
        for (int i = 1; i < length; i++) {
            leftMin[i] = Math.min(nums[i], leftMin[i - 1]);
        }

        rightMax[length - 1] = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(nums[i], rightMax[i + 1]);
        }

        for (int i = 0; i < length; i++) {
            if (leftMin[i] < nums[i] && nums[i] < rightMax[i]) return true;
        }

        return false;
    }

    public static boolean increasingTriplet2(int[] nums) {

        /*
        思路二 贪心算法 获取局部最优解 使得得到的上升子序列的前两个值都尽可能地小
        本题是 求数组的最大上升子序列的特殊形式 即设上升子序列为定长3
        设置 first second代表前两个值 过程中时候中保持first < second
        遍历数组 查到元素i大于second 即返回true
        否则 若元素i大于first 则second = 元素i
        否则 first = 元素i
        从而保证first second 为当前最小的上升子序列
        */

        /*
        求数组的最大上升子序列
        贪心 + 二分查找
        */
        if (nums.length < 3) return false;
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > second) {
                return true;
            } else if (nums[i] > first) {
                second = nums[i];
            } else {
                first = nums[i];
            }
        }

        return false;
    }
}
