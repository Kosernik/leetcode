package MonthlyChallenges.Year24.June;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class MinimumIncrementToMakeArrayUnique {
    public static void main(String[] args) {
        MinimumIncrementToMakeArrayUnique solution = new MinimumIncrementToMakeArrayUnique();

        int[] test1 = {3, 2, 1, 2, 1, 7};
        System.out.println(solution.minIncrementForUnique(test1) == 6);

        int[] test2 = {2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 15, 150, 150, 150, 150, 8, 8, 8};
        System.out.println(solution.minIncrementForUnique(test2) == 163);
    }

    /**
     * LeetCode №945. Minimum Increment to Make Array Unique.
     * <p>
     * Complexity = O(NlogN + N)
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @return - the minimum number of increments to make every value in nums unique.
     */
    public int minIncrementForUnique(int[] nums) {
        NavigableMap<Integer, Integer> ordered = new TreeMap<>();
        for (int number : nums) {
            ordered.put(number, ordered.getOrDefault(number, 0) + 1);
        }

        int numberOfIncrements = 0;

        for (Map.Entry<Integer, Integer> entry : ordered.entrySet()) {
            if (entry.getValue() > 1) {
                int curNumber = entry.getKey();
                int curCount = entry.getValue();

                int nextNumber = ordered.higherKey(curNumber) != null ? ordered.higherKey(curNumber) : Integer.MAX_VALUE;
                int diff = nextNumber - curNumber;

                numberOfIncrements += arithmeticProgression(Math.min(diff, curCount) - 1);

                if (curCount > diff) {
                    ordered.put(nextNumber, ordered.get(nextNumber) + curCount - diff);
                    numberOfIncrements += (curCount - diff) * diff;
                }
            }
        }

        return numberOfIncrements;
    }

    private int arithmeticProgression(int number) {
        return number * (number + 1) / 2;
    }
}
