package MonthlyChallenges.January21;

import Utils.ListNode;

public class MergeKSortedLists {
    /**
     * LeetCode #23.
     *
     * Merges and returns a sorted linked list of all values of given lists.
     *
     * Complexity - O(NlogN)
     * Memory O(N)
     *
     * @param lists - array of linked lists, each list is sorted in ascending order.
     * @return - merged linked list sorted in ascending order.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        int length = (int) Math.ceil(lists.length / 2.0);
        ListNode[] half = new ListNode[length];

        for (int i = 0, idx = 0; idx < length; idx++, i += 2) {
            half[idx] = mergeTwoLists(lists[i], (i+1) < lists.length ? lists[i+1] : null);
        }

        return mergeKLists(half);
    }

    private ListNode mergeTwoLists(ListNode first, ListNode second) {
        if (first == null || second == null) {
            return first != null ? first : second;
        }

        ListNode f = first;
        ListNode s = second;
        ListNode res = new ListNode();
        ListNode curr = res;

        while (!(f == null && s == null)) {
            if (f == null) {
                curr.next = s;
                s = s.next;
            }
            else if (s == null) {
                curr.next = f;
                f = f.next;
            }
            else if (f.val > s.val) {
                curr.next = s;
                s = s.next;
            } else {
                curr.next = f;
                f = f.next;
            }

            curr = curr.next;
        }

        return res.next;
    }
}
