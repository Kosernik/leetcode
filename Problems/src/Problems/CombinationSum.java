package Problems;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    private List<List<Integer>> combinations;

    /**
     * LeetCode #39. Combination Sum.
     *
     *
     * @param candidates - an array of distinct positive integers.
     * @param target - a positive integer.
     * @return - a list of all unique combinations of candidates where the chosen numbers sum to target.
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinations = new ArrayList<>();
        backTrack(candidates, target, 0, new ArrayList<>());
        return combinations;
    }

    private void backTrack(int[] candidates, int target, int idx, List<Integer> combination) {
        if (target < 0 || idx >= candidates.length) return;
        else if (target == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            combination.add(candidates[i]);
            backTrack(candidates, target-candidates[i], i, combination);
            combination.remove(combination.size()-1);
        }
    }
}
