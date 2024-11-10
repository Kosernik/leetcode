package MonthlyChallenges.Year24.November;

public class ShortestSubarrayWithORAtLeastKII {

    /**
     * LeetCode №3097. Shortest Subarray With OR at Least K II.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of non-negative integers.
     * @param k    - the target OR of a subarray.
     * @return - the length of the shortest special non-empty subarray of nums, or returns -1 if no special subarray
     * exists.
     */
    public int minimumSubarrayLength(int[] nums, int k) {
        int result = nums.length + 1;

        int start = 0;

        int OR = 0;
        int[] bitsCount = new int[31];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k) return 1;

            OR |= nums[i];
            updateBitsCount(nums[i], bitsCount);

            while (OR >= k && start < i) {
                OR = unsetBits(nums[start], OR, bitsCount);

                result = Math.min(result, i - start + 1);
                start++;
            }

        }

        if (result == (nums.length + 1)) return -1;
        else return result;
    }

    private void updateBitsCount(int number, int[] bitsCount) {
        for (int i = 0; i < bitsCount.length; i++) {
            int shiftedOne = 1 << i;
            if ((number & shiftedOne) == shiftedOne) {
                bitsCount[i]++;
            }
        }
    }

    private int unsetBits(int number, int OR, int[] bitsCount) {
        int updatedOR = OR;

        for (int i = 0; i < bitsCount.length; i++) {
            int shiftedOne = 1 << i;
            if ((number & shiftedOne) == shiftedOne) {
                bitsCount[i]--;

                if (bitsCount[i] == 0) {
                    updatedOR ^= shiftedOne;
                }
            }
        }

        return updatedOR;
    }
}
