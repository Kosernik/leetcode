package MonthlyChallenges.Year24.September;

public class CountNumberOfConsistentStrings {

    /**
     * LeetCode №1684. Count the Number of Consistent Strings.
     * <p>
     * Complexity - O(N + M*P), N = allowed.length, M = words.length, P = words[i].length
     * Memory - O(1)
     *
     * @param allowed - a string of lowercase english letters.
     * @param words   - an array of strings. Each string contain only lowercase english letters.
     * @return - the number of consistent strings in the array words. A string is consistent if all characters in the
     * string appear in the string allowed.
     */
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] letters = new boolean[26];
        for (char ch : allowed.toCharArray()) {
            letters[ch - 'a'] = true;
        }

        int consistentStrings = 0;

        for (String word : words) {
            int valid = 1;

            for (char ch : word.toCharArray()) {
                if (!letters[ch - 'a']) {
                    valid = 0;
                    break;
                }
            }

            consistentStrings += valid;
        }

        return consistentStrings;
    }
}
