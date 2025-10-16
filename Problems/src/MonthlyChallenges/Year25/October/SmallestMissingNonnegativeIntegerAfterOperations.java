package MonthlyChallenges.Year25.October;

public class SmallestMissingNonnegativeIntegerAfterOperations {
    public static void main(String[] args) {
        SmallestMissingNonnegativeIntegerAfterOperations solution = new SmallestMissingNonnegativeIntegerAfterOperations();

        int[] nums0 = {1, -10, 7, 13, 6, 8};
        int value0 = 5;
        int result0 = 4;
        System.out.println(solution.findSmallestInteger(nums0, value0) + "==" + result0);

        int[] nums1 = {1, -10, 7, 13, 6, 8};
        int value1 = 7;
        int result1 = 2;
        System.out.println(solution.findSmallestInteger(nums1, value1) + "==" + result1);
    }

    /**
     * LeetCode №2598. Smallest Missing Non-negative Integer After Operations.
     * <p>
     * Complexity - O(N + M), N = nums.length, M = value.
     * Memory - O(M)
     * <p>
     * An operation: add or subtract value from any number in nums.
     * The MEX (minimum excluded) of an array is the smallest missing non-negative integer in it.
     *
     * @param nums  - an array of integers.
     * @param value - a positive integer.
     * @return - the maximum MEX of nums after applying the mentioned operation any number of times.
     */
    public int findSmallestInteger(int[] nums, int value) {
        int[] counts = new int[value];

        for (int number : nums) {
            int curMin;
            if (number >= 0) {
                curMin = number % value;
            } else {
                curMin = ((number % value) + value) % value;
            }

            counts[curMin]++;
        }

        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) return i;

            smallest = Math.min(smallest, counts[i] * value + i);
        }

        return smallest;
    }
}
