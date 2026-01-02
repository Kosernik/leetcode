package MonthlyChallenges.Year21.April21;

import java.util.ArrayDeque;

public class RemoveAllAdjacentDuplicatesInStringII {
    /**
     * LeetCode #1209.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string of english lower case letters, 1 <= s.length <= 10^5.
     * @param k - 2 <= k <= 10^4
     * @return - a string "s" after removing all k-duplicates.
     */
    public String removeDuplicates(String s, int k) {
        ArrayDeque<Pair> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peekLast().ch == ch) {
                stack.peekLast().addCount();
                if (stack.peekLast().count == k) {
                    stack.removeLast();
                }
            } else {
                stack.offerLast(new Pair(ch));
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair pair = stack.removeFirst();
            builder.append(String.valueOf(pair.ch).repeat(Math.max(0, pair.count)));
        }

        return builder.toString();
    }

    private class Pair {
        char ch;
        int count;

        Pair(char ch) {
            this.ch = ch;
            this.count = 1;
        }

        void addCount() {
            this.count++;
        }
    }
}
