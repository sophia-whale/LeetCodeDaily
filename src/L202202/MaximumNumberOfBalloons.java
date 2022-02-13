package L202202;

import java.util.HashMap;

public class MaximumNumberOfBalloons {
    public static void main(String[] args) {
        String text = "ekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw";
        System.out.println(maxNumberOfBalloons(text));
    }

    public static int maxNumberOfBalloons(String text) {
        int result = Integer.MAX_VALUE;
        HashMap<Character, Integer> counts = new HashMap<>(); // b a l o n
        counts.put('b', 0);
        counts.put('a', 0);
        counts.put('l', 0);
        counts.put('o', 0);
        counts.put('n', 0);

        for (int i = 0; i < text.length(); i++) {
            counts.merge(text.charAt(i), 1, Integer::sum);
        }

        if (counts.get('b') < result) {
            result = counts.get('b');
        }
        if (counts.get('a') < result) {
            result = counts.get('a');
        }
        if ((counts.get('l')/2) < result) {
            result = counts.get('l')/2;
        }
        if (counts.get('o')/2 < result) {
            result = counts.get('o')/2;
        }
        if (counts.get('n') < result) {
            result = counts.get('n');
        }
        if (counts.get('o') < 2 || counts.get('l') < 2) {
            result = 0;
        }

        return result;
    }
}
