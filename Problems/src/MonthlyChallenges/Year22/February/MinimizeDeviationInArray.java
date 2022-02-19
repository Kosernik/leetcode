package MonthlyChallenges.Year22.February;

import java.util.PriorityQueue;

public class MinimizeDeviationInArray {

    /**
     * LeetCode #1675. Minimize Deviation in Array.
     *
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param nums - an array of positive integers.
     * @return - the minimum deviation.
     */
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
                minValue = Math.min(minValue, currNumber/2);
                pq.add(-currNumber/2);
            }
        }

        return result;
    }
}
