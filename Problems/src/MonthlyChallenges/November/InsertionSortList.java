package MonthlyChallenges.November;

import Utils.ListNode;

public class InsertionSortList {

    /**
     * Sorts a linked list using Insertion Sort Algorithm.
     *
     * Complexity - O(N^2)
     * Memory - O(N)
     *
     * @param head - a head of linked list.
     * @return - sorted copy of a linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode sorted = new ListNode(-1);

        ListNode curr = sorted;
        ListNode node = head;

        while (node != null) {
            while (curr.next != null && curr.next.val < node.val) {
                curr = curr.next;
            }

            ListNode nextNode = new ListNode(node.val);
            nextNode.next = curr.next;
            curr.next = nextNode;

            curr = sorted;
            node = node.next;
        }

        return sorted.next;
    }
}
