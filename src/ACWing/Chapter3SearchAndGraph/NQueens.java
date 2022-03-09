package ACWing.Chapter3SearchAndGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NQueens {

    public static void main(String[] args) {
        solveNQueens(4);
        for (List list : lists) {
            System.out.println(list);
        }
    }

    static boolean[] col; // 列访问标记
    static boolean[] dg; // 正对角线访问标记
    static boolean[] ndg; // 反对角线访问标记
    static List<List<String>> lists;
    static char[][] chars; //记录一次dfs的结果
    static int nQ;
    public static List<List<String>> solveNQueens(int n) {
        lists = new ArrayList<>();
        col = new boolean[n];
        // 为方便标记对角线数组，故扩大标记空间为2N
        dg = new boolean[2*n];
        ndg = new boolean[2*n];
        nQ = n;
        chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = '.';
            }
        }
        dfs(0);
        return lists;
    }

    public static void dfs(int cur) {
        if (cur == nQ) {
            List<String> s = new ArrayList<>();
            for (int i = 0; i < nQ; i++) {
                s.add(String.copyValueOf(chars[i]));
            }
            lists.add(s);
            return;
        }

        for (int i = 0; i < nQ; i++) {
            if (!col[i] && !dg[cur + i] && !ndg[nQ - cur + i]) {
                chars[cur][i] = 'Q';
                col[i] = dg[cur + i] = ndg[nQ - cur + i] = true;
                dfs(cur + 1);
                // 回溯结束撤回标记
                col[i] = dg[cur + i] = ndg[nQ - cur + i] = false;
                chars[cur][i] = '.';
            }
        }
    }
}
