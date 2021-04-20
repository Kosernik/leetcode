package MonthlyChallenges.April21;

import java.util.Arrays;

public class CombinationSumIV {

    // LeetCode #377.
    private int[] computed;
    public int combinationSum4(int[] nums, int target) {
        computed = new int[target+1];
        Arrays.fill(computed, -1);
        computed[0] = 1;

        return recursion(nums, target);
    }

    private int recursion(int[] nums, int target) {
        if (computed[target] != -1) return computed[target];

        int result = 0;

        for (int num : nums) {
            if (target - num >= 0) {
                result += recursion(nums, target - num);
            }
        }

        computed[target] = result;
        return result;
    }
}
