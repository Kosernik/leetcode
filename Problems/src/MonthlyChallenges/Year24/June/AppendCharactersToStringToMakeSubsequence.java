package MonthlyChallenges.Year24.June;

public class AppendCharactersToStringToMakeSubsequence {

    /**
     * LeetCode №2486. Append Characters to String to Make Subsequence.
     * <p>
     * Complexity - O(N), N = s.length.
     * Memory - O(1)
     *
     * @param s - a string.
     * @param t - a string.
     * @return - the minimum number of characters that need to be appended to the end of s so that t becomes a
     * subsequence of s.
     */
    public int appendCharacters(String s, String t) {
        int tIdx = 0;
        char tChar = t.charAt(tIdx);

        for (char ch : s.toCharArray()) {
            if (ch == tChar) {
                tIdx++;
                if (tIdx >= t.length()) return 0;
                tChar = t.charAt(tIdx);
            }
        }

        return t.length() - tIdx;
    }
}
