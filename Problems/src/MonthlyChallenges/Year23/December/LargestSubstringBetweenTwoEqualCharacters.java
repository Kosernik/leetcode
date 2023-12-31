package MonthlyChallenges.Year23.December;

import java.util.Arrays;

public class LargestSubstringBetweenTwoEqualCharacters {

    /**
     * LeetCode №1624. Largest Substring Between Two Equal Characters.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string of english lowercase letters.
     * @return - the length of the longest substring between two equal characters, excluding the two characters.
     * If there is no such substring returns -1.
     */
    public int maxLengthBetweenEqualCharacters(String s) {
        int result = -1;

        int[] prevIdx = new int[26];    //  26 - the number of unique characters
        Arrays.fill(prevIdx, -1);

        for (int i = 0; i < s.length(); i++) {
            char curLetter = s.charAt(i);

            if (prevIdx[curLetter - 'a'] != -1) {
                int curResult = i - prevIdx[curLetter - 'a'] - 1;
                result = Math.max(result, curResult);
            } else {
                prevIdx[curLetter - 'a'] = i;
            }
        }

        return result;
    }
}
