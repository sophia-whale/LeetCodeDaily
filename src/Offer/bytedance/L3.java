package Offer.bytedance;

public class L3 {
    public static void main(String[] args) {
        /*"abcabcbb" "tmmzuxt" dvdf
"bbbbb""bpfbhmipx""bbtablud"
"pwwkew"*/
        String s = " ";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int count = 0;
        int start = 0;
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            count = Math.max(count, i - start + 1);
            last[index] = i;
        }
        return count;
    }

    public static String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int[] last = new int[128];
        int res = 0;
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            // 最长回文子序列
            for (int j = start; j < s.length(); j++) {

            }
        }
        return s.substring(start, end);
    }
}
