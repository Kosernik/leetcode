package MonthlyChallenges.Year23.May;

import Utils.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumTwinSumOfLinkedList {

    /**
     * LeetCode #2130. Maximum Twin Sum of a Linked List.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param head - a linked list of positive integers. The length of a list is even.
     * @return - the maximum sum of values of twin nodes.
     */
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        Deque<Integer> stack = new ArrayDeque<>();

        while (fast != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        int maxPairSum = 0;

        while (slow != null) {
            int curSum = stack.pop() + slow.val;
            maxPairSum = Math.max(maxPairSum, curSum);

            head = head.next;
            slow = slow.next;
        }

        return maxPairSum;
    }
}
