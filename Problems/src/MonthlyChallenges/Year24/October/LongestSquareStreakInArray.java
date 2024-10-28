package MonthlyChallenges.Year24.October;

import java.util.Arrays;

public class LongestSquareStreakInArray {
    public static void main(String[] args) {
        LongestSquareStreakInArray solution = new LongestSquareStreakInArray();

        int[] test1 = {2, 3, 5, 6, 7};
        System.out.println(solution.longestSquareStreak(test1) == -1);
    }

    /**
     * LeetCode №2501. Longest Square Streak in an Array.
     * <p>
     * Complexity - O(NlogN + N)
     * Memory - O(N)
     *
     * @param nums - an array of positive integers.
     * @return - the length of the longest square streak in nums, or -1 if there is no square streak.
     */
    public int longestSquareStreak(int[] nums) {
        int result = 0;

        Arrays.sort(nums);
        boolean[] computed = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (computed[i]) continue;

            int number = nums[i];
            int length = 1;

            int square = number * number;
            if (square < number) break;

            int idx = Arrays.binarySearch(nums, square);
            while (idx >= 0) {
                length++;
                computed[idx] = true;

                square *= square;
                if (square < number) break;
                idx = Arrays.binarySearch(nums, square);
            }

            result = Math.max(result, length);
        }

        return result >= 2 ? result : -1;
    }
}
