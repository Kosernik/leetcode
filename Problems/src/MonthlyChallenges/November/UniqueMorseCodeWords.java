package MonthlyChallenges.November;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    /**
     * LeetCode #804.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param words - array of strings of lower case english letters.
     * @return - number of unique morse-code words.
     */
    public int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0) return 0;

        Set<String> uniques = new HashSet<>();
        String[] morse = {
                ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",
                ".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        for (String word : words) {
            StringBuilder builder = new StringBuilder();
            for (char letter : word.toCharArray()) {
                builder.append(morse[letter - 'a']);
            }
            uniques.add(builder.toString());
        }

        return uniques.size();
    }
}
