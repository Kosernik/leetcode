package MonthlyChallenges.Year23.March;

public class NumberOfZeroFilledSubarrays {

    /**
     * LeetCode #2348. Number of Zero-Filled Subarrays.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of integers.
     * @return - the number of subarrays filled with 0.
     */
    public long zeroFilledSubarray(int[] nums) {
        long result = 0L;

        int idx = 0;
        while (idx < nums.length) {
            if (nums[idx] == 0) {
                int length = 0;
                while (idx < nums.length && nums[idx] == 0) {
                    length++;
                    idx++;
                }
                result += length * (length + 1L) / 2;
            }
            idx++;
        }

        return result;
    }
}
