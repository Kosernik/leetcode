package MonthlyChallenges.Year24.September;

import Utils.ListNode;

public class InsertGreatestCommonDivisorsInLinkedList {

    /**
     * LeetCode №2807. Insert Greatest Common Divisors in Linked List.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param head - a head of a linked list.
     * @return - the linked list after inserting between each pair of nodes a new node with a value equal to the
     * greatest common divisor of them.
     */
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode node = head;

        while (node.next != null) {
            ListNode nextNode = node.next;

            int nodesGCD = gcd(node.val, nextNode.val);

            node.next = new ListNode(nodesGCD);
            node.next.next = nextNode;

            node = nextNode;
        }

        return head;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
