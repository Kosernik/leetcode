package MonthlyChallenges.January21;

import java.util.Arrays;

public class DetermineIfTwoStringsAreClose {
    /**
     * LeetCode #1657.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param word1 - a string of english lowercase characters.
     * @param word2 - a string of english lowercase characters.
     * @return - true - if two strings are close, false - otherwise.
     */
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        int[] word1count = new int[26];
        int[] word2count = new int[26];

        for (char c : word1.toCharArray()) {
            word1count[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            word2count[c - 'a']++;
        }

        if (compareArrs(word1count, word2count)) return true;

        for (int i = 0; i < 26; i++) {
            if ((word1count[i] == 0 && word2count[i] == 0) || (word1count[i] != 0 && word2count[i] != 0)) {
                continue;
            } else {
                return false;
            }

        }

        Arrays.sort(word1count);
        Arrays.sort(word2count);

        return compareArrs(word1count, word2count);
    }

    private boolean compareArrs(int[] word1count, int[] word2count) {
        for (int i = 0; i < 26; i++) {
            if (word1count[i] != word2count[i]) {
                return false;
            }
        }
        return true;
    }
}
