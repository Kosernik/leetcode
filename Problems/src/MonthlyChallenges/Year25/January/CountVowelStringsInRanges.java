package MonthlyChallenges.Year25.January;

import java.util.HashSet;
import java.util.Set;

public class CountVowelStringsInRanges {

    /**
     * LeetCode №2559. Count Vowel Strings in Ranges.
     * <p>
     * Complexity - O(N + M), N = words.length, M = queries.length.
     * Memory - O(N)
     *
     * @param words   - a string of lowercase words.
     * @param queries - an array if intervals(inclusive)
     * @return - an array of answers for each query.
     */
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int[] prefixCounts = new int[words.length + 1];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            prefixCounts[i + 1] = prefixCounts[i];
            if (vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1))) {
                prefixCounts[i + 1]++;
            }
        }

        int[] result = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int[] query = queries[q];

            int count = prefixCounts[query[1] + 1] - prefixCounts[query[0]];
            result[q] = count;
        }

        return result;
    }
}
