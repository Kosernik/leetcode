package MonthlyChallenges.Year25.July;

public class CountHillsAndValleysInArray {

    /**
     * LeetCode №2210. Count Hills and Valleys in an Array.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of integers. nums.length >= 3.
     * @return - the number of hills and valleys in nums.
     */
    public int countHillValley(int[] nums) {
        int prev = nums[0];
        int idx = 1;
        while (idx < nums.length && nums[0] == nums[idx]) {
            idx++;
        }
        if (idx == nums.length) return 0;

        int result = 0;

        for (; idx < nums.length - 1; idx++) {
            if (nums[idx] > prev) {
                if (nums[idx] > nums[idx + 1]) {
                    result++;
                } else if (nums[idx] == nums[idx + 1]) {
                    continue;
                }
            } else if (nums[idx] < prev) {
                if (nums[idx] < nums[idx + 1]) {
                    result++;
                } else if (nums[idx] == nums[idx + 1]) {
                    continue;
                }
            } else {
                continue;
            }

            prev = nums[idx];
        }

        return result;
    }
}
