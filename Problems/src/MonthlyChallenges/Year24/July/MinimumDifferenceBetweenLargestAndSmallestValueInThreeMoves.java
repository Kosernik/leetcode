package MonthlyChallenges.Year24.July;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    public static void main(String[] args) {
        MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves solution = new MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves();

        int[] test1 = {1, 5, 0, 10, 14};
        System.out.println(solution.minDifference(test1) == 1);
    }

    /**
     * LeetCode №1509. Minimum Difference Between Largest and Smallest Value in Three Moves.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(1) + O(sorting memory)
     *
     * @param nums - an array of integers.
     * @return - the minimum difference between the largest and smallest value of nums after performing at most three
     * moves. In one move, you can choose one element of nums and change it to any value.
     */
    public int minDifferenceAlt(int[] nums) {
        Arrays.sort(nums);
        int minDifference = nums[nums.length - 1] - nums[0];
        if (nums.length <= 3) return 0;

        for (int i = 0; i <= 3; i++) {
            int curDiff = nums[nums.length - 1 - i] - nums[3 - i];
            minDifference = Math.min(minDifference, curDiff);
        }

        return minDifference;
    }

    /**
     * LeetCode №1509. Minimum Difference Between Largest and Smallest Value in Three Moves.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of integers.
     * @return - the minimum difference between the largest and smallest value of nums after performing at most three
     * moves. In one move, you can choose one element of nums and change it to any value.
     */
    public int minDifference(int[] nums) {
        if (nums.length <= 4) return 0;

        PriorityQueue<Integer> highest = new PriorityQueue<>();
        PriorityQueue<Integer> lowest = new PriorityQueue<>(Comparator.reverseOrder());

        for (int number : nums) {
            highest.offer(number);
            lowest.offer(number);
            if (highest.size() > 4) highest.poll();
            if (lowest.size() > 4) lowest.poll();
        }

        int minDiff = Integer.MAX_VALUE;

        int[] lowestNums = new int[4];
        for (int i = 0; i < 4; i++) {
            lowestNums[i] = lowest.poll();
        }

        for (int i = 0; i < 4; i++) {
            int curDiff = highest.poll() - lowestNums[3 - i];
            minDiff = Math.min(minDiff, curDiff);
        }

        return minDiff;
    }
}
