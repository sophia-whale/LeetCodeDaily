package Offer;

import java.util.*;

public class Offer26 {
   static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
   }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode rootL = root.left = new TreeNode(9);
        TreeNode rootR = root.right = new TreeNode(20);
        rootL.left = new TreeNode(6);
        rootR.left = new TreeNode(15);
        rootR.right = new TreeNode(7);
        List<List<Integer>> lists = levelOrder(root);
        for (List<Integer> cur: lists) {
            System.out.println(cur);
        }

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
        if (root == null) return true;
        TreeNode base = root.left;
        return compare(root.right, base);
    }

    public boolean compare(TreeNode root, TreeNode base) {
        if ((root == null && base != null) || (base == null && root != null)) return false;
        if (root == null && base == null) return true;
        if (root.val != base.val) return false;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        boolean left = compare(root.left, base.left);
        boolean right = compare(root.right, base.right);
        return left && right;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        Deque<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(root);
        LinkedList<Integer> layer = new LinkedList<>();
        int layerNum = 1;
        /*int end = 1;
        int num = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode cur = nodeQueue.peek();
            if (cur.left != null) {
                nodeQueue.add(cur.left);
                end++;
            }

            if (cur.right != null) {
                nodeQueue.add(cur.right);
                end++;
            }
            nodeQueue.remove();
            end--;
            num--;
            layer.add(cur.val);
            if (num == 0) {
                num = end;
                lists.add(layer);
                layer = new ArrayList<>();
            }
        }*/

        // 优化，扫描完根节点后得到第二层的全部节点 当前queue的长度即为第二层结点数
        // 以此类推 for循环扫描完第二层节点，将第三层节点全部加入队列，以此类推
        while (!nodeQueue.isEmpty()) {
            int queueL = nodeQueue.size();
            for (int i = 0; i < queueL; i++) {
                TreeNode cur = nodeQueue.poll();
                if (layerNum % 2 == 1) layer.addLast(cur.val);
                else layer.addFirst(cur.val);
                if (cur.left != null) {
                    nodeQueue.add(cur.left);
                }

                if (cur.right != null) {
                    nodeQueue.add(cur.right);
                }
            }
            layerNum++;
            lists.add(layer);
            layer = new LinkedList<>();
        }
        return lists;
    }
}
