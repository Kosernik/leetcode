package MonthlyChallenges.Year24.November;

public class FindIfArrayCanBeSorted {

    /**
     * LeetCode №3011. Find if Array Can Be Sorted.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     * <p>
     * An operation - swapping any two adjacent elements if they have the same number of set bits.
     * .
     *
     * @param nums - an array of positive integers.
     * @return - true - if it is possible to sort the array by performing an operation any number of times.
     * False - otherwise.
     */
    public boolean canSortArray(int[] nums) {
        int prevMax = 0;

        int curMin = Integer.MAX_VALUE;
        int curMax = 0;

        int bitsSet = 0;

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            int curBitsSet = Integer.bitCount(number);

            if (curBitsSet != bitsSet) {
                if (curMin < prevMax) return false;

                prevMax = curMax;
                curMax = number;
                curMin = number;

                bitsSet = curBitsSet;
            } else {
                curMax = Math.max(curMax, number);
                curMin = Math.min(curMin, number);
            }
        }

        return curMin >= prevMax;
    }
}
