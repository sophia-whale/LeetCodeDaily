package EasyProblem;

public class BiNode {
    public static void main(String[] args) {
        System.out.println(convertBiNode(new TreeNode(2)));
    }

    public static TreeNode head = null, pre = null;
    public static TreeNode convertBiNode(TreeNode root) {
        if (root ==  null) return null;
        convertBiNode(root.left);
        if (head == null) {
            head = root;
        } else {
            pre.right = root;
        }
        pre = root;
        pre.left = null;
        convertBiNode(root.right);
        return head;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
