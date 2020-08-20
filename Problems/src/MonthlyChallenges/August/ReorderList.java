package MonthlyChallenges.August;

import Utils.ListNode;

import java.util.Stack;

public class ReorderList {

    /**
     * Reorders a singly linked list L: L0→L1→…→Ln-1→Ln, to: L0→Ln→L1→Ln-1→L2→Ln-2→…
     * Modifies the list.
     *
     * @param head - reference to the head of the list
     *
     * Complexity: O(N)
     * Memory: O(N)
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;;

        // Creating a stack and adding all nodes to traverse the list backwards.
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;

        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        node = head;
        ListNode nextNode;
        ListNode stackNode;

        while (!stack.isEmpty()) {
            stackNode = stack.pop();
            // Odd number of nodes, finishing reordering
            if (node == null || node == stackNode) break;
            nextNode = node.next;

            node.next = stackNode;
            // Even number of nodes, finishing reordering
            if (node.next == nextNode) {
                node.next.next = null;
                return;
            }
            node.next.next = nextNode;

            node = nextNode;
        }
        node.next = null;
    }
}
