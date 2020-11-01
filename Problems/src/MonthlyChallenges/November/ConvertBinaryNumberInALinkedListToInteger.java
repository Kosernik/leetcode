package MonthlyChallenges.November;

import Utils.ListNode;

public class ConvertBinaryNumberInALinkedListToInteger {

    /**
     * Converts a binary number, represented as a singly-linked list with values of each node of '0' or '1', to an
     * integer.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param head - the head of a linked list.
     * @return - integer value of a binary number.
     */
    public int getDecimalValue(ListNode head) {
        int number = 0;
        if (head == null) return number;

        ListNode node = head;

        while (node != null) {
            number = number << 1;
            if (node.val == 1) {
                number = number | 1;
            }
            node = node.next;
        }
        return number;
    }
}
