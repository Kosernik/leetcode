package MonthlyChallenges.Year24.May;

public class GetEqualSubstringsWithinBudget {

    /**
     * LeetCode №1208. Get Equal Substrings Within Budget.
     * <p>
     * Complexity - O(N + logN*N)
     * Memory - O(N)
     *
     * @param s       - a string of only lowercase English letters.
     * @param t       - a string of only lowercase English letters. s.length() = t.length()
     * @param maxCost - the maximum cost of changing letters.
     * @return - the maximum length of a substring of s that can be changed to be the same as the corresponding
     * substring of t with a cost less than or equal to maxCost.
     */
    public int equalSubstring(String s, String t, int maxCost) {
        int[] costs = getCosts(s, t);

        int left = 0, right = s.length(), middle;

        while (left < right) {
            middle = right - (right - left) / 2;

            if (isSubstringExist(middle, costs, maxCost)) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }

    private boolean isSubstringExist(int length, int[] costs, int maxCost) {
        int curCost = 0;

        for (int i = 0; i < length; i++) {
            curCost += costs[i];
        }

        if (curCost <= maxCost) return true;

        for (int i = length; i < costs.length; i++) {
            curCost = curCost - costs[i - length] + costs[i];

            if (curCost <= maxCost) return true;
        }

        return false;
    }

    private int[] getCosts(String s, String t) {
        int[] costs = new int[s.length()];

        for (int i = 0; i < costs.length; i++) {
            costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        return costs;
    }
}
