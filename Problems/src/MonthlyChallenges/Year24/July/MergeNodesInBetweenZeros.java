package MonthlyChallenges.Year24.July;

import Utils.ListNode;

public class MergeNodesInBetweenZeros {

    /**
     * LeetCode №2181. Merge Nodes in Between Zeros.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param head - a head of a linked list. The beginning and end of the linked list have Node.val == 0.
     * @return - the head of the merged linked list.
     */
    public ListNode mergeNodes(ListNode head) {
        ListNode merged = new ListNode(0);

        ListNode node = merged;
        head = head.next;
        int prevSum = 0;

        while (head != null) {
            if (head.val == 0) {
                node.next = new ListNode(prevSum);
                prevSum = 0;
                node = node.next;
            } else {
                prevSum += head.val;
            }
            head = head.next;
        }

        return merged.next;
    }
}
