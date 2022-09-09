package MonthlyChallenges.Year22.September;

import java.util.ArrayDeque;
import java.util.Arrays;

public class NumberOfWeakCharactersInGame {

    /**
     * LeetCode #1996. The Number of Weak Characters in the Game.
     * <p>
     * Complexity - O(NlogN + N)
     * Memory - O(N)
     *
     * @param properties - a 2d array of positive integers.
     * @return - the number of weak characters.
     */
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        int[] monoStack = new int[properties.length];
        monoStack[monoStack.length - 1] = properties[properties.length - 1][1];
        ArrayDeque<Integer> indices = new ArrayDeque<>();

        for (int i = monoStack.length - 2; i >= 0; i--) {
            monoStack[i] = Math.max(monoStack[i + 1], properties[i][1]);
            if (properties[i][0] < properties[i + 1][0]) {
                indices.push(i + 1);
            }
        }

        int weakCharactersCount = 0;
        for (int i = 0; i < properties.length - 1; i++) {
            if (i > 0 && properties[i][0] > properties[i - 1][0]) {
                indices.pop();
            }
            if (indices.isEmpty()) break;

            if (monoStack[indices.peek()] > properties[i][1]) {
                weakCharactersCount++;
            }
        }

        return weakCharactersCount;
    }
}
