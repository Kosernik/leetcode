package MonthlyChallenges.October;

public class OneThreeTwoPattern {

    /**
     * Returns if there is a 132-pattern in a given array.
     *
     * Complexity - O(N^2)
     * Memory - O(1)
     *
     * @param nums - array of integers.
     * @return - True - if there is a 132-pattern in an array, false - otherwise.
     */
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length <= 2) return false;

        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length-1; i++) {
            minValue = Math.min(minValue, nums[i]);
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[i] && minValue < nums[j]) return true;
            }
        }
        return false;
    }
}
