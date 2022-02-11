package Algorithm.DoublePointer;

public class L0680 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("eeccccbebaeeabebccceea"));
    }

    public static boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int start = 0;
        int end = length - 1;
        // int delete = 0;
        if (length == 0)return true;
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return isPalindrome(s, start, end - 1) || isPalindrome(s, start + 1, end);
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                /*if (delete == 0) {
                    if (chars[start + 1] == chars[end]){
                        start++;
                        delete++;
                    } else if (chars[start] == chars[end - 1]) {
                        end--;
                        delete++;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }*/
                return false;
            }
        }
        return true;
    }
}
