package Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Fib {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        // System.out.println(fib2(0));
        /*List<List<Integer>> lists = permute(nums);
        for (List l : lists) {
            System.out.println(l);
        }*/
        char[][] board = {
                {'a','a','a'},
                {'a','b','b'},
                {'a','b','b'},
                {'b','b','b'},
                {'b','b','b'},
                {'a','a','a'},
                {'b','b','b'},
                {'a','b','b'},
                {'a','a','b'},
                {'a','b','a'}
        };
        char[][] board1 = {{'a'}};
        String word = "b";
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
    static int[][] isVisited;
    public static boolean exist(char[][] board, String word) {
        boolean isExist;
        int m = board.length;
        int n = board[0].length;
        isVisited = new int[m][n];
        // 查找board中与word首字母相同的字符的位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                isExist = exist(board, word, i, j, 0);
                /*if (board[i][j] == word.charAt(0)) {
                    isVisited[i][j] = 1;
                    for (int k = 0; k < 4; k++) {
                        boolean cur = ;
                        if (!cur && (i + x[k] >= 0 && i + x[k] < board.length) && (j + y[k] >= 0 && j + y[k] < board[0].length)) isVisited[i + x[k]][j + y[k]] = 0;

                    }
                }*/
                if (isExist) return true;
            }
        }
        return false;
    }

    public static boolean exist(char[][] board, String word,int i, int j, int target) {
        if (board[i][j] != word.charAt(target)) return false;
        if (target == word.length() - 1) return true;
        boolean isExist = false;
        isVisited[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            if (i + x[k] >= 0 && i + x[k] < board.length && j + y[k] >= 0 && j + y[k] < board[0].length) {
                if (isVisited[i + x[k]][j + y[k]] == 0) {
                    isExist = exist(board, word, i + x[k], j + y[k], target + 1);
                }
                if (isExist) break;
            }
        }
        isVisited[i][j] = 0;
        /*
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;

        if (board[i][j] == word.charAt(target) && isVisited[i][j] == 0) {
            isVisited[i][j] = 1;
        }*/
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

    public static int search(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (num == target) count++;
        }
        return count;
    }

    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return -1;
    }
}
