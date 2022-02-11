package Algorithm.DoublePointer;
/*
2021.09.14
524. Longest Word in Dictionary through Deleting
Given a string s and a string array dictionary,
return the longest string in the dictionary that can be formed by deleting some of the given string characters.
If there is more than one possible result, return the longest word with the smallest lexicographical order.
If there is no possible result, return the empty string.*/

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class L0524 {
    public static void main(String[] args) {
        String s = "apple";//abpcplea
        String[] strings = {"ale","apple","monkey","plea"};
        List<String> dictionary = Arrays.asList(strings);
        System.out.println(findLongestWord1(s, dictionary));//"ba","ab","a","b"  "ale","apple","monkey","plea"
        System.out.println(findLongestWord2(s,dictionary));
    }

    public static String findLongestWord1(String s, List<String> dictionary) {
        // 思路一 双指针
        int maxLength = 0;
        String longest = "";
        char[] sChars = s.toCharArray();
        int minIndex = sChars.length;
        //统计最长字符长度及出现的次数，记录相同最大长度的字符串
        for (String curString : dictionary) {
            int iLength = curString.length();
            char[] iChars = curString.toCharArray();
            int sChar_index = 0;
            int iChar_index = 0;
            //匹配字符串
            while (sChar_index < sChars.length && iChar_index < iLength) {
                if (sChars[sChar_index] == iChars[iChar_index]) {
                    sChar_index++;
                    iChar_index++;
                } else {
                    sChar_index++;
                }
            }
            // 若词典中能够匹配s字符串 则判断是否为最长字符串
            if (iChar_index == iLength) {
                if (iLength > maxLength) {
                    maxLength = iLength;
                    longest = curString;
                }
                if (iLength == maxLength && curString.compareTo(longest) < 0) {
                    //相同长度更换为字符更小的字符串
                    longest = curString;
                }
            }
        }
        return longest;
    }

    public static String findLongestWord2(String s, List<String> dictionary) {
        // 思路二 先排序 第一个匹配的字符即为要寻找的字符
        // 排序 compare 长度优先 而后字符大小
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
