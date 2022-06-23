package Problems;

import java.math.BigInteger;
import java.util.Arrays;

public class NumberOfSubsequencesThatSatisfyGivenSumCondition {
    public static void main(String[] args) {
        NumberOfSubsequencesThatSatisfyGivenSumCondition solution =
                new NumberOfSubsequencesThatSatisfyGivenSumCondition();

        int[] test0 = {27,21,14,2,15,1,19,8,12,24,21,8,12,10,11,30,15,18,28,14,26,9,2,24,23,11,7,12,9,17,30,9,28,2,14,
                22,19,19,27,6,15,12,29,2,30,11,20,30,21,20,2,22,6,14,13,19,21,10,18,30,2,20,28,22};

        System.out.println(solution.numSubseq(test0, 31));
    }

    /**
     * LeetCode #1498. Number of Subsequences That Satisfy the Given Sum Condition.
     *
     * Complexity - O(NlogN)
     * Memory - O(1)
     *
     * @param nums - an array of positive integers.
     * @param target - a positive integer.
     * @return - the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it
     *           is less or equal to target. The result is modulo 1_000_000_007.
     */
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);

        int MODULO = 1_000_000_007;
        long result = 0;

        BigInteger base = BigInteger.valueOf(2);
        BigInteger mod = BigInteger.valueOf(MODULO);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] + nums[i] > target) break;

            int sumRemainder = target - nums[i];
            int idx = binSearchRightmost(sumRemainder, nums);

            BigInteger exp = BigInteger.valueOf(idx-i);
            long moddedPower = base.modPow(exp, mod).longValue();

            result = (result + moddedPower) % MODULO;
        }

        return (int) result;
    }

    private int binSearchRightmost(int number, int[] nums) {
        int left = 0, right = nums.length, middle;

        while (left < right) {
            middle = (right + left) / 2;

            if (nums[middle] > number) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return right - 1;
    }
}
