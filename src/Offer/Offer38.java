package Offer;

import java.util.*;

public class Offer38 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutation("abb")));
        System.out.println(Arrays.toString(permutation1("absc")));
    }

    static HashSet<String> hashSet = new HashSet<>();
    static char[] chars;
    public static String[] permutation(String s) {
        chars = s.toCharArray();
        backtracking(0);
        String[] strings = new String[hashSet.size()];
        int i = 0;
        for (String cur : hashSet) {
            strings[i] = cur;
            i++;
        }
        return strings;
    }

    public static void backtracking(int index) {
        if (index == chars.length - 1) {
            hashSet.add(String.copyValueOf(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            char tmp = chars[index];
            chars[index] = chars[i];
            chars[i] = tmp;
            backtracking(index + 1);
            chars[i] = chars[index];
            chars[index] = tmp;
        }
    }

    static List<String> list = new ArrayList<>();
    static char[] chars1;
    public static String[] permutation1(String s) {
        chars1 = s.toCharArray();
        backtracking1(0);
        return list.toArray(new String[list.size()]);
    }

    public static void backtracking1(int index) {
        if (index == chars1.length - 1) {
            list.add(String.valueOf(chars1));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = index; i < chars1.length; i++) {
            if (set.contains(chars1[i])) continue;
            set.add(chars1[i]);
            char tmp = chars1[index];
            chars1[index] = chars1[i];
            chars1[i] = tmp;
            backtracking1(index + 1);
            chars1[i] = chars1[index];
            chars1[index] = tmp;
        }
    }
}
