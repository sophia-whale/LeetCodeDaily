package LeetcodeWeekly;

public class L6055 {
    public static void main(String[] args) {
        System.out.println(convertTime("02:30", "04:35"));
        // current = "02:30", correct = "04:35" 1 5 15 60
    }

    public static int convertTime(String current, String correct) {
        int count = 0;
        int curMin = Integer.parseInt(current.substring(0,2)) * 60 + Integer.parseInt(current.substring(3, 5));
        int corrMin = Integer.parseInt(correct.substring(0,2)) * 60 + Integer.parseInt(correct.substring(3, 5));
        while (corrMin != curMin) {
            if (corrMin - curMin >= 60) {
                corrMin -= 60;
                count++;
            } else if (corrMin - curMin >= 15) {
                corrMin -= 15;
                count++;
            } else if (corrMin - curMin >= 5) {
                corrMin -= 5;
                count++;
            } else if (corrMin - curMin >= 1) {
                corrMin -= 1;
                count++;
            }

        }
        return count;
    }
}
