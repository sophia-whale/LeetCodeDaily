package L202109;
/*
2021.09.14
524. Longest Word in Dictionary through Deleting
Given a string s and a string array dictionary,
return the longest string in the dictionary that can be formed by deleting some of the given string characters.
If there is more than one possible result, return the longest word with the smallest lexicographical order.
If there is no possible result, return the empty string.*/

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LongestWordinDictionarythroughDeleting {
    public static void main(String[] args) {
        String s = "apple";//abpcplea
        String[] strings = {"ale","apple","monkey","plea"};
        List<String> dictionary = Arrays.asList(strings);
        System.out.println(findLongestWord(s, dictionary));//"ba","ab","a","b"  "ale","apple","monkey","plea" "zxc","vbn"
    }

    public static String findLongestWord(String s, List<String> dictionary) {
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
            if (iChar_index == iLength) {
                if (iLength > maxLength) {
                    maxLength = iLength;
                    longest = curString;
                }
                if (iLength == maxLength) {
                    if (curString.compareTo(longest) < 0) {
                        longest = curString;
                    }
                }
            }
        }
        return longest;
    }
}
