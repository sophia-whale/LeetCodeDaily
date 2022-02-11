package L202201;

public class RemovePalindromicSubsequences {
    public static void main(String[] args) {
        System.out.println(removePalindromeSub(""));
    }

    public static int removePalindromeSub(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; ++i) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return 2;
            }
        }
        return 1;
    }
}
