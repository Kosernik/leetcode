package MonthlyChallenges.Year22.April;

import java.util.ArrayDeque;

public class BaseballGame {

    /**
     * LeetCode #682. Baseball Game.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param ops - an array of operations.
     * @return - the sum of all the scores.
     */
    public int calPoints(String[] ops) {
        ArrayDeque<Integer> scores = new ArrayDeque<>();

        for (String operation : ops) {
            if (operation.equals("+")) {
                Integer prev = scores.removeLast();
                Integer current = scores.peekLast() + prev;
                scores.offerLast(prev);
                scores.offerLast(current);
            } else if (operation.equals("D")) {
                Integer current = scores.peekLast() * 2;
                scores.offerLast(current);
            } else if (operation.equals("C")) {
                scores.removeLast();
            } else {
                scores.offerLast(Integer.parseInt(operation));
            }
        }

        int result = 0;

        while (!scores.isEmpty()) {
            result += scores.removeLast();
        }

        return result;
    }
}
