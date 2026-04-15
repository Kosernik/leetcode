package MonthlyChallenges.Year26.April;

public class ShortestDistanceToTargetStringInCircularArray {

    /**
     * LeetCode №2515. Shortest Distance to Target String in a Circular Array.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param words      - a string of words.
     * @param target     - a string.
     * @param startIndex - the starting position.
     * @return - the shortest distance needed to reach the string target in a circular array. If the string target does
     * not exist in words, return -1.
     */
    public int closestTarget(String[] words, String target, int startIndex) {
        int result = Integer.MAX_VALUE;

        int length = words.length;
        for (int i = 0; i < length; i++) {
            if (words[i].equals(target)) {
                int moveStrait = Math.abs(startIndex - i);
                int moveAround = length - moveStrait;

                result = Math.min(result, Math.min(moveAround, moveStrait));
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
