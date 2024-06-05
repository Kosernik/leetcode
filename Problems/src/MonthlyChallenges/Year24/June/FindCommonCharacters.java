package MonthlyChallenges.Year24.June;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {

    /**
     * LeetCode №1002. Find Common Characters.
     * <p>
     * Complexity - O(N*M), N = words.length, M = words[i].length
     * Memory - O(1)
     *
     * @param words - an array of strings. words[i] consists only of lowercase english letters.
     * @return - a list of all characters that show up in all strings within the words (including duplicates).
     */
    public List<String> commonChars(String[] words) {
        int[] common = new int[26];
        Arrays.fill(common, Integer.MAX_VALUE);

        for (String word : words) {
            int[] curWord = new int[26];
            for (char ch : word.toCharArray()) {
                curWord[ch - 'a']++;
            }

            intersection(common, curWord);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            String letter = String.valueOf((char) ('a' + i));
            for (int j = 0; j < common[i]; j++) {
                result.add(letter);
            }
        }

        return result;
    }

    private void intersection(int[] common, int[] word) {
        for (int i = 0; i < 26; i++) {
            common[i] = Math.min(common[i], word[i]);
        }
    }
}
