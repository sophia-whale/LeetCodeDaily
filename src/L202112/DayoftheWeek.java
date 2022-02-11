package L202112;
/*Given a date, return the corresponding day of the week for that date.

The input is given as three integers representing the day, month and year respectively.

Return the answer as one of the following values
{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.
*/
public class DayoftheWeek {
    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(21, 12, 1980));
    }

    public static String dayOfTheWeek(int day, int month, int year) {
        String[] weeks = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int ans = 4; // 1971.01.01是星期五
        int totalDays = 0;
        for (int i = 1971; i < year; i++) {
            if (isLeapYear(i)) {
                totalDays = totalDays + 366;
            } else {
                totalDays = totalDays + 365;
            }
        }

        for (int i = 0; i < month - 1; i++) {
            totalDays =  totalDays + days[i];
        }

        if (month > 3 && isLeapYear(year)) totalDays++;

        ans = (totalDays + day + ans) % 7;

        return weeks[ans];
    }

    public static boolean isLeapYear(int year) {
        return  (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }
}
