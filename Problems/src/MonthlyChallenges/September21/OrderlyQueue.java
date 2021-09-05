package MonthlyChallenges.September21;

import java.util.Arrays;

public class OrderlyQueue {
    public static void main(String[] args) {
        OrderlyQueue solution = new OrderlyQueue();

        String test0 = "baaca";
        System.out.println(solution.orderlyQueue(test0, 1));
    }

    /**
     * LeetCode #899. Orderly Queue.
     *
     * Complexity - O(NlogN) || O(N^2)
     * Memory - O(N)
     *
     * @param s - input string.
     * @param k - the size of the window to choose a letter.
     * @return - the lexicographically smallest string.
     */
    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] letters = s.toCharArray();
            Arrays.sort(letters);
            return new String(letters);
        } else {
            String result = s;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) <= result.charAt(0)) {
                    String candidate = getString(s, i);
                    if (result.compareTo(candidate) > 0) {
                        result = candidate;
                    }
                }
            }

            return result;
        }
    }

    private String getString(String s, int index) {
        return s.substring(index).concat(s.substring(0, index));
    }
}
