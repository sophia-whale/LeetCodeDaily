package LeetcodeWeekly;

public class L6027 {
    public static void main(String[] args) {
        int[] nums = {57,57,57,57,57,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,85,85,85,86,86,86};
        System.out.println(countHillValley(nums));
    }

    public static int countHillValley(int[] nums) {
        int count = 0;
        int i = 1;
        while (i < nums.length - 1){
            if (nums[i - 1] > nums[i] && nums[i + 1] > nums[i]) count++;
            else if (nums[i - 1] < nums[i] && nums[i + 1] < nums[i]) count++;
            else if (nums[i] == nums[i + 1]) {
                int left = nums[i - 1];
                for (int j = i; j < nums.length - 1; j++) {
                    if (nums[j] != nums[j + 1]) break;
                    i++;
                }
                if (i + 1 < nums.length && left > nums[i] && nums[i + 1] > nums[i]) count++;
                else if (i + 1 < nums.length && left < nums[i] && nums[i + 1] < nums[i]) count++;
            }
            i++;
        }
        return count;
    }
}
