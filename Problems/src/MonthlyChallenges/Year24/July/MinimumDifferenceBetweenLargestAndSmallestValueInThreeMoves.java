package MonthlyChallenges.Year24.July;

import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {

    /**
     * LeetCode №1509. Minimum Difference Between Largest and Smallest Value in Three Moves.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(1) + O(sorting memory)
     *
     * @param nums - an array of integers.
     * @return - the minimum difference between the largest and smallest value of nums after performing at most three
     * moves. In one move, you can choose one element of nums and change it to any value.
     */
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        int minDifference = nums[nums.length - 1] - nums[0];
        if (nums.length <= 3) return 0;

        for (int i = 0; i <= 3; i++) {
            int curDiff = nums[nums.length - 1 - i] - nums[3 - i];
            minDifference = Math.min(minDifference, curDiff);
        }

        return minDifference;
    }
}
