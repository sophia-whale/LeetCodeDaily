package Offer;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Offer {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        int[][] m = {{-1, 3}};
        int target = -1;
        // System.out.println(findNumberIn2DArray(m, target));
        // System.out.println(findRepeatNumber(nums));
        // System.out.println(findRepeatNumber1(nums));
        // System.out.println(replaceSpace("We are happy."));

        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        // System.out.println(Arrays.toString(reversePrint(head)));

        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = buildTree(preorder, inorder);
        //队列实现层次遍历
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.addLast(treeNode);
        while(!queue.isEmpty()){
            TreeNode curNode = queue.removeFirst();
            System.out.println(curNode.val);
            if(curNode.left != null){
                queue.addLast(curNode.left);
            }
            if(curNode.right != null){
                queue.addLast(curNode.right);
            }
        }
    }

    public static int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                return nums[i];
            }
            hashMap.put(nums[i], i);
        }
        return -1;
    }

    public static int findRepeatNumber1(int[] nums) {
        // 利用图中所给取值范围以及数组索引
        // 将数组调整索引与数字值相同 遍历数组即可获知是否有重复数值
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
            } else if (nums[nums[i]] == nums[i]) {
                return nums[i];
            } else {
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 选取右上角的数字 此数字向左更小 向下更大 不会产生方向上的歧义
        int row = 0;
        if (matrix.length == 0) return false;
        int column = matrix[0].length - 1;
        if (column < 0) return false;
        int cur = matrix[row][column];
        while (row < matrix.length && column >= 0) {
            if (target == cur) {
                return true;
            } else if (target < cur) {
                column--;
            } else {
                row++;
            }
            if (row < matrix.length && column >= 0) cur = matrix[row][column];
        }
        return false;
    }

    public static String replaceSpace(String s) {
        String s1 = s.replaceAll("\\s", "%20");
        return s1;
    }

    public static int[] reversePrint(ListNode head) {
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[length - i - 1] = head.val;
            head = head.next;
        }
        return nums;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        return subTree(preorder, inorder, 0, 0, preorder.length - 1);
    }

    /***
     *
     * @param preorder
     * @param inorder
     * @param root
     * @param left 在中序遍历中 左子树的第一个节点的索引
     * @param right
     * @return
     */
    public static TreeNode subTree(int[] preorder, int[] inorder, int root, int left, int right) {
        if (left > right) return null;
        //根节点初始化
        TreeNode treeNode = new TreeNode(preorder[root]);
        int iRoot = left;
        // 查找当前根节点在中序遍历数组中的index
        for (int i = left; i < right; i++) {
            if (preorder[root] == inorder[i]) {
                iRoot = i;
            }
        }
        //左子树
        treeNode.left = subTree(preorder, inorder, root + 1, left, iRoot - 1);
        // pre_root_idx 当前的根  左子树的长度 = 左子树的左边-右边 (idx-1 - in_left_idx +1) 。最后+1就是右子树的根了
        treeNode.right = subTree(preorder, inorder, root + iRoot - left + 1, iRoot + 1, right);
        return treeNode;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 追击问题
        if (headA == null || headB == null) return null;
        ListNode n1 = headA;
        ListNode n2 = headB;
        while (n1 != n2) {
            n1 = n1 == null ? headB : n1.next;
            n2 = n2 == null ? headA : n2.next;
        }
        return n1;
    }
}
