package MonthlyChallenges.Year24.December;

import java.util.PriorityQueue;

public class ConstructStringWithRepeatLimit {
    public static void main(String[] args) {
        ConstructStringWithRepeatLimit solution = new ConstructStringWithRepeatLimit();

        String testS0 = "cczazcc";
        int testRL0 = 3;
        System.out.println(solution.repeatLimitedString(testS0, testRL0));

    }

    /**
     * LeetCode №2182. Construct String With Repeat Limit.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s           - a string of lowercase english letters.
     * @param repeatLimit - the maximum number a letter can appear in a row.
     * @return - the lexicographically largest repeatLimitedString possible.
     */
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] counts = new int[26];
        for (char ch : s.toCharArray()) {
            counts[ch - 'a']++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (counts[ch - 'a'] == 0) continue;
            pq.offer(new Pair(ch, counts[ch - 'a']));
        }

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();

            if (!result.isEmpty() && result.charAt(result.length() - 1) == pair.letter) {
                if (pq.isEmpty()) {
                    break;
                } else {
                    Pair nextPair = pq.poll();
                    pq.offer(pair);

                    pair = nextPair;

                    result.append(pair.letter);

                    pair.count--;

                    if (pair.count > 0) {
                        pq.offer(pair);
                    }
                }
            } else {
                int curCount = Math.min(pair.count, repeatLimit);

                result.append(String.valueOf(pair.letter).repeat(curCount));

                pair.count -= curCount;

                if (pair.count > 0) {
                    pq.offer(pair);
                }
            }
        }

        return result.toString();
    }

    class Pair implements Comparable<Pair> {
        char letter;
        int count;

        Pair(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }

        @Override
        public int compareTo(Pair o) {
            return Character.compare(o.letter, this.letter);
        }
    }
}
