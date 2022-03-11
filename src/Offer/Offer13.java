package Offer;

public class Offer13 {
    public static void main(String[] args) {
        System.out.println(movingCount(38, 15, 9));
        System.out.println(movingCount(11, 8, 16));
    }

    static boolean[][] visit;
    static int row,col,base;
    static int count = 0;
    public static int movingCount(int m, int n, int k) {
        row = m;
        col = n;
        base = k;
        visit = new boolean[m][n];
        return dfs(0, 0);
    }

    public static int dfs(int i, int j) {
        // 计算当前坐标的十位数和个位数之和
        int sum = i / 10 + i % 10 + j / 10 + j % 10;
        // System.out.println(sum + " " + i + " " + j);
        if (i >= row || j >= col ||sum > base || visit[i][j]) return 0;
        visit[i][j] = true;
        count ++;
        return 1 + dfs(i + 1, j) + dfs(i, j + 1);
    }
}
