package MonthlyChallenges.Year25.January;

public class CountingWordsWithGivenPrefix {

    /**
     * LeetCode №2185. Counting Words With a Given Prefix.
     * <p>
     * Complexity - O(N*M), N = words.length, M = pref.length
     * Memory - O(1)
     *
     * @param words - a string of words.
     * @param pref  - a target prefix.
     * @return - the number of words in the given array that starts with pref.
     */
    public int prefixCount(String[] words, String pref) {
        int result = 0;

        for (String word : words) {
            if (word.startsWith(pref)) result++;
        }

        return result;
    }
}
