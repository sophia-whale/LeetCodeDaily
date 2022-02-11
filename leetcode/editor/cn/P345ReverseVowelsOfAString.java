package com.leetcode.editor.cn;
//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由 可打印的 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 👍 233 👎 0

public class P345ReverseVowelsOfAString{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        String result = s;
        ArrayList<Character> vowels = new ArrayList<Character>();
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        vowels.addAll(list);
        char[] chars = s.toCharArray();
        int length = chars.length;
        int left = 0;
        int right = length - 1;
        char temp = ' ';
        if (length == 0) return "";
        while (left < right) {
            while (left < right && !vowels.contains(chars[right])) right--;
            if (left < right) {
                temp = chars[right];
            }
            while (left < right && !vowels.contains(chars[left])) left++;
            if (left < right) {
                chars[right] = chars[left];
                chars[left] = temp;
                left++;
                right--;
            }
        }
        result = String.valueOf(chars);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}