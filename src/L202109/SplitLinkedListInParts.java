package L202109;

/*
* 2021.09.22
* Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.

The length of each part should be as equal as possible: no two parts should have a size differing by more than one.
*  This may lead to some parts being null.

The parts should be in the order of occurrence in the input list,
*  and parts occurring earlier should always have a size greater than or equal to parts occurring later.

Return an array of the k parts.*/

public class SplitLinkedListInParts {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 3;
        System.out.println(splitListToParts(head, k));
    }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        // TODO calculate listNode head.length
        // TODO length/k = 每部分的数量 如果为0需在输入结果中补充k-length个null;
        // TODO length%k = 几个部分数量需要+1
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        ListNode[] parts = new ListNode[k];
        int num = length/k;
        ListNode cur = head;
        if (num == 0) {
            int index = 0;
            while (cur != null) {
                parts[index] = new ListNode(cur.val, null);
                System.out.println(cur.val);
                cur = cur.next;
                index++;
            }
            for (int i = 0; i < k - length; i++) {
                parts[index + i] = null;
                System.out.println(parts[index + i]);
            }
        }

        if (num != 0) {
            int numAdd = length%k;
            ListNode curGroup = head;
            System.out.println(numAdd + " " + num);
            curGroup = partsSplit(curGroup, numAdd, num + 1, parts, 0);
            partsSplit(curGroup, k - numAdd, num, parts, numAdd);
        }
        return parts;
    }

    //封装一个函数
    public static ListNode partsSplit(ListNode curGroup, int numAdd, int num, ListNode[] parts, int index) {
        ListNode temp = curGroup;
        for (int i = 0; i < numAdd; i++) {
            parts[i + index] = temp;
            for (int j = 0; j < num; j++) {
                temp = temp.next;
                curGroup = curGroup.next;
            }
            temp.next = null;
            temp = curGroup;
            System.out.println(parts[0].next.next.val);
        }
        System.out.println(curGroup.val);
        return curGroup;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
