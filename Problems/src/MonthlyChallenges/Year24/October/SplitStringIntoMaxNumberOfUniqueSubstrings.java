package MonthlyChallenges.Year24.October;

import java.util.HashSet;
import java.util.Set;

public class SplitStringIntoMaxNumberOfUniqueSubstrings {
    private int maxSubstrings = 0;


    /**
     * LeetCode №1593. Split a String Into the Max Number of Unique Substrings.
     * <p>
     * Complexity - O(N* 2^N)
     * Memory - O(N)
     *
     * @param s - a string.
     * @return - the maximum number of unique substrings that the given string can be split into.
     */
    public int maxUniqueSplit(String s) {
        backTrack(new StringBuilder(), 0, s.toCharArray(), new HashSet<>());
        return maxSubstrings;
    }

    private void backTrack(StringBuilder seq, int charIdx, char[] word, Set<String> unique) {
        if (charIdx >= word.length) {
            maxSubstrings = Math.max(maxSubstrings, unique.size());
            return;
        }

        seq.append(word[charIdx]);
        if (!unique.contains(seq.toString())) {
            unique.add(seq.toString());
            backTrack(new StringBuilder(), charIdx + 1, word, unique);
            unique.remove(seq.toString());
        }

        backTrack(seq, charIdx + 1, word, unique);
    }
}
