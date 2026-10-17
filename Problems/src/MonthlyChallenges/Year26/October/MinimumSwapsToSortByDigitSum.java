package MonthlyChallenges.Year26.October;

import java.util.Arrays;

public class MinimumSwapsToSortByDigitSum {
    public static void main(String[] args) {
        MinimumSwapsToSortByDigitSum solution = new MinimumSwapsToSortByDigitSum();

        int[][] nums = {
                {37, 100},
                {22, 14, 33, 7},
                {18, 43, 34, 16},
                {25, 43, 34, 16},
                {25, 34, 43, 16}
        };
        int[] results = {
                1,
                0,
                2,
                2,
                3
        };

        for (int i = 0; i < nums.length; i++) {
            int curRes = solution.minSwaps(nums[i]);
            if (curRes != results[i]) {
                System.out.println("Test " + (i + 1) + ", result: " + results[i] + ", got: " + curRes);
                System.out.println(Arrays.toString(nums[i]));
            }
        }
        System.out.println("Done!");
    }

    /**
     * LeetCode №3551. Minimum Swaps to Sort by Digit Sum.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     * <p>
     * Rearranged array is sorted in increasing order based on the sum of the digits of each number. If two numbers
     * have the same digit sum, the smaller number appears first in the sorted order.
     *
     * @param nums - an array of distinct positive integers.
     * @return - the minimum number of swaps required to rearrange nums into this sorted order.
     */
    public int minSwaps(int[] nums) {
        int length = nums.length;
        int[][] pairs = new int[length][3];

        for (int i = 0; i < length; i++) {
            pairs[i][0] = getSumOfDigits(nums[i]);
            pairs[i][1] = nums[i];
            pairs[i][2] = i;
        }

        Arrays.sort(pairs, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        int swaps = 0;

        for (int i = 0; i < length; i++) {
            if (pairs[i][0] == -1) continue;
            swaps += getCycleLength(i, pairs);
        }

        return swaps;
    }

    private int getCycleLength(int start, int[][] pairs) {
        int length = 0;

        int idx = start;

        while (pairs[idx][2] != start) {
            length++;
            idx = pairs[idx][2];
            pairs[idx][0] = -1;
        }

        return length;
    }

    private int getSumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
