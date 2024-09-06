package MonthlyChallenges.Year24.September;

import Utils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class DeleteNodesFromLinkedListPresentInArray {

    /**
     * LeetCode №3217. Delete Nodes From Linked List Present in Array.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of integers.
     * @param head - a head of a linked list.
     * @return - a head of a linked list after removing all nodes that have a value that exists in nums.
     */
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> values = new HashSet<>();
        for (int number : nums) values.add(number);

        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode prev = dummyHead;

        while (head != null) {
            if (values.contains(head.val)) {
                prev.next = head.next;
            } else {
                prev = head;
            }

            head = head.next;
        }

        return dummyHead.next;
    }
}
