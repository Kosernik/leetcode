package MonthlyChallenges.Year26.May;

public class CountNumberOfSpecialCharactersII {

    /**
     * LeetCode №3121. Count the Number of Special Characters II.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     * <p>
     * A letter c is called special if it appears both in lowercase and uppercase in word, and every lowercase
     * occurrence of c appears before the first uppercase occurrence of c.
     *
     * @param word - a string of english letters.
     * @return - the number of special letters in word.
     */
    public int numberOfSpecialChars(String word) {
        boolean[] lowers = new boolean[26];
        boolean[] uppers = new boolean[26];
        boolean[] invalid = new boolean[26];

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            if ('a' <= letter && letter <= 'z') {
                int idx = letter - 'a';

                if (uppers[idx]) {
                    invalid[idx] = true;
                }

                lowers[idx] = true;
            } else {
                uppers[letter - 'A'] = true;
            }
        }

        int result = 0;

        for (int i = 0; i < 26; i++) {
            if (lowers[i] && uppers[i] && !invalid[i]) result++;
        }

        return result;
    }
}
