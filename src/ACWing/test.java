package ACWing;

import java.io.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    /*public static void main(String[] args) {
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
    }*/
    public static void main(String[] args) {
        /*"abcabcbb" "tmmzuxt" dvdf
"bbbbb""bpfbhmipx""bbtablud"
"pwwkew"*/
        /*String s = "tmmzuxt";
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int remove = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int index = map.get(s.charAt(i));
                int cur = 0;
                int lastRemove = remove;
                while (cur < index - lastRemove + 1) {
                    map.remove(s.charAt(index));
                    index--;
                    remove++;
                }
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, map.size());
        }
        System.out.println(max);
        System.out.println(deleteText("e RSg c R cf", 10));
        int[][] roads = {{0,1},{0,2},{1,3},{2,5},{3,6},{5,4}};
        System.out.println(numFlowers(roads));*/
        //number();
        //circle();
        //cook();
        multi();
    }

    public static String deleteText(String article, int index) {
        if (article.charAt(index) == ' ') return article;
        if (!article.contains(" ")) return "";
        if (index < article.indexOf(' ')) return article.substring(article.indexOf(' ') + 1);
        if (index > article.lastIndexOf(' ')) return article.substring(0, article.lastIndexOf(' '));
        int start = index;
        int end = index;
        while (article.charAt(start) != ' ' || article.charAt(end) != ' ') {
            if (article.charAt(start) != ' ') start--;
            if (article.charAt(end) != ' ') end++;
        }
        return article.substring(0, start) + article.substring(end);
    }

    public static int numFlowers(int[][] roads) {
        int l = roads.length;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < l; i++) {

            int x = roads[i][0];
            int y = roads[i][1];
            if (map.containsKey(x)) {
                int linkX = map.get(x);
                if (linkX >= 1) count++;
            } else if (map.containsKey(y)) {
                int linkY = map.get(y);
                if (linkY >= 1) count++;
            }
            map.put(x, 1);
            map.put(y, 1);
        }
        return count;
    }

    public static void number() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][n];
        int[][] res= new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                res[i][j] = Math.max(res[i + 1][j], res[i + 1][j + 1]) + nums[i][j];
            }
        }

        System.out.println(res[0][0]);
    }

    public static void circle() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(0)) continue;
            boolean curSame = true;
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt((i + j) % s.length()) != t.charAt(j)) curSame = false;
            }
            if (curSame) count++;
        }
        System.out.println(count);
    }

    public static void cook() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = sc.nextInt();
        }

        Arrays.sort(time);
        int sum = 0;
        int last = 1;
        for (int i = 0; i < n; i++) {
            if (last >= time[i]) {
                sum += last - time[i];
                last += t;
            }
            else last = time[i] + t;
        }
        System.out.println(sum);
    }

    public static void multi() {
        Scanner sc = new Scanner(System.in);
        int aL = sc.nextInt();
        int bL = sc.nextInt();
        int aMax = Integer.MIN_VALUE;
        int bMax = Integer.MIN_VALUE;
        int aMin = Integer.MAX_VALUE;
        int bMin = Integer.MAX_VALUE;
        for (int i = 0; i < aL; i++) {
            int cur = sc.nextInt();
            if (cur > aMax) aMax = cur;
            if (cur < aMin) aMin = cur;
        }
        for (int i = 0; i < bL; i++) {
            int cur = sc.nextInt();
            if (cur > bMax) bMax = cur;
            if (cur < bMin) bMin = cur;
        }

        int r1 = Math.min(aMax * bMax, aMin * bMin);
        int r2 = Math.min(aMax * bMin, bMax * aMin);
        System.out.println(Math.min(r1, r2));
    }

    public static void square() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[9];
        int[][] square = new int[n][2];
        int[][] shape = {{3, 1, 0}, {2, 1, 1}, {1, 3, 0}, {1, 1, 2}};
        for (int i = 0; i < n; i++) {
            square[i][0] = sc.nextInt();
            square[i][1] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int curS = square[i][0] / 90;
            int loc = square[i][1];
            if (curS == 0) {
                int max = Math.max(h[loc + 1], h[loc]);
                h[loc] = max + 3;
                h[loc + 1] = max + 1;
            } else if (curS == 1) {
                int max = Math.max(Math.max(h[loc], h[loc + 1] + 1), h[loc + 2] + 1);
                h[loc] = max + 2;
                h[loc + 1] = max + 1;
                h[loc + 2] = max + 1;
            } else if (curS == 2) {
                int max = Math.max(h[loc + 1], h[loc] + 2);
                h[loc] = max + 1;
                h[loc + 1] = max + 3;
            } else if (curS == 3) {
                int max = Math.max(Math.max(h[loc], h[loc + 1]), h[loc + 2]);
                h[loc] = max + 1;
                h[loc + 1] = max + 1;
                h[loc + 2] = max + 2;
            }
        }

        StringBuffer sb = new StringBuffer();
        sb.append(h[1]);
        for (int i = 2; i < 9; i++) {
            sb.append(" " + h[i]);
        }
        System.out.println(sb);
    }
}
