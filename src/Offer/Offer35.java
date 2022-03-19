package Offer;

import java.util.HashMap;
import java.util.LinkedList;

public class Offer35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        int length = 0;
        Node node = new Node(head.val);
        Node res = node;
        // 记录每个索引的node
        LinkedList<Node> nodeList = new LinkedList<>();
        while (head != null) {
            nodeList.add(head);
            head = head.next;
            length++;
        }

        for (int i = 0; i < length - 1; i++) {
            Node cur = new Node(nodeList.get(0).val);
            cur.next = nodeList.get(i + 1);
            cur.random = nodeList.get(i).random;
            node.next = cur;
            node = node.next;
        }
        node.next = null;
        node.random = nodeList.get(length - 1);

        return res;
    }
}
