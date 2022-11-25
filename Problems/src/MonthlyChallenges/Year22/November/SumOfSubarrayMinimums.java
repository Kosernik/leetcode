package MonthlyChallenges.Year22.November;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfSubarrayMinimums {
    public static void main(String[] args) {
        SumOfSubarrayMinimums solution = new SumOfSubarrayMinimums();


        int[] test2 = {11, 81, 94, 43, 3};
        System.out.println(solution.sumSubarrayMins(test2) == 444);

        int[] test3 = {3, 1, 3, 2, 4, 2};
        System.out.println(solution.sumSubarrayMins(test3) == 36);
    }


    /**
     * LeetCode #907. Sum of Subarray Minimums.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param arr - an array of positive integers.
     * @return - the sum of minimum values for each subarray. Result is modulo 1_000_000_007.
     */
    public int sumSubarrayMins(int[] arr) {
        int MODULO = 1_000_000_007;
        int length = arr.length;
        int result = 0;

        Deque<int[]> monoStack = new ArrayDeque<>();
        int[][] prevMinNext = new int[length][2];

        for (int i = 0; i < length; i++) {
            prevMinNext[i][0] = i + 1;
            prevMinNext[i][1] = length - i;
        }

        for (int i = 0; i < length; i++) {
            while (!monoStack.isEmpty() && monoStack.peek()[0] > arr[i]) {
                prevMinNext[monoStack.peek()[1]][1] = i - monoStack.peek()[1];
                monoStack.pop();
            }

            prevMinNext[i][0] = monoStack.isEmpty() ? i + 1 : i - monoStack.peek()[1];
            monoStack.push(new int[]{arr[i], i});
        }

        for (int i = 0; i < length; i++) {
            result = (int) ((result + ((long) arr[i]) * prevMinNext[i][0] * prevMinNext[i][1]) % MODULO);
        }

        return result;
    }
}