package L202201;

import javax.print.DocFlavor;
import java.util.Stack;

public class ValidParenthesesString {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        // System.out.println(maxDepth(s));
        char c = '0';
        String a = "aaa";
        System.out.println((-33) % (-2));
    }

    public static int maxDepth(String s) {
        char[] chars = s.toCharArray();
        int maxDepth = 0;
        int curDepth = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                curDepth++;
                if (curDepth >= maxDepth) maxDepth = curDepth;
            }
            else if (chars[i] == ')') {
                curDepth--;
            }
        }
        return maxDepth;
    }
}
