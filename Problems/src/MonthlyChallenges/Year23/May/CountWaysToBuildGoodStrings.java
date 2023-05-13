package MonthlyChallenges.Year23.May;

import java.util.HashMap;
import java.util.Map;

public class CountWaysToBuildGoodStrings {
    private final int MODULO = 1_000_000_007;
    private String zeroStr = "";
    private int zero;
    private String oneStr = "";
    private int one;


    /**
     * LeetCode #2466. Count Ways To Build Good Strings.
     * <p>
     * Complexity - O(N)
     * Memory - O(high)
     *
     * @param low  - the minimum length of a good string.
     * @param high - the maximum length of a good string.
     * @param zero - the length of a substring of zeroes.
     * @param one  - the length of a substring of ones.
     * @return - the total number of ways to form a good string. Result is modulo 10exp9 + 7.
     */
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1;
        int result = 0;

        for (int i = 1; i <= high; i++) {
            if (i >= zero) {
                dp[i] = (dp[i - zero] + dp[i]) % MODULO;
            }
            if (i >= one) {
                dp[i] = (dp[i - one] + dp[i]) % MODULO;
            }
            if (i >= low) {
                result = (result + dp[i]) % MODULO;
            }
        }
        return result;
    }

    public int countGoodStringsTLE(int low, int high, int zero, int one) {
        zeroStr = getStr(zero, '0');
        this.zero = zero;
        oneStr = getStr(one, '1');
        this.one = one;

        return (int) helper("", low, high, new HashMap<>());
    }

    private long helper(String word, int low, int high, Map<String, Long> computed) {
        if (computed.containsKey(word)) {
            return computed.get(word);
        }
        if (word.length() > high) return 0;

        long curWordResult = 0L;

        long attachZeroesLength = word.length() + zero;
        if (low <= attachZeroesLength && attachZeroesLength <= high) {
            curWordResult += 1;
        }
        curWordResult += helper(word + zeroStr, low, high, computed);

        long attachOnesLength = word.length() + one;
        if (low <= attachOnesLength && attachOnesLength <= high) {
            curWordResult += 1;
        }
        curWordResult += helper(word + oneStr, low, high, computed);

        curWordResult = curWordResult % MODULO;
        computed.put(word, curWordResult);

        return curWordResult;
    }

    private String getStr(int length, char ch) {
        return String.valueOf(ch).repeat(Math.max(0, length));
    }
}
