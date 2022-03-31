package Offer;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Offer36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    public Node treeToDoublyListW(Node root) {
        // 中序非递归遍历 记录前节点left 并指向next right
        if (root == null) return null;
        Node node = root;
        Node head = root;
        Stack<Node> nodes = new Stack<>();
        nodes.add(node);
        while (node != null || !nodes.isEmpty()) {
            while (node != null) {
                nodes.add(node);
                node = node.left;
            }
            if (!nodes.isEmpty()) {
                Node cur = nodes.peek();
                node = nodes.pop();
                cur.left = pre;
                if (pre != null) pre.right = cur;
                pre = cur;
                node = node.right;
            }
        }
        head.left = pre;
        pre.right = head;
        return head;
    }

    Node pre, head;
    public Node treeToDoublyList(Node root) {
        // 中序非递归遍历 记录前节点left 并指向next right
        if (root == null) return null;
        inorderTraversal(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void inorderTraversal(Node cur) {
        if (cur == null) return;
        inorderTraversal(cur.left);
        if (pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        inorderTraversal(cur.right);
    }
}
