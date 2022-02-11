package Algorithm.DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L0345 {
    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
    }

    public static String reverseVowels(String s) {
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
