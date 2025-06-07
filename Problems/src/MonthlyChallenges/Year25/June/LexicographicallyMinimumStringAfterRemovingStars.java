package MonthlyChallenges.Year25.June;

import java.util.PriorityQueue;

public class LexicographicallyMinimumStringAfterRemovingStars {

    /**
     * LeetCode №3170. Lexicographically Minimum String After Removing Stars.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param s - a string of lowercase english letters and '*'.
     * @return - the lexicographically smallest resulting string after removing all '*' characters.
     */
    public String clearStars(String s) {
        //  int[] {charVal, charIdx}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0])
        );

        boolean[] removed = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char curCh = s.charAt(i);

            if (curCh == '*') {
                removed[i] = true;

                int[] toRemove = pq.poll();
                removed[toRemove[1]] = true;
            } else {
                pq.offer(new int[]{curCh - 'a', i});
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!removed[i]) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
