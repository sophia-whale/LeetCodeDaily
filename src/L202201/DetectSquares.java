package L202201;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DetectSquares {
    public static void main(String[] args) {

    }

    //「哈希表 套 哈希表」的方式，以 {x, {y : 点 (x,y) 数量}} 的形式对传入点进行存储。
    HashMap<Integer, HashMap<Integer, Integer>> hashMap = new HashMap<>();

    public DetectSquares() {

    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        hashMap.putIfAbsent(x, new HashMap<>());
        HashMap<Integer, Integer> yHashMap = hashMap.get(x);
        yHashMap.put(y, yHashMap.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int count = 0;
        int x = point[0];
        int y = point[1];
        if (!hashMap.containsKey(x)) {
            return 0;
        }

        HashMap<Integer, Integer> yHashMap = hashMap.get(x);
        Set<Map.Entry<Integer, HashMap<Integer, Integer>>> entries = hashMap.entrySet();
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : entries) {
            int x0 = entry.getKey();
            HashMap<Integer, Integer> y0Set = entry.getValue();
            if (x0 != x) {
                int length = x0 - x;
                count += y0Set.getOrDefault(y, 0) * yHashMap.getOrDefault(y + length, 0) * y0Set.getOrDefault(y + length, 0);
                count += y0Set.getOrDefault(y, 0) * yHashMap.getOrDefault(y - length, 0) * y0Set.getOrDefault(y - length, 0);
            }
        }
        return count;
    }
}
