package L202201;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class StockPriceFluctuation {
    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        // obj.update(timestamp,price);
        // 输入：
        //["StockPrice", "update", "update", "current", "maximum", "update", "maximum",
        //"update", "minimum"]
        //[[], [1, 10], [2, 5], [], [], [1, 3], [], [4, 2], []]
        //输出：
        //[null, null, null, 5, 10, null, 5, null, 2]
        stockPrice.update(1, 10);
        stockPrice.update(2,5);
        System.out.println(stockPrice.current());
        System.out.println(stockPrice.maximum());
        stockPrice.update(1, 3);
        System.out.println(stockPrice.maximum());
        stockPrice.update(4, 2);
        System.out.println(stockPrice.minimum());
    }

    static class StockPrice {
        HashMap<Integer, Integer> stockPrice = new HashMap<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int curTime = 0;

        public StockPrice() {

        }

        // 更新忽略了数据被更改时 可能会丢失曾经的最大值或最小值的情况
        public void update(int timestamp, int price) {
            if (stockPrice.containsKey(timestamp)) {
                int curHash = stockPrice.get(timestamp);
                int curTree = treeMap.get(curHash);
                if (curTree == 1) treeMap.remove(curHash);
                else treeMap.put(curHash, curTree - 1);
                stockPrice.replace(timestamp, price);
            }
            stockPrice.put(timestamp, price);
            treeMap.put(price, treeMap.getOrDefault(price, 0) + 1);
            curTime = Math.max(curTime, timestamp);
        }

        public int current() {
            return stockPrice.get(curTime);
        }

        public int maximum() {
            /*int max = -1;
            *//*for (int i = 0; i < this.stockPrice.size(); i++) {
                if (this.stockPrice.get(i) > max) {
                    max = this.stockPrice.get(i);
                }
            }*//*
            for (Integer key : stockPrice.keySet()) {
                int value = stockPrice.get(key);
                if (value > max) max = value;
            }
            return max;*/
            return treeMap.lastKey();
        }

        public int minimum() {
            /*int min = Integer.MAX_VALUE;
            *//*for (int i = 0; i < this.stockPrice.size(); i++) {
                if (this.stockPrice.get(i) < min) min = this.stockPrice.get(i);
            }*//*
            for (Integer key : stockPrice.keySet()) {
                int value = stockPrice.get(key);
                if (value < min) min = value;
            }
            return min;*/
            return treeMap.firstKey();
        }
    }
}
