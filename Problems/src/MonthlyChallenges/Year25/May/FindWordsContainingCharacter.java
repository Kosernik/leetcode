package MonthlyChallenges.Year25.May;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter {

    /**
     * LeetCode №2942. Find Words Containing Character.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param words - an array of strings.
     * @param x     - the required character.
     * @return - an array of indices representing the words that contain the character x.
     */
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (containsChar(words[i], x)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean containsChar(String word, char x) {
        for (char letter : word.toCharArray()) {
            if (letter == x) return true;
        }
        return false;
    }
}
