package L202201;

public class NumberOfValidWordsInASentence {
    public static void main(String[] args) {
        System.out.println(countValidWords("!"));
    }

    // 仅由小写字母、连字符和/或标点（不含数字）。
    // 至多一个 连字符 '-' 。如果存在，连字符两侧应当都存在小写字母（"a-b" 是一个有效单词，但 "-ab" 和 "ab-" 不是有效单词）。
    // 至多一个 标点符号。如果存在，标点符号应当位于 token 的 末尾 。
    public static int countValidWords(String sentence) {
        String[] strings = sentence.split(" ");
        int count = 0;
        String regex1 = "[a-z]+-?[a-z]+(\\!|\\,|\\.)?";
        String regex2 = "[a-z]+(\\!|\\,|\\.)?";
        String regex3 = "(\\!|\\,|\\.)?";
        for (int i = 0; i < strings.length; i++) {
            System.out.println();
            if (!strings[i].equals("")) {
                if (strings[i].matches(regex1) || strings[i].matches(regex2) || strings[i].matches(regex3)) {
                    count++;
                    System.out.println(strings[i] + " " + strings[i].matches(regex1));
                    System.out.println(strings[i] + " " + strings[i].matches(regex2));
                    System.out.println(strings[i] + " " + strings[i].matches(regex3));
                }
            }
        }
        return count;
    }
}
