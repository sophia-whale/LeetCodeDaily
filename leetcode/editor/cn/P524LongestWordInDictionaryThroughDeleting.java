package com.leetcode.editor.cn;
//给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
// 
//
// 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
// 
//
// 示例 2： 
//
// 
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s 和 dictionary[i] 仅由小写英文字母组成 
// 
// Related Topics 数组 双指针 字符串 排序 👍 285 👎 0

public class P524LongestWordInDictionaryThroughDeleting{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                } else {
                    return o1.compareTo(o2);
                }
            }
        });

        System.out.println(Arrays.toString(dictionary.stream().toArray()));

        //统计最长字符长度及出现的次数，记录相同最大长度的字符串
        for (String curString : dictionary) {
            int sChar_index = 0;
            int iChar_index = 0;
            //匹配字符串
            while (sChar_index < s.length() && iChar_index < curString.length()) {
                if (s.charAt(sChar_index) == curString.charAt(iChar_index)) {
                    sChar_index++;
                    iChar_index++;
                } else {
                    sChar_index++;
                }
            }
            // 若词典中能够匹配s字符串 则判断是否为最长字符串
            if (iChar_index == curString.length()) {
                return curString;
            }
        }
        return "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}