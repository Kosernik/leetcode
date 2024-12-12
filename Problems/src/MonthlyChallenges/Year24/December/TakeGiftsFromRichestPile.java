package MonthlyChallenges.Year24.December;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TakeGiftsFromRichestPile {

    /**
     * LeetCode №2558. Take Gifts From the Richest Pile.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param gifts - an array of integers.
     * @param k     - the number of square root operations.
     * @return - the sum of all elements of nums after k-operations.
     */
    public long pickGifts(int[] gifts, int k) {
        long result = 0L;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int gift : gifts) {
            pq.offer(gift);
        }
        for (int i = 0; i < k; i++) {
            int gift = pq.poll();
            gift = (int) Math.floor(Math.sqrt(gift));
            pq.offer(gift);
        }

        while (!pq.isEmpty()) {
            result += pq.poll();
        }

        return result;
    }
}
