package Offer;

public class Offer26 {
   class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
   }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return findNode(A, B);
    }

    // 查找A中与B根节点相同的节点
    public boolean findNode(TreeNode A, TreeNode B) {
        if (A.val == B.val && dfs(A, B)) return true;
       return findNode(A.left, B) || findNode(A.right, B);
    }

    // 比较相同根节点下的子结点是否都相同
    public boolean dfs(TreeNode root, TreeNode B) {
       if (B == null) return true;
       if (root == null) return false;
       if (root.val != B.val) return false;
       return dfs(root.left, B.left) && dfs(root.right, B.right);
    }

    // 交换每个节点的左右子树
    public TreeNode mirrorTree(TreeNode root) {
       reverse(root);
       return root;
    }

    public void reverse(TreeNode root) {
       if (root == null) return;
       if (root.left == null) {
           root.left = root.right;
       } else if (root.right == null) {
           root.right = root.left;
       } else {
           TreeNode temp = root.left;
           root.left = root.right;
           root.right = temp;
       }
       reverse(root.left);
       reverse(root.right);
    }

    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }

    public boolean isSymmetric(TreeNode root) {

        return true;
    }
}
