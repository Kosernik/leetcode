package MonthlyChallenges.Year23.October;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumNumberOfOperationsToMakeArrayContinuous {
    public static void main(String[] args) {
        MinimumNumberOfOperationsToMakeArrayContinuous solution = new MinimumNumberOfOperationsToMakeArrayContinuous();

        int[] test = {8, 5, 9, 9, 8, 4};
        System.out.println(solution.minOperations(test) == 2);
    }

    /**
     * LeetCode #2009. Minimum Number of Operations to Make Array Continuous.
     *
     * @param nums - an array of integers.
     * @return - the minimum number of operations to make nums continuous.
     */
    public int minOperations(int[] nums) {
        int length = nums.length;
        int[] unique = inputWithoutDuplicates(nums);
        Arrays.sort(unique);

        int minOps = length - 1;

        for (int i = 0; i < unique.length; i++) {
            int curNum = unique[i];
            int rightNum = curNum + length - 1;
            int rightIdx = binSearchRightmost(rightNum, unique);

            int curOps = length - (rightIdx - i + 1);
            minOps = Math.min(minOps, curOps);
        }

        return minOps;
    }

    private int[] inputWithoutDuplicates(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        for (int number : nums) uniques.add(number);

        int[] result = new int[uniques.size()];
        int idx = 0;
        for (int number : uniques) {
            result[idx] = number;
            idx++;
        }
        return result;
    }

    private int binSearchRightmost(int target, int[] nums) {
        int left = 0, right = nums.length - 1, middle;

        while (left < right) {
            middle = right - (right - left) / 2;

            if (nums[middle] <= target) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }
}
