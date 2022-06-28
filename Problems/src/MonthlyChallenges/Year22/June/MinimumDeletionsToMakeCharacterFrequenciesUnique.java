package MonthlyChallenges.Year22.June;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {

    /**
     * LeetCode #1647. Minimum Deletions to Make Character Frequencies Unique.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string of lowercase letters.
     * @return - the minimum number of deletions to make "s" a good string.
     */
    public int minDeletions(String s) {
        int[] count = new int[26];

        for (char letter : s.toCharArray()) {
            count[letter - 'a']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int j : count) {
            if (j > 0) {
                pq.offer(j);
            }
        }

        int numberOfDeletions = 0;

        while (true) {
            Integer curCount = pq.poll();
            if (pq.isEmpty()) break;
            if (curCount > pq.peek()) {
                continue;
            }
            numberOfDeletions++;
            if (curCount > 1) pq.offer(curCount-1);
        }

        return numberOfDeletions;
    }
}
