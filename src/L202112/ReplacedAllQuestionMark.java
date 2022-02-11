package L202112;

/*Given a string s containing only lowercase English letters and the '?' character,
convert all the '?' characters into lowercase letters such that the final string does not contain any consecutive repeating characters.
You cannot modify the non '?' characters.

It is guaranteed that there are no consecutive repeating characters in the given string except for '?'.

Return the final string after all the conversions (possibly zero) have been made.
If there is more than one solution, return any of them.
It can be shown that an answer is always possible with the given constraints.
*/

public class ReplacedAllQuestionMark {

    public static void main(String[] args) {
        String s = "j?qg??b";
        System.out.println(modifyString(s));
        System.out.println((char)('j' - 'a' + 1) % 26 + 'a');
    }

    public static String modifyString(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '?') chars[0] = 'a';
        if (chars.length > 1 && chars[1] == 'a') chars[0] = (char) ((chars[1] - 'a' + 1) % 26 + 'a');
        if (chars.length > 1) {
            for (int i = 1; i < chars.length - 1; i++) {
                if (chars[i] == '?') {
                    chars[i] = (char) ((chars[i - 1] - 'a' + 1) % 26 + 'a');
                    if (chars[i] == chars[i + 1]) {
                        chars[i] = (char) ((chars[i + 1] - 'a' + 1) % 26 + 'a');
                    }
                }
            }
            if (chars[chars.length - 1] == '?') chars[chars.length - 1] = (char) ((chars[chars.length - 2] - 'a' + 1) % 26 + 'a');
        }
        String result = String.valueOf(chars);
        return result;
    }
}
