package MonthlyChallenges.March21;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
    /**
     * LeetCode #916.
     *
     * Complexity - O(M + N), M - the size of an array "B", N - the size of an array "A".
     * Memory - O(1)
     *
     * @param A - an array of strings of english lowercase letters
     * @param B - an array of strings of english lowercase letters
     * @return - a list of all universal words in "A".
     */
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] totalCount = new int[26];

        for (String s : B) {
            int[] currWord = countLetters(s);
            for (int i = 0; i < 26; i++) {
                totalCount[i] = Math.max(totalCount[i], currWord[i]);
            }
        }

        List<String> result = new ArrayList<>();

        for (String word : A) {
            int[] wordCount = countLetters(word);
            boolean goodWord = true;
            for (int i = 0; i < 26; i++) {
                if (wordCount[i] < totalCount[i]) {
                    goodWord = false;
                    break;
                }
            }
            if (goodWord) result.add(word);
        }

        return result;
    }


    private int[] countLetters (String word) {
        int[] count = new int[26];

        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }

        return count;
    }
}
