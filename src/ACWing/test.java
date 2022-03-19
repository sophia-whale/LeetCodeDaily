package ACWing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
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
    }
}
