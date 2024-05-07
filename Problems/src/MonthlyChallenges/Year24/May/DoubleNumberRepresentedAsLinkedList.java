package MonthlyChallenges.Year24.May;

import Utils.ListNode;

public class DoubleNumberRepresentedAsLinkedList {
    public static void main(String[] args) {
        DoubleNumberRepresentedAsLinkedList solution = new DoubleNumberRepresentedAsLinkedList();
    }


    /**
     * LeetCode №2816. Double a Number Represented as a Linked List
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param head - the head of a non-empty linked list representing a non-negative integer without leading zeroes.
     * @return - the head of the linked list after doubling it.
     */
    public ListNode doubleIt(ListNode head) {
        ListNode reversed = reverseList(head);
        doubleNumber(reversed);
        return reverseList(reversed);
    }

    private void doubleNumber(ListNode head) {
        int carry = 0;

        while (head.next != null) {
            int curNum = head.val * 2 + carry;
            head.val = curNum % 10;
            carry = curNum / 10;
            head = head.next;
        }

        int lastNum = head.val * 2 + carry;
        head.val = lastNum % 10;
        if (lastNum >= 10) {
            head.next = new ListNode(lastNum / 10);
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
