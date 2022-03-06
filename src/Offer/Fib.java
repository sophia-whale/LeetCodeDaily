package Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fib {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        // System.out.println(fib2(0));
        /*List<List<Integer>> lists = permute(nums);
        for (List l : lists) {
            System.out.println(l);
        }*/
        char[][] board = {{'a','b'},{'c','d'}};
        String word = "abcd";
        System.out.println(exist(board, word));
    }

    public static int fib1(int n) {
        if (n <= 1) return n;
        return (fib1(n - 1) + fib1(n - 2)) % 1000000007;
    }

    public static int fib2(int n) {
        int sum = 1;
        int last = 1;
        int lastL = 1;
        for (int i = 1; i < n; i++) {
            sum = (last + lastL) % 1000000007;
            lastL = last;
            last = sum;
        }
        return sum;
    }

    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) return numbers[i + 1];
        }
        return numbers[0];
    }

    // 上下左右
    static int[] x = {-1, 1, 0, 0};
    static int[] y = {0, 0, -1, 1};
    public static boolean exist(char[][] board, String word) {
        boolean isExist = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    for (int k = 0; k < 4; k++) {
                        isExist = isExist || exist(board, word, i + x[k], j + y[k], 1);
                    }
                }
            }
        }
        return isExist;
    }

    public static boolean exist(char[][] board, String word,int i, int j, int target) {
        if (i < 0 || i >= board.length || j < 0 || j >= board.length) return false;
        if (target == word.length()) return true;
        boolean isExist = false;
        if (board[i][j] == word.charAt(target)) {
            for (int k = 0; k < 4; k++) {
                isExist = isExist || exist(board, word, i + x[k], j + y[k], ++target);
            }
        }
        return isExist;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int l = nums.length;
        int count = 1;
        for (int i = 1; i < l + 1; i++) {
            count *= i;
        }/*
        if (l == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            lists.add(list);
            return lists;
        }*/
        // 起始将i作为 base
        // 在余下的数组中从右到左开始交换
        // 剩下需交换 1 + ... + l-1 次，即l(l-1)次
        for (int j = 0; j < count; j++) {
            List<Integer> baseList = new ArrayList<>();
            for (int k = 0; k < l; k++) {
                baseList.add(nums[k]);
            }
            lists.add(baseList);
            int temp = nums[j % l];
            nums[j % l] = nums[(j+1) % l];
            nums[(j+1) % l] = temp;
        }
        return lists;
    }
}
