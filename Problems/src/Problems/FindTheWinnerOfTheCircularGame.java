package Problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindTheWinnerOfTheCircularGame {
    public static void main(String[] args) {
        FindTheWinnerOfTheCircularGame solution = new FindTheWinnerOfTheCircularGame();

        System.out.println(solution.findTheWinner(5, 2));
    }

    /**
     * LeetCode #1823. Find the Winner of the Circular Game.
     *
     * Complexity - O(n*k)
     * Memory - O(n)
     *
     * @param n - a positive integer.
     * @param k - a positive integer.
     * @return - the winner of the game.
     */
    public int findTheWinner(int n, int k) {
        if (k == 1) return n;

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) queue.offer(i);

        while (queue.size() > 1) {
            for (int player = 1; player < k; player++) {
                int curP = queue.remove();
                queue.offer(curP);
            }

            queue.remove();
        }

        return queue.element();
    }
}
