package MonthlyChallenges.Year25.November;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MinimumOperationsToConvertAllElementsToZero {

    /**
     * LeetCode №3542. Minimum Operations to Convert All Elements to Zero.
     * <p>
     * An operation:
     * * select a subarray [i, j] (where 0 <= i <= j < n) and set all occurrences of the minimum non-negative integer
     * * in that subarray to 0.
     *
     * @param nums - an array of non-negative integers.
     * @return - the minimum number of operations required to make all elements in the array 0.
     */
    public int minOperations(int[] nums) {
        int result = 0;

        Deque<Integer> monoStack = new ArrayDeque<>();

        for (int number : nums) {
            while (!monoStack.isEmpty() && monoStack.peekLast() > number) {
                monoStack.removeLast();
            }

            if (number == 0) continue;

            if (monoStack.isEmpty() || monoStack.peekLast() < number) {
                result++;
                monoStack.addLast(number);
            }
        }

        return result;
    }

    public int minOperationsTLE(int[] nums) {
        int minValue = Integer.MAX_VALUE;
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];

            if (number == 0) {
                if (minValue == Integer.MAX_VALUE) continue;

                makeZeroes(nums, indices);
                return 1 + minOperationsTLE(nums);
            }

            if (number < minValue) {
                indices.clear();
                indices.add(i);
                minValue = number;
            } else if (number == minValue) {
                indices.add(i);
            }
        }

        if (minValue == Integer.MAX_VALUE) return 0;

        makeZeroes(nums, indices);
        return 1 + minOperationsTLE(nums);
    }

    private void makeZeroes(int[] number, List<Integer> indices) {
        for (int idx : indices) number[idx] = 0;
    }
}
