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
        Node node = new Node(head.val);
        Node cur = node;
        // 记录每个索引的node
        LinkedList<Node> nodeList = new LinkedList<>();
        // 记录每个索引对应的random node的索引
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        while (head != null) {
            if (head.next != null) cur.next = new Node(head.next.val);
            else cur.next = null;
            nodeList.add(cur);
            /*if (head.random != null) cur.next = head.random;
            else cur.random = null;*/
            head = head.next;
            cur = cur.next;
        }
        return node;
    }
}
