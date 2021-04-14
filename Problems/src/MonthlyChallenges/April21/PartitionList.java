package MonthlyChallenges.April21;

import Utils.ListNode;


public class PartitionList {
    /**
     * LeetCode #86.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param head - the head of a linked list.
     * @param x - target value.
     * @return - new linked list.
     */
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);
        ListNode result = left;
        ListNode rightBeginning = right;

        ListNode node = head;

        while (node != null) {
            if (node.val < x) {
                left.next = new ListNode(node.val);
                left = left.next;
            } else {
                right.next = new ListNode(node.val);
                right = right.next;
            }
            node = node.next;
        }

        left.next = rightBeginning.next;

        return result.next;
    }
}
