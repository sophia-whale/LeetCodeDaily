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
       //root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
        TreeNode root = new TreeNode(3);
        TreeNode rootL = root.left = new TreeNode(5);
        TreeNode rootR = root.right = new TreeNode(1);
        rootL.left = new TreeNode(6);
        rootL.right = new TreeNode(2);
        rootL.right.left = new TreeNode(7);
        rootL.right.right = new TreeNode(4);
        rootR.left = new TreeNode(0);
        rootR.right = new TreeNode(8);
        List<List<Integer>> lists = levelOrderEnd(root);
        for (List<Integer> cur: lists) {
            System.out.println(cur);
        }
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        TreeNode res = lowestCommonAncestor(root, p, q);
        System.out.println(res.val);
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

    // 层次遍历并记录每层的结束节点
    public static List<List<Integer>> levelOrderEnd(TreeNode root) {
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

    // 层次遍历
    public static int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> nums = new ArrayList<>();
        Deque<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode cur = nodeQueue.poll();
            nums.add(cur.val);
            if (cur.left != null) nodeQueue.add(cur.left);
            if (cur.right != null) nodeQueue.add(cur.right);
        }

        int[] res = new int[nums.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = nums.get(i);
        }
        return res;
    }

    // 前序遍历 递归
    // List<Integer> nums = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new LinkedList<>();
        nums.add(root.val);
        if (root.left != null) preorderTraversal(root.left);
        if (root.right != null) preorderTraversal(root.right);
        return nums;
    }

    List<Integer> nums = new LinkedList<>();
    // 前序遍历 非递归
    /*
     * @Author Whale Feng
     * @Description
     * //TODO 根据前序遍历过程可知，中左右。
     *    使用栈实现先进后出，使得右节点能够最后遍历，对于每一个根结点都先访问后，再依次将右节点和左节点放入
     * @Date 19:40 2022/3/26
     * @Param [root]
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> preorderTraversalNon(TreeNode root) {
        if (root == null) return new LinkedList<>();
        Stack<TreeNode> nodes = new Stack<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode cur = nodes.pop();
            nums.add(cur.val);
            if (cur.right != null) nodes.add(cur.right);
            if (cur.left != null) nodes.add(cur.left);
        }
        return nums;
    }

    // 中序遍历 递归
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new LinkedList<>();
        if (root.left != null) inorderTraversal(root.left);
        nums.add(root.val);
        if (root.right != null) inorderTraversal(root.right);
        return nums;
    }

    // 中序遍历 非递归
    /*
     * @Author Whale Feng
     * @Description
     * //TODO 中序遍历 左中右 使用栈，将每个节点的左节点通过while循环全部放入栈内，
     *    而后访问栈中节点，此时访问的节点一定位于树的最左侧，而后将其右节点放入
     * @Date 19:46 2022/3/26
     * @Param [root]
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> inorderTraversalNon(TreeNode root) {
        if (root == null) return new LinkedList<>();
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode cur = root;
        nodes.add(root);
        while (cur != null || !nodes.isEmpty()) {
            while (cur != null) {
                nodes.add(cur);
                cur = cur.left;
            }

            if (!nodes.isEmpty()) {
                cur = nodes.pop();
                nums.add(cur.val);
                cur = cur.right;
            }
        }
        return nums;
    }

    // 后序遍历 递归
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new LinkedList<>();
        if (root.left != null) inorderTraversal(root.left);
        if (root.right != null) inorderTraversal(root.right);
        nums.add(root.val);
        return nums;
    }

    // 后序遍历 非递归
    /*
     * @Author Whale Feng
     * @Description
     * //TODO 后序遍历 左右中
     * @Date 19:52 2022/3/26
     * @Param [root]
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> postorderTraversalNon(TreeNode root) {
        if (root == null) return new LinkedList<>();
        Stack<TreeNode> nodes = new Stack<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode cur = nodes.pop();
            nums.add(cur.val);
            if (cur.left != null) nodes.add(cur.left);
            if (cur.right != null) nodes.add(cur.right);
        }
        for (int i = 0; i < nums.size() / 2; i++) {
            int temp = nums.get(i);
            nums.set(i, nums.get(nums.size() - 1 - i));
            nums.set(nums.size() - 1 - i, temp);
        }
        return nums;
    }

    // 后序遍历
    int cur;
    public boolean verifyPostorder(int[] postorder) {
        int length = postorder.length;
        if (length < 3) return true;
        cur = length - 1;
        build(postorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        // 若节点能够全部成功加入树中，则cur=-1
        return cur < 0;
    }

    public void build(int[] postorder, int low, int high) {
        if (cur < 0) return;
        int base = postorder[cur];
        if (base <= low || base >= high) return;
        cur--;
        build(postorder, base, high);// 先构建右子树
        build(postorder, low, base);// 再构建左子树
    }

    static boolean flag;
    static TreeNode res;
    static int m,n;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 后序遍历如果当前节点正确且左右子树中有一个正确 或 当前节点的左右子树同时正确
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p ,q);
        if(left == null && right == null) return null;
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

    public static TreeNode postorder(TreeNode root) {
        if (flag) return null;
        if (root == null) return null;
        TreeNode left = postorder(root.left);
        TreeNode right = postorder(root.right);
        if (left != null && right != null) {
            res = root;
            return root;
        } else if (root.val == m || root.val == n) {
            if (left != null || right != null) {
                res = root;
                flag = true;
            }
            return root;
        }
        if (!flag) {
            if (left != null) return left;
            if (right != null) return right;
        }
        return null;
    }

}
