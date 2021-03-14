package MonthlyChallenges.March21;

import Utils.ListNode;

public class SwappingNodesInALinkedList {
    /**
     * LeetCode #1721.
     *
     * Swaps values of k-th node from the beginning and k-th node from the end in a linked list and returns the head to
     * this list.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param head - a head of a linked list.
     * @param k - positive integer, k <= head.size().
     * @return - the head of a linked list with swapped values.
     */
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k-1; i++) fast = fast.next;
        ListNode kNode = fast;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        int temp = kNode.val;
        kNode.val = slow.val;
        slow.val = temp;

        return head;
    }
}
