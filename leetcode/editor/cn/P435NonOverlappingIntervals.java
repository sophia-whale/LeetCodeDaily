package com.leetcode.editor.cn;
//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。 
//
// 注意: 
//
// 
// 可以认为区间的终点总是大于它的起点。 
// 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。 
// 
//
// 示例 1: 
//
// 
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
// Related Topics 贪心 数组 动态规划 排序 👍 574 👎 0

public class P435NonOverlappingIntervals{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            int[] first = new int[intervals.length];
            int[] last = new int[intervals.length];
            for(int i = 0; i < intervals.length; i++){
                first[i] = intervals[i][0];
                last[i] = intervals[i][1];
            }
            //冒泡排序
            for(int i = 0; i < intervals.length; i++){
                for(int j = 0; j < intervals.length - i - 1; j++){
                    if(first[j] >= first[j+1]){
                        if(first[j] == first[j+1]){
                            if(last[j] > last[j+1]){
                                int temp = first[j];
                                first[j] = first[j+1];
                                first[j+1] = temp;

                                temp = last[j];
                                last[j] = last[j+1];
                                last[j+1] = temp;
                            }
                        }else{
                            int temp = first[j];
                            first[j] = first[j+1];
                            first[j+1] = temp;

                            temp = last[j];
                            last[j] = last[j+1];
                            last[j+1] = temp;
                        }
                    }
                }
            }

            //找出区间右端最小值
            int min_last = last[0];
            for(int i = 0; i < intervals.length; i++){
                if(last[i] < min_last){
                    min_last = last[i];
                }
            }
            //目前找到一个区间
            int count = 1;
            //初始化区间左端最小值  为   区间左端最大值
        /*int min_first;
        int max_first = first[0];
        for(int i = 0; i < intervals.length; i++){
            if(first[i] > max_first){
                max_first = first[i];
            }
        }*/
            for(;;){
                System.out.println(min_last);
                // min_first = max_first;
                int flag = 0;
                // int min_first_flag = 0;
                //在目前找到的区间右端寻找区间左端最小值
                for(int i = 0; i < intervals.length; i++){
                    if(first[i] <= min_first && first[i] >= min_last){
                        min_first = first[i];
                        min_first_flag = i;
                        flag = 1;
                    }
                }
                //判断是否找到
                if(flag == 1){
                    count++;
                    min_last = last[min_first_flag];
                    System.out.println(min_last);
                }else{
                    break;
                }
            }
            return intervals.length - count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}