package MonthlyChallenges.December;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
    private Map<Integer, Integer> computed = new HashMap<>();

    /**
     * LeetCode #91.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string of digits.
     * @return - total number of ways to decode a string.
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        else if (s.length() == 1) return 1;

        return helper(s.toCharArray(), 0);
    }

    private int helper(char[] letters, int idx) {
        if (computed.containsKey(idx)) return computed.get(idx);
        if (idx > letters.length) return 0;
        else if (idx == letters.length) return 1;
        else if (letters[idx] == '0') return 0;

        int res = helper(letters, idx+1);

        if (((idx+1) < letters.length) && (letters[idx] == '1' || letters[idx] == '2' && letters[idx+1] < '7')) {
            res += helper(letters, idx+2);
        }

        computed.put(idx, res);
        return res;
    }
}
