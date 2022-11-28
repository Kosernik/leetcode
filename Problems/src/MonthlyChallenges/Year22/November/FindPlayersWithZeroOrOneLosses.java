package MonthlyChallenges.Year22.November;

import java.util.*;

public class FindPlayersWithZeroOrOneLosses {

    /**
     * LeetCode #2225. Find Players With Zero or One Losses.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param matches - an array of results of matches. matches[i][0] - a winner, matches[i][1] - a looser.
     * @return - a list of two lists where result[0] - is a list of players with 0 losses and result[1] - is a list of
     * players with 1 loss. The values in both lists are sorted in increasing order.
     */
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> losses = new HashMap<>();
        for (int[] match : matches) {
            if (!losses.containsKey(match[0])) losses.put(match[0], 0);   // Winner

            losses.put(match[1], losses.getOrDefault(match[1], 0) + 1); // looser
        }

        List<Integer> zeroLosses = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : losses.entrySet()) {
            if (entry.getValue() == 0) {
                zeroLosses.add(entry.getKey());
            } else if (entry.getValue() == 1) {
                oneLoss.add(entry.getKey());
            }
        }

        Collections.sort(zeroLosses);
        Collections.sort(oneLoss);

        List<List<Integer>> result = new ArrayList<>();
        result.add(zeroLosses);
        result.add(oneLoss);

        return result;
    }
}
