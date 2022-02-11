package EasyProblem;

/*Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.*/

import java.util.HashMap;
import java.util.Stack;

public class L0020 {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        HashMap<Character, Character> charsHash = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        if (chars.length % 2 == 1) return false;
        for (int i = 0; i < chars.length; i++) {
            if (charsHash.containsKey(chars[i])) {
                if (stack.isEmpty() ||charsHash.get(chars[i]) != stack.peek()) return false;
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty();
    }
}
