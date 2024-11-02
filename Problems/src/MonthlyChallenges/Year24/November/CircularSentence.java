package MonthlyChallenges.Year24.November;

public class CircularSentence {

    /**
     * LeetCode №2490. Circular Sentence.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     * <p>
     * A sentence is circular if:
     * - The last character of a word is equal to the first character of the next word.
     * - The last character of the last word is equal to the first character of the first word.
     *
     * @param sentence - a list of words that are separated by a single space with no leading or trailing spaces.
     *                 Represented as a string.
     * @return - true - if sentence is circular, false - otherwise.
     */
    public boolean isCircularSentence(String sentence) {
        char[] letters = sentence.toCharArray();
        if (letters[0] != letters[letters.length - 1]) return false;

        for (int i = 1; i < letters.length - 1; i++) {
            if (letters[i] == ' ') {
                if (letters[i - 1] != letters[i + 1]) return false;
            }
        }

        return true;
    }
}
