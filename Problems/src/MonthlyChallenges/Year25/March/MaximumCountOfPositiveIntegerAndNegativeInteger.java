package MonthlyChallenges.Year25.March;

public class MaximumCountOfPositiveIntegerAndNegativeInteger {
    public static void main(String[] args) {
        MaximumCountOfPositiveIntegerAndNegativeInteger solution = new MaximumCountOfPositiveIntegerAndNegativeInteger();


        int[] test0 = {0, 0, 0, 0, 1, 2, 3, 4, 5, 6};
        int result0 = 6;
        System.out.println(solution.maximumCount(test0) == result0);

        int[] test1 = {-6, -5, -4, -3, -2, -1, 0, 0, 0, 0, 0};
        int result1 = 6;
        System.out.println(solution.maximumCount(test1) == result1);

        int[] test2 = {-4, -3, -2, -1, 1, 2, 3, 4, 5};
        int result2 = 5;
        System.out.println(solution.maximumCount(test2) == result2);
    }

    /**
     * LeetCode №2529. Maximum Count of Positive Integer and Negative Integer.
     * <p>
     * Complexity - O(logN)
     * Memory - O(1)
     *
     * @param nums - an array of integers sorted in non-decreasing order.
     * @return - the maximum between the number of positive integers and the number of negative integers.
     */
    public int maximumCount(int[] nums) {
        if (nums[0] > 0 || nums[nums.length - 1] < 0) return nums.length;
        else if (nums[0] == 0 && nums[nums.length - 1] == 0) return 0;


        int negativeIdx = binarySearch(-1, nums);
        int negativeLength = negativeIdx + 1;
        int positiveIdx = binarySearch(0, nums);
        int positiveLength = nums.length - positiveIdx - 1;

        return Math.max(negativeLength, positiveLength);
    }

    private int binarySearch(int target, int[] numbers) {
        int left = 0, right = numbers.length, middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            if (numbers[middle] > target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return right - 1;
    }
}
