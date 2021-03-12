package MonthlyChallenges.March21;

import java.util.HashSet;
import java.util.Set;

public class CheckIfAStringContainsAllBinaryCodesOfSizeK {
    /**
     * LeetCode #1461.
     *
     * Complexity - O(N), N = s.length().
     * Memory - O(2^k)
     *
     * @param s - a non-empty string of '0' and '1'.
     * @param k - 1 <= k <= 20
     * @return - True if a string "s" contains all binary codes of length "k". False - otherwise.
     */
    public boolean hasAllCodes(String s, int k) {
        Set<String> codes = new HashSet<>();

        for (int i = 0, j = k; j <= s.length(); i++, j++) {
            codes.add(s.substring(i, j));
        }

        return codes.size() == (int) Math.pow(2, k);
    }
}
