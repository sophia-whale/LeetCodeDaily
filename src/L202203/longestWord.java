package L202203;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class longestWord {
    public static void main(String[] args) {
        String[] words = {"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"};
        System.out.println(longestWord(words));
    }

    public static String longestWord(String[] words) {
        Arrays.sort(words, (a, b) ->  {
            if (a.length() != b.length()) {
                // 将长度小的放在前边
                return a.length() - b.length();
            } else {
                // 将字典序小的字母放在后边 从而达到相同字母长度时 返回字典序小的字符串
                return b.compareTo(a);
            }
        });
        String max = "";
        Set<String> set = new HashSet<>();
        set.add("");
        for (String word : words) {
            if (set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                max = word;
            }
        }
        return max;
    }
}
