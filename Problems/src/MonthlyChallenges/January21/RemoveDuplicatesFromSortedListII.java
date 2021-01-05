package MonthlyChallenges.January21;

import Utils.ListNode;

public class RemoveDuplicatesFromSortedListII {

    /**
     * LeetCode #82.
     * Returns a sorted linked list, consists only of distinct numbers from the original list.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param head - a reference to a linked list. Must be sorted.
     * @return - a sorted linked list with distinct numbers of original list.
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode result = new ListNode(-1);

        ListNode original = head;
        ListNode node = result;

        while (original != null) {
            if (original.next == null || original.val != original.next.val) {
                node.next = new ListNode(original.val);
                node = node.next;
            } else {
                while (original.next != null && original.val == original.next.val) {
                    original = original.next;
                }
            }
            original = original.next;
        }

        return result.next;
    }
}
