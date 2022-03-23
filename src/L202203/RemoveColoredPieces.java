package L202203;

public class RemoveColoredPieces {
    public static void main(String[] args) {
        System.out.println(winnerOfGame("ABBBBBBBAAA"));
    }

    public static boolean winnerOfGame(String colors) {
        char[] chars = colors.toCharArray();
        int a = 0;
        int b = 0;
        for (int i = 1; i < chars.length - 1; i++) {
            if (chars[i - 1] == 'A' && chars[i] == 'A' && chars[i + 1] == 'A') a++;
            if (chars[i - 1] == 'B' && chars[i] == 'B' && chars[i + 1] == 'B') b++;
        }
        return a > b;
    }
}
