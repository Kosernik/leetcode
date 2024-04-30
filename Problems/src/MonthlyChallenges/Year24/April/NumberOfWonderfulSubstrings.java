package MonthlyChallenges.Year24.April;

import java.util.HashMap;
import java.util.Map;

public class NumberOfWonderfulSubstrings {
    public static void main(String[] args) {
        NumberOfWonderfulSubstrings solution = new NumberOfWonderfulSubstrings();

        String[] tests = {
                "aba",
                "aabb",
                "he"
        };
        long[] results = {
                4,
                9,
                2
        };

        for (int i = 0; i < tests.length; i++) {
            long res = solution.wonderfulSubstrings(tests[i]);
            System.out.println(res + " -- " + results[i]);
        }
    }

    /**
     * LeetCode №1915. Number of Wonderful Substrings.
     *
     * @param word - a string of letters 'a' through 'j'.
     * @return - the total number of wonderful non-empty substrings.
     */
    public long wonderfulSubstrings(String word) {
        long result = 0L;
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);

        int mask = 0;
        char[] letters = word.toCharArray();
        for (char letter : letters) {
            int curCharIdx = letter - 'a';

            mask ^= (1 << curCharIdx);

            result += counts.getOrDefault(mask, 0);

            counts.put(mask, counts.getOrDefault(mask, 0) + 1);

            for (int i = 0; i < 10; i++) {
                result += counts.getOrDefault(mask ^ (1 << i), 0);
            }
        }

        return result;
    }

    public long wonderfulSubstringsTLE(String word) {
        if (word.length() == 1) return 1L;
        long result = 0L;

        int[] oddEvenStatus = new int[word.length() + 1];
        char[] letters = word.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            int curCharIdx = letters[i] - 'a';
            int mask = 1 << curCharIdx;

            for (int j = 0; j <= i; j++) {
                int prev = oddEvenStatus[j] ^ mask;

                if (Integer.bitCount(prev) <= 1) {
                    result++;
                }
                oddEvenStatus[j] = prev;
            }
        }

        return result;
    }
}
