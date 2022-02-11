import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        // System.out.println(eraseOverlapIntervals(intervals));
        int[][] points = {{10,9,10},{9,10,9},{20,20,20}};
        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        int[] one = {3, 4, 2, 8};
        String[] strings = {"assx", "sa", "sscs"};
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println("o1:" + o1);
                /*for(int i=0; i<o1.length; i++){
                    System.out.println(o1[i]+' ');
                }
                System.out.println();*/
                System.out.println("o2:" + o2);
                /*for(int i=0; i<o2.length; i++){
                    System.out.println(o2[i]+' ');
                }
                System.out.println();*/

                return o1.compareTo(o2);
            }
        });
        return 0;
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        int[] first = new int[intervals.length];
        int[] last = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            first[i] = intervals[i][0];
            last[i] = intervals[i][1];
        }
        //冒泡排序
        for(int i = 0; i < intervals.length; i++){
            for(int j = 0; j < intervals.length - i - 1; j++){
                if(first[j] >= first[j+1]){
                    if(first[j] == first[j+1]){
                        if(last[j] > last[j+1]){
                            int temp = first[j];
                            first[j] = first[j+1];
                            first[j+1] = temp;

                            temp = last[j];
                            last[j] = last[j+1];
                            last[j+1] = temp;
                        }
                    }else{
                        int temp = first[j];
                        first[j] = first[j+1];
                        first[j+1] = temp;

                        temp = last[j];
                        last[j] = last[j+1];
                        last[j+1] = temp;
                    }
                }
            }
        }

        //快速排序


        //找出区间右端最小值
        /*int min_last = last[0];
        for(int i = 0; i < intervals.length; i++){
            if(last[i] < min_last){
                min_last = last[i];
            }
        }*/
        //目前找到一个区间
        int count = 1;
        //初始化区间左端最小值  为   区间左端最大值
        // int min_first;
        int max_first = first[0];
        for(int i = 0; i < intervals.length; i++){
            if(first[i] >= max_first){
                max_first = first[i];
            }
        }
        for(;;){
            System.out.println(max_first);
            // min_first = max_first;
            int flag = 0;
            int max_first_flag = intervals.length - 1;
            //在目前找到的区间右端寻找区间左端最小值
            for(int i = intervals.length - 1; i > 0; i--){
                if(first[i] >= max_first){
                    max_first = first[i];
                    max_first_flag = i;
                    flag = 1;
                }
            }
            //判断是否找到
            if(flag == 1){
                count++;
                max_first = last[max_first_flag];
                System.out.println(max_first);
            }else{
                break;
            }
        }
        return intervals.length - count;
    }
}
