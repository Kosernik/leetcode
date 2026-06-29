package MonthlyChallenges.Year26.June;

public class NumberOfStringsThatAppearAsSubstringsInWord {

    /**
     * LeetCode №1967. Number of Strings That Appear as Substrings in Word.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(1)
     *
     * @param patterns - an array of strings.
     * @param word     - a string.
     * @return - the number of strings in patterns that exist as a substring in word.
     */
    public int numOfStrings(String[] patterns, String word) {
        int result = 0;

        for (String candidate : patterns) {
            if (isValid(candidate, word)) result++;
        }

        return result;
    }

    private boolean isValid(String candidate, String word) {
        for (int i = 0; i <= (word.length() - candidate.length()); i++) {
            boolean found = true;
            for (int j = 0; j < candidate.length(); j++) {
                if (candidate.charAt(j) != word.charAt(i + j)) {
                    found = false;
                    break;
                }
            }

            if (found) return true;
        }

        return false;
    }
}
