package MonthlyChallenges.Year25.November;

public class MinimumNumberOfOperationsToMakeAllArrayElementsEqualTo1 {

    /**
     * LeetCode №2654. Minimum Number of Operations to Make All Array Elements Equal to 1.
     * <p>
     * Complexity - O(N + logN*N*N)
     * Memory - O(1)
     *
     * @param nums - an array of positive integers.
     * @return - the minimum number of operations to make all elements of nums equal to 1.
     * If it is impossible, return -1.
     */
    public int minOperations(int[] nums) {
        int countOnes = countOnes(nums);
        if (countOnes > 0) {
            if (countOnes == nums.length) return 0;
            return nums.length - countOnes;
        }

        if (!isLengthValid(nums.length, nums)) return -1;

        int left = 2, right = nums.length;
        int middle;

        while (left < right) {
            middle = (left + right) / 2;

            if (isLengthValid(middle, nums)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return (left - 1) * 2 + nums.length - left;
    }

    private int countOnes(int[] nums) {
        int count = 0;
        for (int number : nums) {
            if (number == 1) count++;
        }
        return count;
    }

    private boolean isLengthValid(int length, int[] nums) {
        for (int start = 0, end = start + length - 1; end < nums.length; start++, end++) {
            int curGCD = getSubarrayGCD(start, end, nums);

            if (curGCD == 1) return true;
        }

        return false;
    }

    private int getSubarrayGCD(int start, int end, int[] nums) {
        int res = nums[start];

        for (int i = start + 1; i <= end; i++) {
            res = gcd(res, nums[i]);

            if (res == 1) return 1;
        }

        return res;
    }

    /**
     * Greatest Common Divider
     *
     * @param a - a positive integer.
     * @param b - a positive integer.
     * @return - the greatest common divider.
     */
    public static int gcd(int a, int b) {
        // Euclidean algorithm iteratively
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }

        return a;
    }
}
