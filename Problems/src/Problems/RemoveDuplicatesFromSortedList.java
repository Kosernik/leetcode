package Problems;

import Utils.ListNode;

public class RemoveDuplicatesFromSortedList {

    /**
     * LeetCode #83. Remove Duplicates from Sorted List.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param head - the head of a sorted linked list.
     * @return - the head of new linked list after removing all duplicates from original list.
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode result = new ListNode(head.val);

        ListNode curOrigList = head;
        ListNode curResList = result;

        while (curOrigList != null) {
            if (curOrigList.val != curResList.val) {
                curResList.next = new ListNode(curOrigList.val);
                curResList = curResList.next;
            }

            curOrigList = curOrigList.next;
        }

        return result;
    }
}
