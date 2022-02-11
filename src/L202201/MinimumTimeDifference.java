package L202201;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class MinimumTimeDifference {
    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>();
        timePoints.add("23:59");
        timePoints.add("00:01");
        System.out.println(findMinDifference(timePoints));
    }

    public static int findMinDifference(List<String> timePoints) {
        // 思路一 将数组排序 将数组赋值为前后两项的差值 当前项减前一项的差值保存到当前
        // 首项的差值为首项减最后一项取绝对值
        // 在减项过程中不断更新最小值
        int min = Integer.MAX_VALUE;
        int length = timePoints.size();
        List<Long> timeLong = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            timeLong.add(milli(timePoints.get(i)));
        }
        Arrays.sort(new List[]{timeLong});

        for (int i = 1; i < length; i++) {
            int minutes = (int) ((timeLong.get(i) - timeLong.get(i - 1)) / 60000);
            if (minutes < min) min = minutes;
        }

        int last = (int) ((timeLong.get(0) - timeLong.get(length - 1)) / 60000);
        if (last < 0) last += 1440;
        if (last < min) min = last;
        return min;
    }

    public static long milli(String s) {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(df.parse(s));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long milliSecond = calendar.getTime().getTime();
        return milliSecond;
    }
}
