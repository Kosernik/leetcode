package MonthlyChallenges.September;

import java.util.*;

public class CombinationSumIII {
    public static void main(String[] args) {
        CombinationSumIII solution = new CombinationSumIII();
        int[] test0 = {3,7};
        int[] test1 = {3,9};

        System.out.println(solution.combinationSum3(test0[0], test0[1]));
        System.out.println(solution.combinationSum3(test1[0], test1[1]));
    }

    /**
     * Finding all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9
     * can be used and each combination should be a unique set of numbers.
     *
     * @param k - number of digits, positive integer.
     * @param n - target sum of digits, positive integer.
     * @return - list of lists of combinations.
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        boolean[] usedDigits = new boolean[10];
        Integer[] currCombin = new Integer[k];
        Set<Integer> usedCombinations = new HashSet<>();

        backtrack(0, 0, combinations, currCombin, usedDigits, usedCombinations,  k, n);

        return combinations;
    }

    private void backtrack(int curSum, int curLen, List<List<Integer>> combinations,Integer[] currCombin,
                           boolean[] usedDigits, Set<Integer> usedCombinations, int k, int n) {
        if (curSum == n && curLen == k) {
            List<Integer> list = new ArrayList<>();
            list.addAll(Arrays.asList(currCombin));
            Collections.sort(list);

            int key = buildKey(list);
            if (!usedCombinations.contains(key)) {
                combinations.add(list);
            }
            usedCombinations.add(key);
        } else if (curSum >= n || curLen >= k) {
            return;
        } else {
            for (int i = 1; i <= 9; i++) {
                if (!usedDigits[i] && (curSum + i) <= n) {
                    currCombin[curLen] = i;
                    usedDigits[i] = true;
                    backtrack(curSum + i, curLen + 1, combinations, currCombin, usedDigits, usedCombinations, k, n);
                    usedDigits[i] = false;
                    currCombin[curLen] = 0;
                }
            }
        }
    }

    private int buildKey(List<Integer> list) {
        int key = 0;
        for (Integer integer : list) {
            key *= 10;
            key += integer;
        }
        return key;
    }
}
