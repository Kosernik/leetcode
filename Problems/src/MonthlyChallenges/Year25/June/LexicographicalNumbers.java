package MonthlyChallenges.Year25.June;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {

    /**
     * LeetCode №386. Lexicographical Numbers.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param n - the maximum allowed number.
     * @return - all the numbers in the range [1, n] sorted in lexicographical order.
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            dfs(i, n, result);
        }

        return result;
    }

    private void dfs(int number, int max, List<Integer> numbers) {
        if (number > max) return;

        numbers.add(number);

        for (int i = 0; i <= 9; i++) {
            dfs(number * 10 + i, max, numbers);
        }
    }
}
