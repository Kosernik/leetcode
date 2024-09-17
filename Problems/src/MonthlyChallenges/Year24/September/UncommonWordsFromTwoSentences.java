package MonthlyChallenges.Year24.September;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWordsFromTwoSentences {

    /**
     * LeetCode №884. Uncommon Words from Two Sentences.
     * <p>
     * Complexity - O(N+M), N = s1.length, M = s2.length.
     * Memory - O(N+M)
     * <p>
     * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
     *
     * @param s1 - a string.
     * @param s2 - a string.
     * @return - a list of all the uncommon words.
     */
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> counts = new HashMap<>();

        String[] splitS1 = splitString(s1);
        String[] splitS2 = splitString(s2);

        countWords(splitS1, counts);
        countWords(splitS2, counts);

        List<String> uncommons = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                uncommons.add(entry.getKey());
            }
        }

        return convertListToArray(uncommons);
    }

    private String[] convertListToArray(List<String> words) {
        String[] result = new String[words.size()];

        int idx = 0;
        for (String word : words) {
            result[idx] = word;
            idx++;
        }

        return result;
    }

    private void countWords(String[] s, Map<String, Integer> counts) {
        for (String word : s) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
    }

    private String[] splitString(String s) {
        return s.split("\\s+");
    }
}
