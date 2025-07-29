package MonthlyChallenges.Year25.July;

public class SmallestSubarraysWithMaximumBitwiseOR {

    /**
     * LeetCode №2411. Smallest Subarrays With Maximum Bitwise OR.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of non-negative integers.
     * @return -  an integer array result of size n where result[i] is the length of the minimum sized subarray
     * starting at i with maximum bitwise OR.
     */
    public int[] smallestSubarrays(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        int[][] nextIdx = new int[length + 1][31];
        for (int i = 0; i < 31; i++) {
            nextIdx[length][i] = -1;
        }

        for (int i = length - 1; i >= 0; i--) {
            int number = nums[i];

            int maxLength = 1;

            for (int bitIdx = 0, mask = 1; bitIdx < 31; bitIdx++, mask = mask << 1) {
                if ((number & mask) == mask) {
                    nextIdx[i][bitIdx] = i;
                } else {
                    nextIdx[i][bitIdx] = nextIdx[i + 1][bitIdx];

                    if (nextIdx[i][bitIdx] != -1) maxLength = Math.max(maxLength, nextIdx[i][bitIdx] - i + 1);
                }
            }

            result[i] = maxLength;
        }

        return result;
    }
}
