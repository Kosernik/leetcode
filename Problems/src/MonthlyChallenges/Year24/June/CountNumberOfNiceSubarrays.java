package MonthlyChallenges.Year24.June;

import java.util.ArrayDeque;
import java.util.Deque;

public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        CountNumberOfNiceSubarrays solution = new CountNumberOfNiceSubarrays();

        int[] testNums0 = {1, 1, 2, 1, 1};
        int testK0 = 3;
        System.out.println(solution.numberOfSubarrays(testNums0, testK0) == 2);

        int[] testNums2 = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int testK2 = 2;
        System.out.println(solution.numberOfSubarrays(testNums2, testK2) == 16);
    }


    /**
     * LeetCode №1248. Count Number of Nice Subarrays.
     * <p>
     * Complexity - O(N)
     * Memory - O(K)
     *
     * @param nums - an array of positive integers.
     * @param k    - a positive integer.
     * @return - the number of nice subarrays.
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int numberOfNiceSubarrays = 0;

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(-1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                if (queue.size() > k) {
                    int prevIdx = queue.removeFirst();
                    int left = queue.peekFirst() - prevIdx - 1;
                    int right = i - queue.peekLast() - 1;

                    numberOfNiceSubarrays += left + right + left * right + 1;
                }
                queue.addLast(i);
            }
        }

        if (queue.size() > k) {
            int prevIdx = queue.removeFirst();
            int left = queue.peekFirst() - prevIdx - 1;
            int right = nums.length - queue.peekLast() - 1;

            numberOfNiceSubarrays += left + right + left * right + 1;
        }

        return numberOfNiceSubarrays;
    }
}
