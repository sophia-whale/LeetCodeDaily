package Algorithm.DoublePointer;

import java.util.Arrays;
import java.util.Comparator;

public class L0452 {
    public static void main(String[] args) {
        int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        System.out.println(findMinArrowShots(points));
        System.out.println();
    }

    public static int findMinArrowShots(int[][] points) {
        //按照数组第一列进行排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return 1;
                } else if (o1[1] < o2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int count = 0;
        int first_flag = 0;
        int last_flag = 0;
        while (first_flag < points.length && last_flag < points.length){
            if(points[first_flag][0] <= points[last_flag][1]) {
                first_flag++;
                if(first_flag == points.length){
                    count++;
                }
            } else if(points[first_flag][0] > points[last_flag][1]){
                count++;
                last_flag = first_flag;
            }
        }
        return count;
    }
}
