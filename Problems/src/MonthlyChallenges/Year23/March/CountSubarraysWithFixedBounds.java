package MonthlyChallenges.Year23.March;

public class CountSubarraysWithFixedBounds {


    /**
     * LeetCode #2444. Count Subarrays With Fixed Bounds.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of integers.
     * @param minK - an integer.
     * @param maxK - an integer.
     * @return - the number of subarrays in which the minimum value equals 'minK' and the maximum value equals 'maxK'.
     */
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long result = 0L;

        int idxInvalidElement = -1;
        int idxLowElement = -1;
        int idxHighElement = -1;

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if (number < minK || maxK < number) {
                idxInvalidElement = i;
            }
            if (number == minK) {
                idxLowElement = i;
            }
            if (number == maxK) {
                idxHighElement = i;
            }

            result += Math.max(0L, Math.min(idxLowElement, idxHighElement) - idxInvalidElement);
        }

        return result;
    }
}
