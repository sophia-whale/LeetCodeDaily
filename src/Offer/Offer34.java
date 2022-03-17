package Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer34 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 查找从根节点到叶节点路径长为target的路径
    LinkedList<List<Integer>> pathSum = new LinkedList<>();
    LinkedList<Integer> curPath = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        backtracking(root, target, 0);
        return pathSum;
    }

    public void backtracking(TreeNode root, int target, int curSum) {
        if (root == null) return;
        curSum += root.val;
        // if (curSum > target) return; 本意剪枝 但未考虑到数组中元素为复数的情况 故剪枝失败 呜呜呜
        curPath.add(root.val);
        if (curSum == target && root.left == null && root.right == null) {
            // 仅清除当前成功达到target的最后一个节点，若将linked全部清空，则接下来的能够达到target的数组将会丢失前向数据
            // 例如 若正确结果为 [[5,11,4,2],[5,8,4,5]] 假如在查找到[5,11,4,2]后将数组清空，则[5,8,4,5]将丢失根结点5，结果为[8,4,5]
            pathSum.add(new LinkedList<>(curPath));
            curPath.removeLast();
            return;
        }
        backtracking(root.left, target, curSum);
        backtracking(root.right, target, curSum);
        curPath.removeLast();
    }
}
