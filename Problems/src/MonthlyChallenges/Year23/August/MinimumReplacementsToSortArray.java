package MonthlyChallenges.Year23.August;

public class MinimumReplacementsToSortArray {

    /**
     * LeetCode #2366. Minimum Replacements to Sort the Array.
     *
     * @param nums - an array of positive integers.
     * @return - the minimum number of replacement operations to make an array sorted in non-decreasing order.
     * Replacement operation - replace any element in an array with any two numbers that sum to this element.
     */
    public long minimumReplacement(int[] nums) {
        long result = 0L;

        int prevNum = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= prevNum) {
                prevNum = nums[i];
            } else {
                long dividedNumbers = ((long) (nums[i]) + prevNum - 1) / (long) prevNum;

                result += (dividedNumbers - 1);

                prevNum = nums[i] / (int) dividedNumbers;
            }
        }

        return result;
    }
}
