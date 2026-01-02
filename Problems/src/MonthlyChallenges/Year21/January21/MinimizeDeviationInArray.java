package MonthlyChallenges.Year21.January21;

import java.util.PriorityQueue;

public class MinimizeDeviationInArray {
    public static void main(String[] args) {
        MinimizeDeviationInArray solution = new MinimizeDeviationInArray();
        int[] test1 = {4, 1, 5, 20, 3};
        System.out.println(solution.minimumDeviation(test1));
    }

    // LeetCode #1675.
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int minValue = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;

        for (int number : nums) {
            if (number % 2 == 1) {
                number *= 2;
            }
            pq.add(-number);
            minValue = Math.min(minValue, number);
        }

        while (true) {
            int currNumber = -pq.poll();
            result = Math.min(result, currNumber - minValue);

            if (currNumber % 2 == 1) break;
            else {
                minValue = Math.min(minValue, currNumber / 2);
                pq.add(-currNumber / 2);
            }
        }

        return result;
    }
}
