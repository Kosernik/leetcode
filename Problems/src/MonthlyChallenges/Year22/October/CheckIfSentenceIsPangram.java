package MonthlyChallenges.Year22.October;

public class CheckIfSentenceIsPangram {

    /**
     * LeetCode #1832. Check if the Sentence Is Pangram.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param sentence - a string of lowercase english letters.
     * @return - True - if sentence is a pangram, false - otherwise. A pangram is a sentence where every letter of the
     * English alphabet appears at least once.
     */
    public boolean checkIfPangram(String sentence) {
        boolean[] usedLetters = new boolean[26];

        for (char letter : sentence.toCharArray()) {
            usedLetters[letter - 'a'] = true;
        }

        for (boolean usedLetter : usedLetters) {
            if (!usedLetter) return false;
        }
        return true;
    }
}
