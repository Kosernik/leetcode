package MonthlyChallenges.Year23.December;

public class MaximumProductOfTwoElementsInArray {

    /**
     * LeetCode №1464. Maximum Product of Two Elements in an Array.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of positive integers.
     * @return - the maximum value of (nums[i]-1)*(nums[j]-1).
     */
    public int maxProduct(int[] nums) {
        int maxVal = 0, secondMax = 0;

        for (int number : nums) {
            if (number > maxVal) {
                secondMax = maxVal;
                maxVal = number;
            } else if (number > secondMax) {
                secondMax = number;
            }
        }

        return (maxVal - 1) * (secondMax - 1);
    }
}
