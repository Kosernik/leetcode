package MonthlyChallenges.September21;

import Utils.ListNode;

public class SplitLinkedListInParts {
    /**
     * LeetCode #725. Split Linked List in Parts.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param head - the head of a singly linked list.
     * @param k - the number of parts.
     * @return - an array of linked lists.
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];

        if (head == null) {
            result[0] = head;
            return result;
        }
        int length = countNodes(head);
        if (k >= length) {
            sliceList(result, head);
            return result;
        }
        int splitLength = length / k;
        int extraNodes = length % k;

        ListNode node = head;
        for (int i = 0; i < k; i++) {
            result[i] = node;
            for (int j = 0; j < splitLength-1; j++) {
                node = node.next;
            }
            if (extraNodes > 0) {
                extraNodes--;
                node = node.next;
            }

            ListNode next = node.next;
            node.next = null;
            node = next;
        }
        return result;
    }

    private void sliceList(ListNode[] result, ListNode head) {
        int idx = 0;
        while (head != null) {
            result[idx++] = head;
            ListNode next = head.next;
            head.next = null;
            head = next;
        }
    }

    private int countNodes(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
