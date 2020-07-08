package ExploreCards.LinkedList;

import Utils.ListNode;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) return head;

        ListNode currNode = head.next;
        ListNode prevNode = head;

        while (currNode != null) {
            if (currNode.val == val) {
                prevNode.next = currNode.next;
            } else {
                prevNode = currNode;
            }
            currNode = currNode.next;
        }

        return head;
    }
}
