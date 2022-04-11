package Problems;

public class TwoSum2InputArrayIsSorted {

    /**
     * LeetCode #167. Two Sum II - Input Array Is Sorted.
     *
     * Complexity - O(N)
     * Memory O(1)
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


    /**
     * LeetCode #167. Two Sum II - Input Array Is Sorted.
     *
     * Complexity - O(NlogN)
     * Memory O(1)
     *
     * @param numbers - a 1-indexed array of integers that is already sorted in non-decreasing order.
     * @param target - required sum.
     * @return - an array of indices of two numbers such that they add up to a "target" number.
     *           1 <= index1 < index2 <= numbers.length. "numbers" contains exactly one solution.
     */
    public int[] twoSumBinarySearch(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int remainder = target - numbers[i];

            if (numbers[i] == remainder) {
                if (numbers[i+1] == remainder) {
                    return new int[] {i+1, i+2};
                }
                continue;
            }

            int idx = binarySearch(numbers, remainder);

            if (idx != -1) {
                return new int[] {i+1, idx+1};
            }
        }

        return null;
    }

    private int binarySearch(int[] numbers , int target) {
        int left = 0, right = numbers.length-1, middle;

        while (left <= right) {
            middle = (right - left) / 2 + left;

            if (numbers[middle] == target) {
                return middle;
            } else if (numbers[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }
}
