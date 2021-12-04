package Problems;

import java.util.*;

public class CombinationSumII {

    private List<List<Integer>> combinations;
    private final Set<String> uniques = new HashSet<>();

    /**
     * LeetCode #40. Combination Sum.
     *
     *
     * @param candidates - an array of distinct positive integers.
     * @param target - a positive integer.
     * @return - a list of all unique combinations of candidates where the chosen numbers sum to target.
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        combinations = new ArrayList<>();

        int totalSum = getSum(candidates);
        if (totalSum < target) return combinations;
        else if ((totalSum == target)) {
            List<Integer> temp = new ArrayList<>();
            for (int elem : candidates) temp.add(elem);
            combinations.add(temp);
            return combinations;
        }

        Map<Integer, Integer> counts = getCounts(candidates);
        backtrack(counts, target, new ArrayList<>());

        return combinations;
    }

    private void backtrack(Map<Integer, Integer> counts, int target, List<Integer> combination) {
        if (target < 0) return;
        else if (target == 0) {
            List<Integer> sorted = new ArrayList<>(combination);
            Collections.sort(sorted);
            if (uniques.add(sorted.toString())) combinations.add(sorted);
            return;
        }

        for (Integer candidate : counts.keySet()) {
            if (counts.get(candidate) > 0) {
                combination.add(candidate);
                counts.put(candidate, counts.get(candidate) - 1);
                backtrack(counts, target-candidate, combination);
                counts.put(candidate, counts.get(candidate) + 1);
                combination.remove(combination.size()-1);
            }
        }
    }

    private int getSum(int[] candidates) {
        int sum = 0;
        for (int num : candidates) sum += num;
        return sum;
    }

    private Map<Integer, Integer> getCounts(int[] candidates) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int number : candidates) counts.put(number, 1 + counts.getOrDefault(number, 0));
        return counts;
    }
}
