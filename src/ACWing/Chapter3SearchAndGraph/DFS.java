package ACWing.Chapter3SearchAndGraph;

import java.util.Arrays;
import java.util.Scanner;

public class DFS {
    static int[] path;
    static boolean[] visit;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        path = new int[n];
        visit = new boolean[n];
        dfs(0);
    }

    public static void dfs(int cur) {
        if (cur == n) {
            StringBuilder s = new StringBuilder();
            s.append(path[0]);
            for (int i = 1; i < n; i++) {
                s.append(" ").append(path[i]);
            }
            System.out.println(s);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visit[i - 1]) {
                path[cur] = i;
                visit[i - 1] = true;
                dfs(cur + 1);
                visit[i - 1] = false;
            }
        }
    }
}
