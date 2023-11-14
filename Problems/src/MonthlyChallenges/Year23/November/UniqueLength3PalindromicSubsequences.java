package MonthlyChallenges.Year23.November;

import java.util.HashSet;
import java.util.Set;

public class UniqueLength3PalindromicSubsequences {

    /**
     * LeetCode №1930. Unique Length-3 Palindromic Subsequences.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string of lower-case english letters.
     * @return - the number of unique palindromes of length three that are a subsequence of s.
     */
    public int countPalindromicSubsequence(String s) {
        int[][] firstAndLast = new int[26][2];
        for (int i = 0; i < 26; i++) {
            firstAndLast[i][0] = -1;
        }

        char[] letters = s.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int charIdx = letters[i] - 'a';
            if (firstAndLast[charIdx][0] == -1) {
                firstAndLast[charIdx][0] = i;
            }
            firstAndLast[charIdx][1] = i;
        }

        int result = 0;
        Set<Character> unique = new HashSet<>();

        for (int i = 0; i < 26; i++) {
            if (firstAndLast[i][0] == -1) continue;

            for (int j = firstAndLast[i][0] + 1; j < firstAndLast[i][1]; j++) {
                unique.add(letters[j]);
            }
            result += unique.size();
            unique.clear();
        }

        return result;
    }
}
