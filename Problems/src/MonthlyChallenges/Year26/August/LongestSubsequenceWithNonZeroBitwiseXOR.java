package MonthlyChallenges.Year26.August;

public class LongestSubsequenceWithNonZeroBitwiseXOR {

    /**
     * LeetCode №3702. Longest Subsequence With Non-Zero Bitwise XOR.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of non-negative integers.
     * @return - the length of the longest subsequence in nums whose bitwise XOR is non-zero.
     * If no such subsequence exists, return 0.
     */
    public int longestSubsequence(int[] nums) {
        int zeroes = 0;
        int XOR = 0;

        for (int number : nums) {
            if (number == 0) zeroes++;

            XOR ^= number;
        }

        if (XOR == 0) {
            if (zeroes == nums.length) return 0;
            return nums.length - 1;
        }

        return nums.length;
    }
}
