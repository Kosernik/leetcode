package MonthlyChallenges.Year23.December;

import java.util.Arrays;

public class ElementAppearingMoreThan25PercentInSortedArray {
    public static void main(String[] args) {
        ElementAppearingMoreThan25PercentInSortedArray solution = new ElementAppearingMoreThan25PercentInSortedArray();

        int[] test = {1, 2, 3, 4, 4};
        System.out.println(Arrays.toString(test));
        System.out.println(solution.findSpecialInteger(test));

        int[] test1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 12, 12, 12};
        System.out.println(Arrays.toString(test1));
        System.out.println(solution.findSpecialInteger(test1));

        int[] test2 = {1, 1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 12, 12, 12};
        System.out.println(Arrays.toString(test2));
        System.out.println(solution.findSpecialInteger(test2));
    }


    /**
     * LeetCode №1287. Element Appearing More Than 25% In Sorted Array.
     * <p>
     * Complexity - O(logN)
     * Memory - O(1)
     *
     * @param arr - an array of integers sorted in non-decreasing order.
     * @return - the element that occurs more than 25% of the time.
     */
    public int findSpecialInteger(int[] arr) {
        if (arr.length <= 2) return arr[0];

        int quarter = arr.length / 4;

        int firstThird = arr[arr.length / 4];
        int leftFT = binSearchLeftmost(firstThird, arr);
        int rightFT = binSearchRightmost(firstThird, arr);
        if ((rightFT - leftFT + 1) > quarter) {
            return firstThird;
        }

        int secondThird = arr[arr.length / 2];
        int leftST = binSearchLeftmost(secondThird, arr);
        int rightST = binSearchRightmost(secondThird, arr);
        if ((rightST - leftST + 1) > quarter) {
            return secondThird;
        }

        int thirdThird = arr[arr.length * 3 / 4];
        return thirdThird;
    }

    /**
     * @param target - an integer, arr always in arr.
     * @param arr    - a sorted array of integers.
     * @return - the left most index of target.
     */
    private int binSearchLeftmost(int target, int[] arr) {
        int left = 0, right = arr.length - 1, middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            if (arr[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }

    /**
     * @param target - an integer, arr always in arr.
     * @param arr    - a sorted array of integers.
     * @return - the right most index of target.
     */
    private int binSearchRightmost(int target, int[] arr) {
        int left = 0, right = arr.length - 1, middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            if (arr[middle] > target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return right - 1;
    }
}
