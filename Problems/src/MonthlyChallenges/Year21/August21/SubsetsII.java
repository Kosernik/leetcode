package MonthlyChallenges.Year21.August21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    // leetCode #90
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        backTrack(nums, 0, result, new ArrayList<>());

        return result;
    }

    private void backTrack(int[] nums, int idx, List<List<Integer>> result, List<Integer> subset) {
        result.add(new ArrayList<>(subset));

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            subset.add(nums[i]);
            backTrack(nums, i + 1, result, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
