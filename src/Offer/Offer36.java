package Offer;

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

    public Node treeToDoublyList(Node root) {
        preOrder(root);
        return root;
    }

    public Node preOrder(Node root) {
        if (root == null) return null;
        root.left = preOrder(root.left);

        root.right = preOrder(root.right);
        return root;
    }
}
