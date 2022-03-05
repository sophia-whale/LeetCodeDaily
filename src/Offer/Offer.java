package Offer;

import java.util.Arrays;
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
        System.out.println(buildTree(preorder, inorder).val);
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

    public static TreeNode subTree(int[] preorder, int[] inorder, int root, int left, int right) {
        if (left > right) return null;
        TreeNode treeNode = new TreeNode(preorder[root]);
        int iRoot = left;
        for (int i = left; i < right; i++) {
            if (preorder[root] == inorder[i]) {
                iRoot = i;
            }
        }
        treeNode.left = subTree(preorder, inorder, root + 1, left, iRoot - 1);
        // pre_root_idx 当前的根  左子树的长度 = 左子树的左边-右边 (idx-1 - in_left_idx +1) 。最后+1就是右子树的根了
        treeNode.right = subTree(preorder, inorder, root + iRoot - left + 1, iRoot + 1, right);
        return treeNode;
    }
}
