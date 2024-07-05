package MonthlyChallenges.Year24.July;

import Utils.ListNode;

public class FindMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {

    /**
     * LeetCode №2058. Find the Minimum and Maximum Number of Nodes Between Critical Points.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param head - a head of a singly-linked list.
     * @return - an array of length 2 containing [minDistance, maxDistance] where minDistance is the minimum distance
     * between any two distinct critical points and maxDistance is the maximum distance between any two distinct
     * critical points. If there are fewer than two critical points, return [-1, -1].
     */
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int firstIdx = -1;
        int lastIdx = -1;
        int minDistance = Integer.MAX_VALUE;

        int prevVal = head.val;
        head = head.next;
        int curVal = head.val;

        for (int i = 0; head.next != null; i++, head = head.next) {
            int nextVal = head.next.val;
            if ((prevVal > curVal && curVal < nextVal) ||
                    (prevVal < curVal && curVal > nextVal)) {
                if (firstIdx == -1) {
                    firstIdx = i;
                } else {
                    minDistance = Math.min(minDistance, i - lastIdx);
                }
                lastIdx = i;
            }

            prevVal = curVal;
            curVal = nextVal;
        }

        if (firstIdx == lastIdx) {
            return new int[]{-1, -1};
        }
        return new int[]{minDistance, lastIdx - firstIdx};
    }
}
