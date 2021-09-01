package MonthlyChallenges.September21;

import java.util.HashSet;
import java.util.Set;

public class ArrayNesting {
    /**
     * LeetCode #565. Array Nesting.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - a permutation of the numbers in the range [0, n - 1], n = nums.length.
     * @return - the longest length of a set s[k] = {nums[k], nums[nums[k]], nums[nums[nums[k]]], ... }.
     */
    public int arrayNesting(int[] nums) {
        int maxLength = 0;
        Set<Integer> visited = new HashSet<>();

        for (int number : nums) {
            if (!visited.contains(number)) {
                int curLength = 0;
                int curNumber = number;

                while (true) {
                    if (!visited.add(curNumber)) {
                        break;
                    } else {
                        visited.add(curNumber);
                        curLength++;
                        curNumber = nums[curNumber];
                    }
                }

                maxLength = Math.max(maxLength, curLength);
            }
        }

        return maxLength;
    }
}
