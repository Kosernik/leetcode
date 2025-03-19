package MonthlyChallenges.Year25.March;

public class MinimumOperationsToMakeBinaryArrayElementsEqualToOneI {

    /**
     * LeetCode №3191. Minimum Operations to Make Binary Array Elements Equal to One I.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - a binary array of 0 and 1. nums.length >= 3
     * @return - the minimum number of flip operations required to make all elements in nums equal to 1.
     * If it is impossible, returns -1.
     */
    public int minOperations(int[] nums) {
        int flips = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                flips++;

                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
            }
        }

        if (nums[nums.length - 1] == 0 || nums[nums.length - 2] == 0) return -1;
        return flips;
    }


    /**
     * LeetCode №3191. Minimum Operations to Make Binary Array Elements Equal to One I.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - a binary array of 0 and 1. nums.length >= 3
     * @return - the minimum number of flip operations required to make all elements in nums equal to 1.
     * If it is impossible, returns -1.
     */
    public int minOperationsSlow(int[] nums) {
        int flips = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                flips++;

                nums[i + 1] = (nums[i + 1] + 1) % 2;
                nums[i + 2] = (nums[i + 2] + 1) % 2;
            }
        }

        if (nums[nums.length - 1] == 0 || nums[nums.length - 2] == 0) return -1;
        return flips;
    }
}
