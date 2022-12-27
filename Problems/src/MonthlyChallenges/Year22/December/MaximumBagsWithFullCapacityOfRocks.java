package MonthlyChallenges.Year22.December;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumBagsWithFullCapacityOfRocks {

    /**
     * LeetCode #2279. Maximum Bags With Full Capacity of Rocks.
     * <p>
     * Complexity - O(NlogN), N = capacity.length = rocks.length.
     * Memory - O(N)
     *
     * @param capacity        - an array of positive integers representing capacity of each bag.
     * @param rocks           - an array of non-negative integers representing the amount of stones in each bag.
     * @param additionalRocks - the number of additional rocks you can place in any of the bags.
     * @return - the maximum number of bags that could have full capacity after placing the additional rocks in some bags.
     */
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int result = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        int queueRequiresStones = 0;
        for (int i = 0; i < capacity.length; i++) {
            int stonesNeeded = capacity[i] - rocks[i];
            if (stonesNeeded <= 0) {
                result++;
                continue;
            }

            priorityQueue.offer(stonesNeeded);
            queueRequiresStones += stonesNeeded;

            while (!priorityQueue.isEmpty() && queueRequiresStones > additionalRocks) {
                int tooMuchStonesNeeded = priorityQueue.poll();
                queueRequiresStones -= tooMuchStonesNeeded;
            }

        }

        result += priorityQueue.size();
        return result;
    }
}
