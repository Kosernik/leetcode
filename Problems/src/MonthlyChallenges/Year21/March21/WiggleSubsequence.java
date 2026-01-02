package MonthlyChallenges.Year21.March21;

public class WiggleSubsequence {
    /**
     * LeetCode #376.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - array of integers.
     * @return - the length of the longest wiggle sequence in an array.
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;

        int idx = 1;
        while (idx < nums.length && nums[idx - 1] == nums[idx]) {
            idx++;
        }
        if (idx == nums.length) return 1;

        boolean increase = nums[idx] > nums[idx - 1];

        int length = 2;

        for (; idx < nums.length; idx++) {
            if (nums[idx] > nums[idx - 1]) {
                if (!increase) {
                    length++;
                    increase = true;
                }
            } else if (nums[idx] < nums[idx - 1]) {
                if (increase) {
                    length++;
                    increase = false;
                }
            }
        }

        return length;
    }
}
