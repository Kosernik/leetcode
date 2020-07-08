package ExploreCards.LinkedList;

import Utils.ListNode;

public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head.next;
        ListNode fast;
        if (slow.next == null) return null;
        else fast = slow.next;

        while (slow != fast) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            slow = slow.next;
        }

        fast = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
