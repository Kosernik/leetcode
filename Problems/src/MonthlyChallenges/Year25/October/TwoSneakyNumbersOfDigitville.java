package MonthlyChallenges.Year25.October;

import java.util.Arrays;

public class TwoSneakyNumbersOfDigitville {
    public static void main(String[] args) {
        TwoSneakyNumbersOfDigitville solution = new TwoSneakyNumbersOfDigitville();

        int[] nums0 = {0, 1, 1, 0};
        int[] result0 = {0, 1};
        System.out.print(Arrays.toString(solution.getSneakyNumbers(nums0)) + "\t");
        System.out.println(Arrays.toString(result0));

        System.out.println();
        int[] nums1 = {0, 3, 2, 1, 3, 2};
        int[] result1 = {2, 3};
        System.out.print(Arrays.toString(solution.getSneakyNumbers(nums1)) + "\t");
        System.out.println(Arrays.toString(result1));

        System.out.println();
        int[] nums2 = {7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2};
        int[] result2 = {4, 5};
        System.out.print(Arrays.toString(solution.getSneakyNumbers(nums2)) + "\t");
        System.out.println(Arrays.toString(result2));
    }

    /**
     * LeetCode №3289. The Two Sneaky Numbers of Digitville.
     * <p>
     * Complexity - O(N), N = nums.length.
     * Memory - O(N)
     *
     * @param nums - an array of integers in the range [0, N-3]
     * @return - an array of two integers that appear exactly two times in nums.
     */
    public int[] getSneakyNumbers(int[] nums) {
        int[] result = new int[]{-1, -1};

        boolean[] seen = new boolean[nums.length - 2];

        for (int number : nums) {
            if (seen[number]) {
                if (result[0] == -1) {
                    result[0] = number;
                } else {
                    result[1] = number;
                    return result;
                }
            }

            seen[number] = true;
        }

        return result;
    }
}
