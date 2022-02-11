package L202201;

public class SlowestKey {
    public static void main(String[] args) {
        int[] releaseTimes = {1, 2};
        String keysPressed = "ba";
        System.out.println(slowestKey(releaseTimes, keysPressed));
    }

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        char[] keys = keysPressed.toCharArray();
        int last = 0;
        int maxTime = releaseTimes[0];
        int maxIndex = 0;
        for (int i = 0; i < releaseTimes.length - 1; i++) {
            int minus = releaseTimes[i + 1] - releaseTimes[i];
            if (minus > maxTime) {
                maxIndex = i + 1;
                maxTime = minus;
            }
            if (minus == maxTime && keys[i + 1] - keys[maxIndex] > 0) {
                maxIndex = i + 1;
            }
        }
        return keys[maxIndex];
    }
}
