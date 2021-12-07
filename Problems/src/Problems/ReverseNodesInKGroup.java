package Problems;

import Utils.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseNodesInKGroup {

    /**
     * LeetCode #25. Reverse Nodes in k-Group.
     *
     * Complexity - O(N)
     * Memory - O(k)
     *
     * @param head - a list of a singly linked list.
     * @param k - the size of a group.
     * @return - the head of a list after reversing nodes in each window of k-size.
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;

        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode node = head;
        int idx = 0;

        while (idx < k && node != null) {
            stack.push(node);

            idx++;
            node = node.next;
        }

        if (idx < k) return head;

        ListNode result = stack.pop();
        ListNode nextNode = result.next;
        node = result;
        while (!stack.isEmpty()) {
            node.next = stack.pop();
            node = node.next;
        }

        node.next = reverseKGroup(nextNode, k);
        return result;
    }
}
