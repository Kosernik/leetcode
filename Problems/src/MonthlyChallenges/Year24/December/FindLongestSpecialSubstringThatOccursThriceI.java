package MonthlyChallenges.Year24.December;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindLongestSpecialSubstringThatOccursThriceI {

    private final int OCCURRENCES = 3;

    /**
     * LeetCode №2981. Find Longest Special Substring That Occurs Thrice I.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     * <p>
     * A string is called special if it is made up of only a single character.
     *
     * @param s - a string of lowercase english letters.
     * @return - the length of the longest special substring of s which occurs at least thrice, or -1 if no special
     * substring occurs at least thrice.
     */
    public int maximumLength(String s) {
        List<PriorityQueue<Integer>> counts = new ArrayList<>();
        for (int i = 0; i < 26; i++) counts.add(new PriorityQueue<>());

        char[] letters = s.toCharArray();
        char prevLetter = letters[0];
        int count = 1;

        for (int i = 1; i < letters.length; i++) {
            if (letters[i] != prevLetter) {
                updateCounts(prevLetter, count, counts);

                prevLetter = letters[i];
                count = 1;
            } else {
                count++;
            }
        }

        updateCounts(prevLetter, count, counts);

        int result = -1;

        for (PriorityQueue<Integer> letterCount : counts) {
            result = Math.max(result, getMaxLengthOfThree(letterCount));
        }

        return result;
    }

    private int getMaxLengthOfThree(PriorityQueue<Integer> letterCount) {
        int result = -1;

        if (letterCount.size() == 1) {
            result = letterCount.poll() - 2;
        } else if (letterCount.size() == 2) {
            int smallest = letterCount.poll();
            int biggest = letterCount.poll();

            int pickBiggestOnly = biggest - 2;
            int pickSmallest = Math.min(smallest, biggest - 1);

            result = Math.max(pickSmallest, pickBiggestOnly);
        } else if (letterCount.size() == 3) {
            int smallest = letterCount.poll();
            int middle = letterCount.poll();
            int biggest = letterCount.poll();

            int pickMiddle = Math.min(middle, biggest - 1);
            int pickBiggestOnly = biggest - 2;

            result = Math.max(smallest, Math.max(pickMiddle, pickBiggestOnly));
        }

        return result <= 0 ? -1 : result;
    }

    private void updateCounts(char letter, int count, List<PriorityQueue<Integer>> counts) {
        PriorityQueue<Integer> pq = counts.get(letter - 'a');
        pq.offer(count);
        if (pq.size() > OCCURRENCES) pq.poll();
    }
}
