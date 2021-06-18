package MonthlyChallenges.June21;

public class NumberOfSubarraysWithBoundedMaximum {
    public static void main(String[] args) {
        NumberOfSubarraysWithBoundedMaximum solution = new NumberOfSubarraysWithBoundedMaximum();

        int[] test0 = {2,1,4,3};
        System.out.println(solution.numSubarrayBoundedMax(test0, 2,3));
    }

    /**
     * LeetCode #795.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of positive integers.
     * @param left - lower bound.
     * @param right - upper bound.
     * @return - the number of (contiguous, non-empty) sub-arrays such that the value of the maximum array element in
     *           that sub-array is at least left and at most right.
     */
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return countNumbers(nums, right) - countNumbers(nums, left-1);
    }

    private int countNumbers(int[] nums, int bound) {
        int result = 0, count = 0;

        for (int number : nums) {
            count = number <= bound ? count+1 : 0;
            result += count;
        }

        return result;
    }
}
