package MonthlyChallenges.Year22.February;

import Utils.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList {

    /**
     * 148. Sort List.
     *
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param head - the head of a linked list.
     * @return - the head of the given list after sorting.
     */
    public ListNode sortList(ListNode head) {
        if (head == null) return head;

        List<Integer> array = convertToArray(head);
        Collections.sort(array);
        ListNode sorted = convertToList(array);

        return sorted;
    }

    private static List<Integer> convertToArray(ListNode head) {
        List<Integer> array = new ArrayList<>();

        while (head != null) {
            array.add(head.val);
            head = head.next;
        }

        return array;
    }

    private static ListNode convertToList(List<Integer> array) {
        ListNode head = new ListNode(-1);
        ListNode node = head;

        for (Integer value : array) {
            node.next = new ListNode(value);
            node = node.next;
        }

        return head.next;
    }
}
