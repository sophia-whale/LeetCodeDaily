package Offer;

public class Offer22 {

    class ListNode
    {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }

    // 两次遍历
    public ListNode getKthFromEnd(ListNode head, int k) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        int curL = 0;
        while (head != null && curL < length - k) {
            curL++;
            head = head.next;
        }
        return head;
    }

    //快慢指针 一次遍历
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
