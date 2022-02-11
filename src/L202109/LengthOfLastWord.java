package L202109;

/*
2021.09.21
* Given a string s consisting of some words separated by some number of spaces,
* return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.*/

import java.util.ArrayList;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "a";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        int length = 0;
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        while (index >= 0 && s.charAt(index) != ' ') {
            index--;
            length++;
        }

        return length;
    }
}
