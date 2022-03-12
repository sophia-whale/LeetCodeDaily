package RainyUniverse.question1143;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        int[] pos = new int[arr2.length];
        int[] visited = new int[arr1.length];
        for(int i = 0; i < arr2.length; i++){
            int flag = -1;
            for(int j = 0; j < arr1.length; j++){
                if(arr2[i] == arr1[j] && visited[j] == 0){
                    flag = j;
                    visited[j] = 1;
                    break;
                }
            }
            pos[i] = flag;
        }

        for(int i = 0; i < arr2.length; i++){
            System.out.print(pos[i]+" ");
        }
        System.out.println();

        //转化为寻找严格递增子序列 跳过-1
        int[] dp = new int[arr2.length];
        if(pos[0] == -1){
            dp[0] = 0;
        }else{
            dp[0] = 1;
        }
        for(int i = 1; i < arr2.length; i++){
            if(pos[i] == -1){
                continue;
            }
            for(int j = 0; j < i; j++){
                if(pos[j] < pos[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int res = 0;
        for(int i = 0; i < dp.length; i++){
            if(dp[i] > res){
                res = dp[i];
            }
        }
        return res;
    }
}
