package LeetcodeWeekly;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class L1 {
    public static void main(String[] args) {
        //gem = [], operations = [[],[],[]]
        int[] gem = {3,1,2};
        int[][] operations = {{0,2}, {2,1}, {2,0}};
        System.out.println(giveGem(gem, operations));
    }

    public static int giveGem(int[] gem, int[][] operations) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] operation : operations) {
            int rev = operation[0];
            int add = operation[1];
            int tmp = gem[rev];
            gem[rev] = tmp - tmp / 2;
            gem[add] += tmp / 2;
        }
        for (int j : gem) {
            min = Math.min(min, j);
            max = Math.max(max, j);
        }
        return max - min;
    }

    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        int[] f = new int[100];
        for (int i = 1; i <= cookbooks.length; i++) {
            for (int j = cookbooks[i][1]; j <= 100; j++) {
                f[j] = Math.max(f[j], f[j - cookbooks[i][0]] + attribute[i][0]);
            }
        }
        return f[limit + 1];
    }

    List<Integer> nums = new ArrayList<>();
    public int getNumber(TreeNode root, int[][] ops) {
        // 中序遍历从小到大的各个数字
        midOrder(root);
        // 0为蓝色 1为红色
        int count = 0;
        int[] color = new int[nums.size()];
        for (int[] op : ops) {
            int start = nums.indexOf(op[1]);
            int end = nums.indexOf(op[2]);
            for (int j = start; j <= end; j++) {
                color[j] = op[0];
            }
        }

        for (int i = 0; i < nums.size(); i++) {
            if (color[i] == 1) count++;
        }
        return count;
    }

    public void midOrder(TreeNode node) {
        if (node == null) return;
        midOrder(node.left);
        nums.add(node.val);
        midOrder(node.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
