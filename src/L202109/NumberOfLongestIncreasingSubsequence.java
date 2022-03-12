package L202109;

/*
* 2021.09.20
* Given an integer array nums, return the number of longest increasing subsequences.

Notice that the sequence has to be strictly increasing.
* DP 动态规划 学习题
* 序列 DP
与朴素的 LIS 问题（问长度）相比，本题问的是最长上升子序列的个数。
我们只需要在朴素 LIS 问题的基础上通过「记录额外信息」来进行求解即可。
在朴素的 LIS 问题中，我们定义 f[i] 为考虑以 nums[i] 为结尾的最长上升子序列的长度。 最终答案为所有 f[0...(n - 1)] 中的最大值。
不失一般性地考虑 f[i] 该如何转移：

由于每个数都能独自一个成为子序列，因此起始必然有 f[i] = 1；
枚举区间 [0, i)的所有数 nums[j]，如果满足 nums[j] < nums[i]，说明 nums[i] 可以接在 nums[j] 后面形成上升子序列，
此时使用 f[j]更新 f[i]，即有 f[i] = f[j] + 1。
回到本题，由于我们需要求解的是最长上升子序列的个数，因此需要额外定义 g[i] 为考虑以 nums[i]结尾的最长上升子序列的个数。

结合 f[i]的转移过程，不失一般性地考虑 g[i]该如何转移：
同理，由于每个数都能独自一个成为子序列，因此起始必然有 g[i] = 1；
枚举区间 [0, i)的所有数 nums[j]，如果满足 nums[j] < nums[i]，说明 nums[i]可以接在 nums[j]后面形成上升子序列，
* 这时候对 f[i] 和 f[j] + 1的大小关系进行分情况讨论：
满足 f[i] < f[j] + 1：说明 f[i]会被 f[j] + 1 直接更新，此时同步直接更新 g[i] = g[j] 即可；
满足 f[i] = f[j] + 1：说明找到了一个新的符合条件的前驱，此时将值继续累加到方案数当中，即有 g[i] += g[j]。
在转移过程，我们可以同时记录全局最长上升子序列的最大长度 max，最终答案为所有满足 f[i] = max 的 g[i] 的累加值。
 */


public class NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,1,2,1};
        System.out.println(findNumberOfLIS(nums));
    }

    public static int findNumberOfLIS(int[] nums) {
        int length = nums.length;
        int[] lengthNum = new int[length];//存储每一个以i为起点的最长子序列个数
        int[] dp = new int[length];//increasing sequence 以nums[i] 为结尾的最长递增子序列的长度
        int max = 1;

        //以i为结尾遍历所有元素获得dp[i]
        for (int i = 0; i < length; i++) {
            //初始化dp和lengthNum数组 因length最小为1且1个元素仍为序列。
            lengthNum[i] = 1;
            dp[i] = 1;
            //遍历所有元素判断其是否为nums[i]前形成递增序列的合适前驱
            for (int j = 0; j < length; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        lengthNum[i] = lengthNum[j];
                    } else if (dp[i] == dp[j] + 1) {
                        lengthNum[i] += lengthNum[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }

        //遍历数组中最长递增序列，获得每一个最长递增序列村存储的以当前i为起点存在的max长度的序列个数。
        int numberOfLIS = 0;
        for (int i = 0; i < length; i++) {
            if (dp[i] == max) {
                numberOfLIS += lengthNum[i];
            }
        }
        
        return numberOfLIS;
    }
}
