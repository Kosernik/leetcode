package MonthlyChallenges.Year25.April;

import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest {
    public static void main(String[] args) {
        RabbitsInForest solution = new RabbitsInForest();

        int[] answers1 = {1, 1, 2, 2, 2};
        int result1 = 5;
        System.out.println(solution.numRabbits(answers1) == result1);
    }

    /**
     * LeetCode №781. Rabbits in Forest.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param answers - an array of positive integers.
     * @return - the minimum number of rabbits that could be in the forest.
     */
    public int numRabbits(int[] answers) {
        int result = 0;

        Map<Integer, Integer> counts = new HashMap<>();

        for (int number : answers) {
            int curCount = counts.getOrDefault(number, 0) + 1;

            if (curCount == (number + 1)) {
                result += number + 1;
                counts.remove(number);
            } else {
                counts.put(number, curCount);
            }
        }

        for (Integer number : counts.keySet()) {
            result += number + 1;
        }

        return result;
    }
}
