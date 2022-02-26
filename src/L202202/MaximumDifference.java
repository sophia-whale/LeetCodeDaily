package L202202;

public class MaximumDifference {
    public static void main(String[] args) {
        int[] nums = {7,1,5,4};
        System.out.println(maximumDifference(nums));
    }

    public static int maximumDifference(int[] nums) {
        int result = -1, preMin = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > preMin) {
                result = Math.max(result, nums[i] - preMin);
            } else {
                preMin = nums[i];
            }
        }
        return result;
    }
}
