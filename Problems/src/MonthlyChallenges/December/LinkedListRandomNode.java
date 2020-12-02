package MonthlyChallenges.December;

import Utils.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class LinkedListRandomNode {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {

        private Map<Integer, ListNode> indexes;
        private int size;

        // LeetCode # 382.
        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            if (head == null) {
                size = 0;
            } else {
                indexes = new HashMap<>();
                size = 0;

                int idx = 0;
                ListNode node = head;

                while (node != null) {
                    if (idx % 10 == 0) {
                        indexes.put(idx, node);
                    }
                    idx++;
                    size++;
                    node = node.next;
                }
            }
        }

        /** Returns a random node's value. */
        public int getRandom() {
            if (size == 0) {
                return 0;
            } else {
                int random = ThreadLocalRandom.current().nextInt(size);
                int idx = random - (random % 10);
                ListNode node = indexes.get(idx);

                for (int i = 0; i < (random% 10); i++) {
                    node = node.next;
                }
                return node.val;
            }
        }
    }
}
