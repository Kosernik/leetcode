package MonthlyChallenges.Year26.August;

public class MaximumLengthSubstringWithTwoOccurrences {

    /**
     * LeetCode №3090. Maximum Length Substring With Two Occurrences.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string of lowercase english letters.
     * @return - the maximum length of a substring such that it contains at most two occurrences of each character.
     */
    public int maximumLengthSubstring(String s) {
        int[] counts = new int[26];
        char[] letters = s.toCharArray();

        int maxLength = 0;

        int left = 0;

        for (int right = 0; right < letters.length; right++) {
            int charIdx = letters[right] - 'a';

            counts[charIdx]++;

            while (counts[charIdx] > 2) {
                counts[letters[left] - 'a']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
