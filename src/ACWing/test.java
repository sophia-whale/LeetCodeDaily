package ACWing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class test {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int key = sc.nextInt();
            int value = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            if (map.containsKey(key)) {
                list = map.get(key);
            }
            list.add(value);
            map.put(key, list);
        }
    }*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arrA = new int[n];
        for(int i = 0; i < n; i++){
            arrA[i] = sc.nextInt();
        }

        int sumA = 0;
        for(int i = 0; i < n; i++){
            sumA = sumA + arrA[i];
        }
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            int minVal = Math.max(1, s - (sumA - arrA[i]));
            int maxVal = Math.min(arrA[i], s - n + 1);
            res[i] = (minVal - 1) + (arrA[i] - maxVal);
        }

        for(int i = 0; i < n; i++){
            if (i != n - 1) {
                System.out.print(res[i] + " ");
            } else {
                System.out.println(res[i]);
            }
        }
    }
}
