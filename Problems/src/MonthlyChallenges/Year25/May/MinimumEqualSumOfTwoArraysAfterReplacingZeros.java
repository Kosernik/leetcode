package MonthlyChallenges.Year25.May;

public class MinimumEqualSumOfTwoArraysAfterReplacingZeros {

    /**
     * LeetCode №2918. Minimum Equal Sum of Two Arrays After Replacing Zeros.
     * <p>
     * Complexity - O(N+M)
     * Memory - O(1)
     * <p>
     * You have to replace all the 0's in both arrays with strictly positive integers such that the sum of elements of
     * both arrays becomes equal.
     *
     * @param nums1 - an array of positive integers.
     * @param nums2 - an array of positive integers.
     * @return - the minimum equal sum it is possible to obtain, or -1 if it is impossible.
     */
    public long minSum(int[] nums1, int[] nums2) {
        long firstSum = 0L, secondSum = 0L;
        int firstZeroes = 0, secondZeroes = 0;

        for (int number : nums1) {
            if (number == 0) {
                firstZeroes++;
            } else {
                firstSum += number;
            }
        }
        for (int number : nums2) {
            if (number == 0) {
                secondZeroes++;
            } else {
                secondSum += number;
            }
        }

        if (firstZeroes == 0 && secondZeroes == 0) {
            if (firstSum == secondSum) {
                return firstSum;
            } else {
                return -1;
            }
        } else if (firstZeroes == 0 || secondZeroes == 0) {
            if (firstZeroes == 0) {
                if (canMakeValid(firstSum, secondSum, secondZeroes)) {
                    return firstSum;
                }
            } else { // secondZeroes == 0
                if (canMakeValid(secondSum, firstSum, firstZeroes)) {
                    return secondSum;
                }
            }

            return -1;
        } else {
            firstSum += firstZeroes;
            secondSum += secondZeroes;

            return Math.max(firstSum, secondSum);
        }
    }

    private boolean canMakeValid(long sumA, long sumB, int zeroesB) {
        return sumA >= (sumB + zeroesB);
    }
}
