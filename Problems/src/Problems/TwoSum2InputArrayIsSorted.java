package Problems;

public class TwoSum2InputArrayIsSorted {

    /**
     * LeetCode #167. Two Sum II - Input Array Is Sorted.
     *
     * Complexity - O(N)
     * Memory O(N)
     *
     * @param numbers - a 1-indexed array of integers that is already sorted in non-decreasing order.
     * @param target - required sum.
     * @return - an array of indices of two numbers such that they add up to a "target" number.
     *           1 <= index1 < index2 <= numbers.length. "numbers" contains exactly one solution.
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0; int right = numbers.length-1;

        while (true) {
            int curSum = numbers[left] + numbers[right];
            if (curSum == target) return new int[] {left+1, right+1};
            else if (curSum < target) left++;
            else right--;
        }
    }
}
