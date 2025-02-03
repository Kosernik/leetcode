package MonthlyChallenges.Year25.February;

public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {

    /**
     * LeetCode №3105. Longest Strictly Increasing or Strictly Decreasing Subarray.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of integers.
     * @return -  the length of the longest subarray of nums which is either strictly increasing or strictly decreasing.
     */
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length <= 1) return 1;

        int result = 1;

        int idx = 1;

        while (idx < nums.length) {
            if (nums[idx] == nums[idx - 1]) {
                idx++;
            } else {
                int curLength = 1;

                if (nums[idx] > nums[idx - 1]) {
                    while (idx < nums.length && nums[idx] > nums[idx - 1]) {
                        curLength++;
                        idx++;
                    }
                } else {
                    while (idx < nums.length && nums[idx] < nums[idx - 1]) {
                        curLength++;
                        idx++;
                    }
                }

                result = Math.max(result, curLength);
            }
        }

        return result;
    }
}
