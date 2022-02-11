package EasyProblem;

/*You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list.
The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.*/

public class L0021 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2));
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1, new ListNode(3));
        list2.next.next = new ListNode(4);
        ListNode mergeNode = mergeTwoLists(list1, list2);
        while (mergeNode != null){
            System.out.println(mergeNode.val);
            mergeNode = mergeNode.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergeNode = list1.val < list2.val ? list1 : list2;
        ListNode temp = null;
        while (list1.next != null && list2.next != null) {
            if (list1.next.val < list2.next.val) {

                temp.next = list1;

            } else {

            }
        }
        return mergeNode;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
