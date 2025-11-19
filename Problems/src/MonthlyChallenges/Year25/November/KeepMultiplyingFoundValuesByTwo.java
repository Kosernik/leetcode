package MonthlyChallenges.Year25.November;

import java.util.HashSet;
import java.util.Set;

public class KeepMultiplyingFoundValuesByTwo {

    /**
     * LeetCode №2154. Keep Multiplying Found Values by Two.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums     - an array of positive integers.
     * @param original - a positive integer.
     * @return - the final value of original.
     */
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> numbers = new HashSet<>();

        for (int number : nums) numbers.add(number);

        while (numbers.contains(original)) {
            original *= 2;
        }

        return original;
    }
}
