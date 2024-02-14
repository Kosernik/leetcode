package MonthlyChallenges.Year24.February;

import java.util.ArrayDeque;
import java.util.Deque;

public class RearrangeArrayElementsBySign {

    /**
     * LeetCode №2149. Rearrange Array Elements by Sign.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of positive and negative integers. nums.length is even. nums consists of equal number of
     *             positive and negative integers.
     * @return - rearranged array.
     */
    public int[] rearrangeArray(int[] nums) {
        Deque<Integer> positive = new ArrayDeque<>();
        Deque<Integer> negative = new ArrayDeque<>();
        for (int number : nums) {
            if (number > 0) {
                positive.offer(number);
            } else {
                negative.offer(number);
            }
        }

        int[] result = new int[nums.length];
        boolean pos = true;

        for (int i = 0; i < result.length; i++) {
            int number;
            if (pos) {
                number = positive.poll();
            } else {
                number = negative.poll();
            }
            result[i] = number;
            pos = !pos;
        }

        return result;
    }
}
