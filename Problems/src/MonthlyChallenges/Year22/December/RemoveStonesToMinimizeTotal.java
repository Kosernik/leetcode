package MonthlyChallenges.Year22.December;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class RemoveStonesToMinimizeTotal {
    public static void main(String[] args) {
        RemoveStonesToMinimizeTotal solution = new RemoveStonesToMinimizeTotal();

        int[] test0 = {5, 4, 9};
        int k0 = 2;
        System.out.println(solution.minStoneSum(test0, k0));
    }

    /**
     * LeetCode #1962. Remove Stones to Minimize the Total.
     * <p>
     * Complexity - O((N+K)*logN), N = piles.length, K = k.
     * Memory - O(N)
     *
     * @param piles - an array of positive integers representing the number of stones in each pile.
     * @param k     - total number of operations.
     * @return - the minimum possible total number of stones remaining after applying the k operations.
     */
    public int minStoneSum(int[] piles, int k) {
        int numberOfStones = 0;
        NavigableMap<Integer, Integer> pilesCount = new TreeMap<>();

        for (int pile : piles) {
            pilesCount.put(pile, pilesCount.getOrDefault(pile, 0) + 1);
            numberOfStones += pile;
        }

        int operationsLeft = k;

        while (true) {
            Map.Entry<Integer, Integer> pile = pilesCount.pollLastEntry();
            int numberOfPiles = pile.getValue();

            int stonesToBeRemoved = Math.floorDiv(pile.getKey(), 2);
            int remains = pile.getKey() - stonesToBeRemoved;

            pilesCount.put(remains, pilesCount.getOrDefault(remains, 0) + numberOfPiles);
            if ((operationsLeft - numberOfPiles) <= 0) {
                numberOfStones -= (stonesToBeRemoved * operationsLeft);
                return numberOfStones;
            } else {
                numberOfStones -= (stonesToBeRemoved * pile.getValue());
                operationsLeft -= numberOfPiles;
            }
        }
    }
}
