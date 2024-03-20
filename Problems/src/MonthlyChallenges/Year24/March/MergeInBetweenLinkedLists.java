package MonthlyChallenges.Year24.March;

import Utils.ListNode;

public class MergeInBetweenLinkedLists {

    /**
     * LeetCode №1669. Merge In Between Linked Lists.
     * <p>
     * Complexity - O(N + M), N = list1.length, M = list2.length.
     * Memory - O(1)
     *
     * @param list1 - a head of a linked list.
     * @param a     - the starting index.
     * @param b     - the ending index. 1 <= a <= b < list1.length - 1
     * @param list2 - a head of a linked list.
     * @return - the head of a merged linked list.
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = list1;
        for (int i = 1; i < a; i++) {
            start = start.next;
        }

        ListNode end = start.next;
        for (int i = a; i <= b; i++) {
            end = end.next;
        }

        start.next = list2;

        while (start.next != null) {
            start = start.next;
        }
        start.next = end;

        return list1;
    }
}
