package MonthlyChallenges.Year24.March;

import Utils.ListNode;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumConsecutiveNodesFromLinkedList {

    /**
     * LeetCode №1171. Remove Zero Sum Consecutive Nodes from Linked List.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param head - a head of a singly-linked list.
     * @return - the head of the linked list after deleting all consecutive sequences of nodes that sum to 0.
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> sums = new HashMap<>();
        int curSum = 0;
        ListNode node = head;
        ListNode result = new ListNode(0, node);
        sums.put(0, result);

        while (node != null) {
            curSum += node.val;

            if (sums.containsKey(curSum)) {
                ListNode prev = sums.get(curSum);
                node = prev.next;

                int prevSum = curSum + node.val;
                while (prevSum != curSum) {
                    sums.remove(prevSum);
                    node = node.next;
                    prevSum += node.val;
                }

                prev.next = node.next;
            } else {
                sums.put(curSum, node);
            }
            node = node.next;
        }

        return result.next;
    }
}
