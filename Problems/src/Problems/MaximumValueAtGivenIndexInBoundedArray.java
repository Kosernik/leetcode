package Problems;

public class MaximumValueAtGivenIndexInBoundedArray {

    /**
     * LeetCode #1802. Maximum Value at a Given Index in a Bounded Array.
     *
     * Complexity - O(1) (O(logN), N = Integer.MAX_VALUE))
     * Memory - O(1)
     *
     * @param n - the length of the target array.
     * @param index - the index of result element in the target array.
     * @param maxSum - the maximum sum of all elements in the target array.
     * @return - maximized element in the target array.
     */
    public int maxValue(int n, int index, int maxSum) {
        int numbersToTheRight = n - index - 1;

        int left = 0, right = Integer.MAX_VALUE, middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            long sum = getSum(middle, index, numbersToTheRight);

            if (sum > maxSum) {
                right = middle;
            } else {
                left = middle+1;
            }
        }

        return right-1;
    }

    private long getSum(int candidate, int numbersToTheLeft, int numbersToTheRight) {
        return getSideSum(candidate, numbersToTheLeft) + getSideSum(candidate, numbersToTheRight) + candidate;
    }

    private long getSideSum(int candidate, int numbersToTheSide) {
        if (numbersToTheSide == 0) return 0L;
        long sum = sumOfAllNumbers(candidate-1);
        if (numbersToTheSide > (candidate-1)) {
            return sum + (numbersToTheSide - candidate + 1);
        } else if (numbersToTheSide == (candidate-1)) {
            return sum;
        } else {
            int unusedNumbers = candidate - 1 - numbersToTheSide;
            long unusedNumbersSum = sumOfAllNumbers(unusedNumbers);
            return sum - unusedNumbersSum;
        }
    }

    private long sumOfAllNumbers(int number) {
        //  (n)*(n+1)/2 - Original
        return number * (number + 1L) / 2;
    }
}
