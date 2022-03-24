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
        if (root.left != null) res |= findTarget(root.left, k);
        if (root.right != null) res |= findTarget(root.right, k);
        return res;
    }

    // 将树二合并到树一上
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        if (root2 != null) {
            if (root1 != null) root1.val = root1.val + root2.val;
            else root1 = new TreeNode(root2.val);
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
        }
        return root1;
    }
}
