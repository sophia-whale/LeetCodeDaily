package EasyProblem;

import Offer.Offer24;

public class Linked {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode node = head;
        int add = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + add;
            add = sum / 10;
            node.next = new ListNode(sum % 10);
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + add;
            add = sum / 10;
            node.next = new ListNode(sum % 10);
            node = node.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + add;
            add = sum / 10;
            node.next = new ListNode(sum % 10);
            node = node.next;
            l2 = l2.next;
        }

        if (add == 1) node.next = new ListNode(1);
        return head.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode node = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                node.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            node = node.next;
        }

        if (list1 != null) node.next = list1;
        else node.next = list2;
        return head.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        node = head;
        for (int count = 0; count < length / k; count++) {
            ListNode pre = null;
            ListNode cur = node;
            for (int i = 0; i < k; i++) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            node = cur.next;
        }
        return node;
    }

    public static void main(String[] args) {

    }
}
