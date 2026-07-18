package MonthlyChallenges.Year26.July;

public class FindGreatestCommonDivisorOfArray {

    /**
     * LeetCode №1979. Find Greatest Common Divisor of Array.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of integers.
     * @return - the greatest common divisor of the smallest number and largest number in nums.
     */
    public int findGCD(int[] nums) {
        int minValue = nums[0], maxValue = nums[0];

        for (int number : nums) {
            minValue = Math.min(minValue, number);
            maxValue = Math.max(maxValue, number);
        }

        return gcd(maxValue, minValue);
    }

    public int gcd(int a, int b) {
        // Euclidean algorithm iteratively
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }

        return a;
    }
}
