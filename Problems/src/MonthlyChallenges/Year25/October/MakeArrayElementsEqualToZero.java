package MonthlyChallenges.Year25.October;

import java.util.Arrays;

public class MakeArrayElementsEqualToZero {

    /**
     * LeetCode №3354. Make Array Elements Equal to Zero.
     *
     * @param nums - an array of non-negative integers.
     * @return - the number of possible valid selections. A selection of the initial position curr and movement
     * direction is considered valid if every element in nums becomes 0 by the end of the process.
     */
    public int countValidSelections(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result += canMakeZero(i, -1, Arrays.copyOf(nums, nums.length));
                result += canMakeZero(i, 1, Arrays.copyOf(nums, nums.length));
            }
        }

        return result;
    }

    private int canMakeZero(int curr, int direction, int[] nums) {
        if (curr < 0 || curr >= nums.length) {
            for (int num : nums) {
                if (num != 0) return 0;
            }
            return 1;
        }

        if (nums[curr] != 0) {
            nums[curr]--;

            direction *= -1;
        }

        return canMakeZero(curr + direction, direction, nums);
    }
}
