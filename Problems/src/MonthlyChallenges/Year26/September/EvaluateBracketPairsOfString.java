package MonthlyChallenges.Year26.September;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateBracketPairsOfString {

    /**
     * LeetCode №1807. Evaluate the Bracket Pairs of a String.
     * <p>
     * Complexity - O(N + M), N = s.length(), M = knowledge.size()
     * Memory - O(N + M)
     * <p>
     * When you evaluate a bracket pair that contains some key key-i, you will:
     * * Replace key-i and the bracket pair with the key's corresponding value-i.
     * * If you do not know the value of the key, you will replace key-i and the bracket pair with a question mark "?".
     *
     * @param s         - a string of english letters, '(' and ')'.
     * @param knowledge - a 2d list of strings where knowledge[i] = [key, value]
     * @return - the resulting string after evaluating all the bracket pairs.
     */
    public String evaluate(String s, List<List<String>> knowledge) {
        String unknown = "?";

        Map<String, String> knownKeys = new HashMap<>();
        for (List<String> known : knowledge) {
            knownKeys.put(known.get(0), known.get(1));
        }

        StringBuilder result = new StringBuilder();

        char[] letters = s.toCharArray();
        int idx = 0;

        while (idx < letters.length) {
            if (letters[idx] == '(') {
                int endIdx = idx;

                while (letters[endIdx] != ')') endIdx++;

                String key = new String(letters, idx + 1, endIdx - idx - 1);

                result.append(knownKeys.getOrDefault(key, unknown));

                idx = endIdx;
            } else {
                result.append(letters[idx]);
            }

            idx++;
        }

        return result.toString();
    }
}
