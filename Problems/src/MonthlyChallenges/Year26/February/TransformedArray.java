package MonthlyChallenges.Year26.February;

public class TransformedArray {

    /**
     * LeetCode №3379. Transformed Array.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of integers.
     * @return - the resulting array.
     */
    public int[] constructTransformedArray(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            int steps = Math.abs(nums[i]) % length;

            if (nums[i] > 0) {
                result[i] = nums[(i + steps) % length];
            } else if (nums[i] < 0) {
                result[i] = nums[(i - steps + length) % length];
            } else {
                result[i] = 0;
            }
        }

        return result;
    }
}
