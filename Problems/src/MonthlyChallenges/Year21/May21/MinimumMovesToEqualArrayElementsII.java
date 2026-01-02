package MonthlyChallenges.Year21.May21;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII {
    public static void main(String[] args) {
        MinimumMovesToEqualArrayElementsII solution = new MinimumMovesToEqualArrayElementsII();
    }

    /**
     * LeetCode #462.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(1)
     *
     * @param nums - array of integers.
     * @return - the minimum number of moves required to make all array elements equal.
     */
    public int minMoves2(int[] nums) {
        if (nums.length <= 1) return 0;

        int result = 0;
        Arrays.sort(nums);

        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            result += nums[j] - nums[i];
            if (nums[i] == nums[j]) return result;
        }

        return result;
    }
}
