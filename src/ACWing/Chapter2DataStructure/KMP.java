package ACWing.Chapter2DataStructure;

public class KMP {
    public static void main(String[] args) {
        String s = "abbabab";
        String p = "aba";
        System.out.println(KMP(s, p));
    }

    // 返回s中能够匹配的字符串的起始index
    public static int KMP(String s, String p) {
        int sL = s.length();
        int pL = p.length();
        int[] next = new int[sL];
        int res = 0;
        // next数组计算
        for (int i = 2, j = 0; i < pL; i++) {
            while (j != 0 && p.charAt(i) != p.charAt(j + 1)) j = next[j];
            if (p.charAt(i) == p.charAt(j + 1)) j++;
            next[i] = j;
        }

        // KMP匹配算法
        for (int i = 1, j = 0; i <= sL; i++) {
            while (j != 0 && s.charAt(i) != p.charAt(j + 1)) j = next[j];
            if (s.charAt(i) == p.charAt(j + 1)) j++;
            if (j == pL) {
                j = next[j];
                res = i - pL;
            }
        }
        return res;
    }
}
