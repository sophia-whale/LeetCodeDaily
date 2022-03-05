package L202203;

public class FindLUSlength {
    public static void main(String[] args) {
        System.out.println(findLUSlength("svvtrbr", "sdcvfb"));
    }

    public static int findLUSlength(String a, String b) {
        return !a.equals(b) ? Math.max(a.length(), b.length()) : -1;
    }
}
