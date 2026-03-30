package MonthlyChallenges.Year26.March;

public class CheckIfStringsCanBeMadeEqualWithOperationsII {

    /**
     * LeetCode №2840. Check if Strings Can be Made Equal With Operations II.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     * <p>
     * An operation:
     * * Choose any two indices i and j such that i < j and the difference j - i is even, then swap the two characters
     * at those indices in the string.
     *
     * @param s1 - a string of lowercase english letters.
     * @param s2 - a string of lowercase english letters. s1.length = s2.length.
     * @return - true if you can make the strings s1 and s2 equal after performing an operation any number of times on
     * any of the two strings, and false otherwise.
     */
    public boolean checkStrings(String s1, String s2) {
        int[] countEvens = new int[26];
        int[] countOdds = new int[26];

        countLetters(s1, countEvens, countOdds, 1);
        countLetters(s2, countEvens, countOdds, -1);

        for (int count : countEvens) {
            if (count != 0) return false;
        }
        for (int count : countOdds) {
            if (count != 0) return false;
        }
        return true;
    }

    private void countLetters(String word, int[] countEvens, int[] countOdds, int change) {
        boolean even = true;
        for (int i = 0; i < word.length(); i++, even = !even) {
            int letterIdx = word.charAt(i) - 'a';
            if (even) {
                countEvens[letterIdx] += change;
            } else {
                countOdds[word.charAt(i) - 'a'] += change;
            }
        }
    }
}
