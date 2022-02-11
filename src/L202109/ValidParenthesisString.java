package L202109;/*
2020.09.12
678. Valid Parenthesis String
Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".*/

import java.util.Scanner;

public class ValidParenthesisString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String brackets = sc.nextLine();
        System.out.println(brackets);
        boolean result = checkValidString(brackets);
        System.out.println(result);
    }

    public static boolean checkValidString(String s) {
        int min = 0;
        int max = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(') {
                min++;
                max++;
            } else if (s.charAt(i) == ')') {
                min--;
                max--;
            } else {
                min--;
                max++;
            }
            min = Math.max(min, 0);
            if (min > max) return false;
        }
        return min == 0;
    }
}
