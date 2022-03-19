package L202203;

public class ConstructStringfromBinaryTree {
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

    String res = "";
    public String tree2str(TreeNode root) {
        preOrder(root);
        return res.substring(1, res.length() - 1);
    }

    public void preOrder(TreeNode node) {
        res = res + "(" + node.val;
        if (node.left != null) preOrder(node.left);
        else if (node.right != null) res += "()";

        if (node.right != null) preOrder(node.right);
        res += ")";
    }
}
