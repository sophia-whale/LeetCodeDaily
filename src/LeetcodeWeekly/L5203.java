package LeetcodeWeekly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L5203 {
    public static void main(String[] args) {
        L5203 l = new L5203();
        int[][] artifacts = {{0,0,0,0},{0,1,1,1}};
        int[][] dig = {{0,0},{0,1}};

        /*int[][] artifacts = {{0,2,0,5},{0,1,1,1},{3,0,3,3},{4,4,4,4},{2,1,2,4}};
        int[][] dig = {{0,2},{0,3},{0,4},{2,0},{2,1},{2,2},{2,5},{3,0},{3,1},{3,3},{3,4},{4,0},{4,3},{4,5},{5,0},{5,1},{5,2},{5,4},{5,5}};
*/
        /*int[][] artifacts = {{5,1,7,1},{1,8,3,8},{1,1,1,2},{6,4,6,6},{2,7,5,7},{0,2,0,2},{7,7,8,8},{3,1,4,2},{2,3,3,3},{5,3,7,3},{8,4,8,4},{2,6,5,6},{8,1,8,2},{4,8,4,8},{1,0,4,0},{6,8,6,8},{1,3,1,4},{0,7,0,8},{0,3,0,4},{0,6,0,6}};
        int[][] dig = {{0,3},{0,4},{8,5},{8,6},{8,7},{0,8},{8,8},{0,6},{1,1},{1,8},{2,0},{2,2},{2,3},{2,4},{2,5},{2,8},{3,2},{3,3},{3,4},{3,5},{3,6},{3,7},{4,0},{4,3},{4,4},{4,6},{4,7},{5,1},{5,2},{5,6},{5,8},{6,0},{6,2},{6,4},{6,5},{6,6},{7,0},{7,1},{7,4},{7,5},{7,7}};
        */
        System.out.println(l.digArtifacts(2, artifacts, dig));
    }

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        if (dig.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < artifacts.length; i++) {
            boolean flag = splitArt(artifacts[i], dig);
            if (flag) count++;
        }
        return count;
    }

    public boolean splitArt(int[] loc, int[][] digList) {
        int num = 4;
        List<int[]> art = new ArrayList<>();
        if (loc[0] == loc[2] && loc[1] == loc[3]) {
            num = 1;
            int[] cur = {loc[0], loc[1]};
            art.add(cur);
        } else if (loc[0] == loc[2] || loc[1] == loc[3]) {
            if (loc[2] - loc[0] > 1) {
                num = loc[2] - loc[0] + 1;
                for (int i = 0; i < num; i++) {
                    int[] cur = {loc[0] + i, loc[1]};
                    art.add(cur);
                }
            } else if (loc[3] - loc[1] > 1) {
                num = loc[3] - loc[1] + 1;
                for (int i = 0; i < num; i++) {
                    int[] cur = {loc[0], loc[1] + i};
                    art.add(cur);
                }
            } else {
                num = 2;
                int[] cur = {loc[0], loc[1]};
                art.add(cur);
                cur = new int[] {loc[2], loc[3]};
                art.add(cur);
            }

        } else {
                int[] cur = {loc[0], loc[1]};
                art.add(cur);
                cur = new int[] {loc[0] + 1, loc[1]};
                art.add(cur);
                cur = new int[] {loc[0], loc[1] + 1};
                art.add(cur);
                cur = new int[] {loc[2], loc[3]};
                art.add(cur);
        }


        for (int i = 0; i < num; i++) {
            int[] curArt = art.get(i);
            boolean flag = false;
            for (int j = 0; j < digList.length; j++) {
                int[] curDig = digList[j];
                if (curDig[0] == curArt[0] && curDig[1] == curArt[1]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) return false;
        }
        return true;
    }
}
