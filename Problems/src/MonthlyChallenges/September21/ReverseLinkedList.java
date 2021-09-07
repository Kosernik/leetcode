package MonthlyChallenges.September21;

import Utils.ListNode;

public class ReverseLinkedList {
    /**
     * LeetCode #206. Reverse Linked List.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param head - the head of a singly linked list.
     * @return - the reversed list.
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode curNode = head;

        while (curNode != null) {
            ListNode next = curNode.next;

            curNode.next = prev;
            prev = curNode;
            curNode = next;
        }

        return prev;
    }
}
