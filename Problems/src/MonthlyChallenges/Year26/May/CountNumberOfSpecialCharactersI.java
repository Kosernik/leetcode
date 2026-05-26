package MonthlyChallenges.Year26.May;

public class CountNumberOfSpecialCharactersI {

    /**
     * LeetCode №3120. Count the Number of Special Characters I.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param word - a string of english letters.
     * @return - the number of special letters in word.
     */
    public int numberOfSpecialChars(String word) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            if ('a' <= letter && letter <= 'z') {
                lower[letter - 'a'] = true;
            } else {
                upper[letter - 'A'] = true;
            }
        }

        int result = 0;

        for (int i = 0; i < lower.length; i++) {
            if (lower[i] && upper[i]) result++;
        }

        return result;
    }
}
