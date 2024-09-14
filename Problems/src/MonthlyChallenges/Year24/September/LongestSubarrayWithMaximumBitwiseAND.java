package MonthlyChallenges.Year24.September;

public class LongestSubarrayWithMaximumBitwiseAND {


    /**
     * LeetCode №2419. Longest Subarray With Maximum Bitwise AND.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of integers.
     * @return - the length of the longest subarray that has the maximum possible bitwise AND.
     */
    public int longestSubarray(int[] nums) {
        int maxAND = getMax(nums);

        return getMaxLength(maxAND, nums);
    }

    private int getMaxLength(int maxNumber, int[] nums) {
        int maxLength = 1;

        int idx = 0;
        int length = 0;

        while (idx < nums.length) {
            if (nums[idx] == maxNumber) {
                length++;
                maxLength = Math.max(maxLength, length);
            } else {
                length = 0;
            }

            idx++;
        }

        return maxLength;
    }

    private int getMax(int[] nums) {
        int maxNumber = nums[0];

        for (int number : nums) {
            maxNumber = Math.max(maxNumber, number);
        }

        return maxNumber;
    }
}
