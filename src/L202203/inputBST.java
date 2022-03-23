package L202203;

import java.util.HashSet;

public class inputBST {
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

    static HashSet<Integer> set = new HashSet<>();
    static boolean res = false;
    public static boolean findTarget(TreeNode root, int k) {
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        //if (root.left == null && root.right == null && root.val != k) return false;
        if (root.left != null) res |= findTarget(root.left, k);
        if (root.right != null) res |= findTarget(root.right, k);
        return res;
    }
}
