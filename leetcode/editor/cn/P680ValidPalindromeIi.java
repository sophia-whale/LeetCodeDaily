package com.leetcode.editor.cn;
//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "aba"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abca"
//输出: true
//解释: 你可以删除c字符。
// acabbaa
//
// 示例 3: 
//
// 
//输入: s = "abc"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
// Related Topics 贪心 双指针 字符串 👍 442 👎 0

public class P680ValidPalindromeIi{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean validPalindrome(String s) {
            char[] chars = s.toCharArray();
            int length = chars.length;
            int start = 0;
            int end = length - 1;
            int delete = 0;
            if (length == 0)return true;
            while (start < end) {
                if (s.charAt(start) == s.charAt(end)) {
                    start++;
                    end--;
                } else {
                    return isPalindrome(s, start, end - 1) || isPalindrome(s, start + 1, end);
                }
            }
            return true;
        }

        public boolean isPalindrome(String s, int start, int end) {
            for (int i = start, j = end; i < j; i++, j--) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
            }
            return true;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}