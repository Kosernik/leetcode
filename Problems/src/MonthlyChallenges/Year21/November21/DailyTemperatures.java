package MonthlyChallenges.Year21.November21;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {
    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();

        int[] test0temps = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(solution.dailyTemperatures(test0temps)));
    }

    /**
     * LeetCode #739. Daily Temperatures.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param temperatures - an array of temperatures.
     * @return - an array answer such that answer[i] is the number of days you have to wait after the i-th day to get a
     * warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Pair> stack = new ArrayDeque<>();

        stack.push(new Pair(temperatures[temperatures.length - 1], temperatures.length - 1));

        for (int i = temperatures.length - 2; i >= 0; i--) {
            int curTemp = temperatures[i];
            while (!stack.isEmpty() && stack.peek().temperature <= curTemp) stack.pop();

            if (stack.isEmpty()) {
                answer[i] = 0;
            } else {
                answer[i] = stack.peek().index - i;
            }

            stack.push(new Pair(curTemp, i));
        }

        return answer;
    }

    static class Pair {
        int temperature;
        int index;

        public Pair(int temperature, int index) {
            this.temperature = temperature;
            this.index = index;
        }
    }
}
