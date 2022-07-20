package MonthlyChallenges.Year22.July;

import java.util.HashMap;
import java.util.Map;

public class NumberOfMatchingSubsequences {

    /**
     * LeetCode #792. Number of Matching Subsequences.
     *
     * Complexity - O(M*N), N = length of a word, M = words.length
     * Memory - O(M)
     *
     * @param s - a string of lowercase English letters.
     * @param words - an array of strings of lowercase English letters.
     * @return - the number of words from 'words' that are a subsequence of s.
     */
    public int numMatchingSubseq(String s, String[] words) {
        int result = 0;
        char[] sLetters = s.toCharArray();
        boolean[] letters = getLetters(sLetters);
        Map<String, Boolean> visited = new HashMap<>();

        for (String word : words) {
            if (visited.containsKey(word)) {
                result += visited.get(word) ? 1 : 0;
                continue;
            }
            if (isSubsequence(sLetters, word, letters)) {
                visited.put(word, true);
                result++;
            } else {
                visited.put(word, false);
            }
        }

        return result;
    }

    private boolean[] getLetters(char[] sLetters) {
        boolean[] letters = new boolean[26];
        for (char l : sLetters) {
            letters[l-'a'] = true;
        }
        return letters;
    }

    private boolean isSubsequence(char[] s, String word, boolean[] letters) {
        int sIdx = 0, wIdx = 0;
        char[] wordLetters = word.toCharArray();

        while (wIdx < wordLetters.length) {
            char curLetter = wordLetters[wIdx];
            if (!letters[curLetter-'a'] || sIdx == s.length) return false;

            if (s[sIdx] == curLetter) {
                wIdx++;
            }
            sIdx++;
        }

        return true;
    }
}
