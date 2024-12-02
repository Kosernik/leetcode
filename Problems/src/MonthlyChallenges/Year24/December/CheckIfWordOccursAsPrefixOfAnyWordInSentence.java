package MonthlyChallenges.Year24.December;

public class CheckIfWordOccursAsPrefixOfAnyWordInSentence {

    /**
     * LeetCode №1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence.
     * <p>
     * Complexity - O(N*M), N = sentence length, M = searchWord length.
     * Memory - O(1)
     *
     * @param sentence   - a non-empty string.
     * @param searchWord - a non-empty string.
     * @return - the index of the word in sentence (1-indexed) where searchWord is a prefix of this word. If searchWord
     * is a prefix of more than one word, returns the index of the first word (minimum index). If there is no such word
     * returns -1.
     */
    public int isPrefixOfWord(String sentence, String searchWord) {
        int idx = 1;
        for (String word : sentence.split(" ")) {
            if (word.startsWith(searchWord)) {
                return idx;
            }
            idx++;
        }

        return -1;
    }
}
