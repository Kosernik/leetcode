package MonthlyChallenges.June21;

import Utils.ListNode;

public class ReverseLinkedListII {

    /**
     * LeetCode #92.
     *
     * Complexity - O(right)
     * memory - O(1)
     *
     * @param head - the head of a singly linked list.
     * @param left - start position (1-indexed)
     * @param right - end position (1-indexed)
     * @return - the head of a given linked list after reversing the nodes from position "left" to position "right".
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode beginning = head;
        for (int i = 1; i < (left-1); i++) {
            beginning = beginning.next;
        }

        ListNode start;
        if (left == 1) {
            start = head;
        } else {
            start = beginning.next;
        }
        ListNode lastNode = start;
        ListNode prev = null;

        ListNode next;
        for (int i = left; i <= right; i++) {
            next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }

        beginning.next = prev;
        lastNode.next = start;

        if (left == 1) {
            return prev;
        }
        return head;
    }
}
