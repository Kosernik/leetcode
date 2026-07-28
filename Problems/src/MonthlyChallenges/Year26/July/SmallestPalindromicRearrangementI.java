package MonthlyChallenges.Year26.July;

public class SmallestPalindromicRearrangementI {

    /**
     * LeetCode №3517. Smallest Palindromic Rearrangement I.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a valid palindromic string of lowercase english letters.
     * @return - the lexicographically smallest palindromic permutation of s.
     */
    public String smallestPalindrome(String s) {
        int[] counts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        char[] result = new char[s.length()];
        int left = 0, right = s.length() - 1;

        if ((s.length() & 1) == 1) {
            result[result.length / 2] = s.charAt(result.length / 2);
            counts[result[result.length / 2] - 'a']--;
        }

        for (int i = 0; i < counts.length; i++) {
            char letter = (char) ('a' + i);

            int count = counts[i];
            int half = count / 2;

            for (; count > half; count--, left++) {
                result[left] = letter;
            }
            for (; count > 0; count--, right--) {
                result[right] = letter;
            }
        }

        return new String(result);
    }
}
