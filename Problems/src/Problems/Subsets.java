package Problems;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    /**
     * 78. Subsets.
     *
     * @param nums - an array of unique integers.
     * @return - all possible subsets (the power set).
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, result, new ArrayList<>());

        return result;
    }

    private void backtrack(int[] nums, int idx, List<List<Integer>> result, List<Integer> subset) {
        if (idx > nums.length) return;
        result.add(new ArrayList<>(subset));

        for (int i = idx; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(nums, i+1, result, subset);
            subset.remove(subset.size()-1);
        }
    }
}
