package Offer;



public class Offer18 {

    class ListNode
    {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        ListNode last = head;
        ListNode res = head.next;
        while (res != null) {
            if (res.val == val) {
                last = res;
                last.next = res.next;
                break;
            }
            last = last.next;
            res = res.next;
        }
        return head;
    }
}

