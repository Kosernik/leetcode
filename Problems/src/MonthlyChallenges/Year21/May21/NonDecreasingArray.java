package MonthlyChallenges.Year21.May21;

public class NonDecreasingArray {
    /**
     * LeetCode #665.
     * <p>
     * Complexity - O(N)
     * memory - O(1)
     *
     * @param nums - array of integers.
     * @return - True - if array can become non-decreasing by modifying at most one element, false - otherwise.
     */
    public boolean checkPossibility(int[] nums) {
        boolean found = false;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (found) return false;
                found = true;

                if (i == 1 || i == nums.length - 1 || nums[i - 1] <= nums[i + 1] || nums[i - 2] <= nums[i]) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
