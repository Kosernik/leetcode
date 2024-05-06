package MonthlyChallenges.Year24.May;

import Utils.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveNodesFromLinkedList {

    /**
     * LeetCode №2487. Remove Nodes From Linked List.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param head - a head of a singly-linked list.
     * @return - the head of the list after removing every node which has a node with a greater value anywhere to the
     * right side of it.
     */
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode node = head;

        while (node != null) {
            while (!deque.isEmpty() && node.val > deque.getLast().val) {
                deque.removeLast();
            }
            deque.offerLast(node);
            node = node.next;
        }

        ListNode result = deque.removeFirst();
        node = result;
        while (!deque.isEmpty()) {
            node.next = deque.removeFirst();
            node = node.next;
        }

        return result;
    }
}
