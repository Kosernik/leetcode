package MonthlyChallenges.Year23.April;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumValueOfKCoinsFromPiles {
    private final Map<String, Integer> computed = new HashMap<>();
    private List<List<Integer>> piles;


    /**
     * LeetCode #2218. Maximum Value of K Coins From Piles.
     * <p>
     * Complexity - O(n*m), n = piles.size(), m = sum(piles[i].size())
     * Memory - O(n*k)
     *
     * @param piles - a list of lists of positive integers.
     * @param k     - the maximum number of coins.
     * @return - the maximum total value after picking k-coins from stacks.
     */
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        this.piles = piles;
        Integer[][] dp = new Integer[piles.size() + 1][k + 1];

        return topDownDP(0, k, dp);
    }

    private int topDownDP(int pileIDX, int coinsLeft, Integer[][] dp) {
        if (dp[pileIDX][coinsLeft] != null) {
            return dp[pileIDX][coinsLeft];
        } else if (coinsLeft == 0 || pileIDX == piles.size()) {
            return 0;
        }

        int result = topDownDP(pileIDX + 1, coinsLeft, dp);
        int curSum = 0;
        List<Integer> pile = piles.get(pileIDX);

        for (int i = 0; i < Math.min(pile.size(), coinsLeft); i++) {
            curSum += pile.get(i);
            int curRes = topDownDP(pileIDX + 1, coinsLeft - i - 1, dp);
            result = Math.max(result, curSum + curRes);
        }

        dp[pileIDX][coinsLeft] = result;
        return result;
    }


    public int maxValueOfCoinsTLE(List<List<Integer>> piles, int k) {
        this.piles = piles;

        List<Integer> topIndices = new ArrayList<>();
        for (int i = 0; i < piles.size(); i++) {
            topIndices.add(0);
        }

        return computeMaxValueOfCoins(k, topIndices);
    }

    private int computeMaxValueOfCoins(int coinsRemaining, List<Integer> topIndices) {
        String indices = indicesToString(topIndices);
        if (computed.containsKey(indices)) {
            return computed.get(indices);
        } else if (coinsRemaining == 0) {
            return 0;
        } else if (coinsRemaining == 1) {
            int result = 0;
            for (int i = 0; i < piles.size(); i++) {
                List<Integer> pile = piles.get(i);
                int idx = topIndices.get(i);
                if (idx < pile.size()) {
                    result = Math.max(result, pile.get(idx));
                }
            }
            computed.put(indices, result);
            return result;
        }

        int result = 0;
        for (int i = 0; i < piles.size(); i++) {
            List<Integer> pile = piles.get(i);
            int idx = topIndices.get(i);

            if (idx < pile.size()) {
                int curCoin = pile.get(idx);
                topIndices.set(i, idx + 1);
                int curResult = computeMaxValueOfCoins(coinsRemaining - 1, topIndices);
                topIndices.set(i, idx);
                result = Math.max(result, curCoin + curResult);
            }
        }

        computed.put(indices, result);
        return result;
    }

    private String indicesToString(List<Integer> topIndices) {
        StringBuilder builder = new StringBuilder();
        for (Integer idx : topIndices) {
            builder.append(idx);
            builder.append("*");
        }
        return builder.toString();
    }
}
