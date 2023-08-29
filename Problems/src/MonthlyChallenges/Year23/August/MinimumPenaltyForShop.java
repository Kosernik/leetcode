package MonthlyChallenges.Year23.August;

public class MinimumPenaltyForShop {
    public static void main(String[] args) {
        MinimumPenaltyForShop solution = new MinimumPenaltyForShop();

        String[] tests = {
                "YYNY",
                "NNNNN",
                "YYYY"
        };

        int[] results = {
                2,
                0,
                4
        };

        for (int i = 0; i < tests.length; i++) {
            int curRes = solution.bestClosingTime(tests[i]);
            if (curRes != results[i]) {
                System.out.println(tests[i] + " " + results[i] + " -*- " + curRes);
            }
        }
    }


    /**
     * LeetCode #2483. Minimum Penalty for a Shop.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param customers - the customer visit log of a shop represented by a 0-indexed string customers consisting only
     *                  of characters 'N' and 'Y':
     *                  For every hour when the shop is open and no customers come, the penalty increases by 1.
     *                  For every hour when the shop is closed and customers come, the penalty increases by 1.
     * @return - the earliest hour at which the shop must be closed to incur a minimum penalty.
     */
    public int bestClosingTime(String customers) {
        char[] letters = customers.toCharArray();
        int[] postFixSum = new int[letters.length + 1];

        for (int i = letters.length - 1; i >= 0; i--) {
            postFixSum[i] = postFixSum[i + 1] + (letters[i] == 'Y' ? 1 : 0);
        }

        int bestTime = 0;
        int minPenalty = Integer.MAX_VALUE;
        int countN = 0;

        for (int i = 0; i < letters.length; i++) {
            int curPenalty = countN + postFixSum[i];

            if (curPenalty < minPenalty) {
                bestTime = i;
                minPenalty = curPenalty;
            }

            if (letters[i] == 'N') {
                countN++;
            }
        }

        if (countN < minPenalty) {
            bestTime = customers.length();
        }

        return bestTime;
    }
}
