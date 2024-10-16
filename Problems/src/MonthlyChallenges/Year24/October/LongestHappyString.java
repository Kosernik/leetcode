package MonthlyChallenges.Year24.October;

import java.util.PriorityQueue;

public class LongestHappyString {
    public static void main(String[] args) {
        LongestHappyString solution = new LongestHappyString();
    }


    /**
     * LeetCode №1405. Longest Happy String.
     * <p>
     * Complexity - O(a+b+c)
     * Memory - O(1)
     *
     * @param a - the maximum number of 'a' in a resulting string.
     * @param b - the maximum number of 'b' in a resulting string.
     * @param c - the maximum number of 'c' in a resulting string.
     * @return - the longest possible happy string.
     */
    public String longestDiverseString(int a, int b, int c) {
        if (a == 0 && b == 0 && c == 0) return "";

        char[] letters = {'a', 'b', 'c'};

        PriorityQueue<Integer[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(y[0], x[0]));
        if (a > 0) pq.offer(new Integer[]{a, 0});
        if (b > 0) pq.offer(new Integer[]{b, 1});
        if (c > 0) pq.offer(new Integer[]{c, 2});

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {
            Integer[] top = pq.poll();

            char letter = letters[top[1]];

            if (result.length() >= 2 &&
                    result.charAt(result.length() - 1) == letter &&
                    result.charAt(result.length() - 2) == letter) {
                if (pq.isEmpty()) break;

                Integer[] preTop = pq.poll();
                result.append(letters[preTop[1]]);
                preTop[0]--;

                if (preTop[0] > 0) pq.offer(preTop);
            } else {
                top[0]--;
                result.append(letter);
            }

            if (top[0] > 0) pq.offer(top);
        }

        return result.toString();
    }
}
