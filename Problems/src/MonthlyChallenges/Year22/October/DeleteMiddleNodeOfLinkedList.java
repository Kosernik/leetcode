package MonthlyChallenges.Year22.October;

import Utils.ListNode;

public class DeleteMiddleNodeOfLinkedList {

    /**
     * LeetCode #2095. Delete the Middle Node of a Linked List.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param head - the head of a singly-linked list.
     * @return - the list after deleting the middle node.
     */
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode fastPointer = head.next;
        ListNode slowPointer = head;

        while (true) {
            fastPointer = fastPointer.next;
            if (fastPointer == null || fastPointer.next == null) break;
            else fastPointer = fastPointer.next;

            slowPointer = slowPointer.next;
        }

        slowPointer.next = slowPointer.next.next;

        return head;
    }
}
