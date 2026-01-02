package MonthlyChallenges.Year21.December21;

import Utils.ListNode;

public class OddEvenLinkedList {

    /**
     * LeetCode #328. Odd Even Linked List.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param head - a heat of a singly linked list.
     * @return - the reordered list after grouping all the nodes with odd indices together followed by the nodes with
     * even indices.
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode evensHead = new ListNode(-1);
        ListNode curEven = evensHead;
        ListNode node = head;

        while (node.next != null) {
            curEven.next = node.next;
            curEven = curEven.next;

            node.next = curEven.next;
            if (node.next != null) node = node.next;
            else break;
        }

        node.next = evensHead.next;
        curEven.next = null;
        return head;
    }
}
