package MonthlyChallenges.Year26.May;

public class MinimumElementAfterReplacementWithDigitSum {

    /**
     * LeetCode №3300. Minimum Element After Replacement With Digit Sum.
     *
     * @param nums - an array of integers.
     * @return - the minimum element in nums after all replacements. (A replacement of a number is a sum of its digits)
     */
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int number : nums) {
            int curSum = 0;

            while (number > 0) {
                curSum += number % 10;
                number /= 10;
            }

            min = Math.min(min, curSum);
        }

        return min;
    }
}
