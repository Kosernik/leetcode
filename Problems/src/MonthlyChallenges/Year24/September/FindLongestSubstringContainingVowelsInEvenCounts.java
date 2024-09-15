package MonthlyChallenges.Year24.September;

import java.util.HashMap;
import java.util.Map;

public class FindLongestSubstringContainingVowelsInEvenCounts {

    /**
     * LeetCode №1371. Find the Longest Substring Containing Vowels in Even Counts.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string of lowercase letters.
     * @return - the size of the longest substring containing each vowel an even number of times.
     */
    public int findTheLongestSubstring(String s) {
        int maxLength = 0;

        int curCount = 0;
        Map<Integer, Integer> indices = new HashMap<>();
        indices.put(curCount, -1);

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);

            if (letter == 'a') {
                curCount = flipBit(curCount, 0);
            } else if (letter == 'e') {
                curCount = flipBit(curCount, 1);
            } else if (letter == 'i') {
                curCount = flipBit(curCount, 2);
            } else if (letter == 'o') {
                curCount = flipBit(curCount, 3);
            } else if (letter == 'u') {
                curCount = flipBit(curCount, 4);
            }

            if (indices.containsKey(curCount)) {
                int candidateLength = i - indices.get(curCount);

                maxLength = Math.max(maxLength, candidateLength);
            } else {
                indices.put(curCount, i);
            }
        }

        return maxLength;
    }

    private int flipBit(int number, int bitIdx) {
        return number ^ (1 << bitIdx);
    }
}
