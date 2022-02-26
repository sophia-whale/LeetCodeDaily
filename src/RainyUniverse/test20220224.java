package RainyUniverse;

public class test20220224 {
    public static void main(String[] args){
//        int[][] grid = {{1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}, {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}};
        int[][] grid = {{-1}};
        Solution1 solution1 = new Solution1();
        int[] res = solution1.findBall(grid);
        for(int i = 0; i < grid[0].length; i++){
            System.out.println(res[i]);
        }
    }
}

class Solution1 {
    public int[] findBall(int[][] grid) {
        int len = grid.length;
        int[] last = new int[grid[0].length];
        for(int i = 0; i < grid[0].length; i++){
            last[i] = i;
        }
        for(int i = 0; i < len; i++){
            for(int j = 0; j < grid[0].length; j++){
                int current = last[j];
                if(current == -1){
                    continue;
                }
                if(grid[i][current] == 1){
                    if(current == grid[0].length - 1){
                        last[j] = -1;
                    }
                    else if(grid[i][current+1] == -1){
                        last[j] = -1;
                    }
                    else if(grid[i][current+1] == 1){
                        last[j] = current + 1;
                    }
                }
                else if(grid[i][current] == -1){
                    if(current == 0){
                        last[j] = -1;
                    }
                    else if(grid[i][current-1] == 1){
                        last[j] = -1;
                    }
                    else if(grid[i][current-1] == -1){
                        last[j] = current - 1;
                    }
                }
            }
        }
        return last;
    }
}