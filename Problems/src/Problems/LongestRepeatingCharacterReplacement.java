package Problems;

public class LongestRepeatingCharacterReplacement {

    /**
     * LeetCode #424. Longest Repeating Character Replacement.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string of uppercase English letters.
     * @param k - tha maximum number of letters you can change.
     * @return - the length of the longest substring containing the same letter after changing at most k-letters.
     */
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        char[] letters = s.toCharArray();

        int maxFrequency = 1;

        int result = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            count[letters[right]-'A']++;
            if (count[letters[right]-'A'] > maxFrequency) {
                maxFrequency = count[letters[right]-'A'];
            }

            while (right - left + 1 - maxFrequency > k) {
                count[letters[left]-'A']--;
                left++;

                maxFrequency = getMaxCount(count);
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    private int getMaxCount(int[] count) {
        int maxCount = count[0];
        for (int c : count) {
            maxCount = Math.max(maxCount, c);
        }
        return maxCount;
    }
}
