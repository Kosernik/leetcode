package MonthlyChallenges.November;

public class FindTheSmallestDivisorGivenAThreshold {

    /**
     * Given an array of integers nums and an integer threshold, we will choose a positive integer divisor and divide
     * all the array by it and sum the result of the division. Find the smallest divisor such that the result mentioned
     * above is less than or equal to threshold.
     *
     * Each result of division is rounded to the nearest integer greater than or equal to that element.
     * (For example: 7/3 = 3 and 10/2 = 5).
     *
     * It is guaranteed that there will be an answer.
     *
     * Complexity - O(NlogN)
     * Memory - O(1)
     *
     * @param nums - array of integers, 1 <= nums.length <= 5 * 10^4. 1 <= nums[i] <= 10^6.
     * @param threshold - nums.length <= threshold <= 10^6.
     * @return - the smallest divisor.
     */
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = getMax(nums);

        while (left < right) {
            int middle = (right - left) / 2 + left;

            int sum = 0;
            for (int number : nums) {
                sum += (int) Math.ceil(number * 1.0 / middle);
            }

            if (sum > threshold) {
                left = middle+1;
            } else {
                right = middle;
            }
        }
        return left;
    }

    private int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int number : nums) {
            max = Math.max(max, number);
        }
        return max;
    }
}
