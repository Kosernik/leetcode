package MonthlyChallenges.Year25.November;

public class MaximumNumberOfOperationsToMoveOnesToEnd {

    /**
     * LeetCode №3228. Maximum Number of Operations to Move Ones to the End.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string of '0' and '1'.
     * @return - the maximum number of operations to move all 1-s to the end of s.
     */
    public int maxOperations(String s) {
        int moves = 0;
        int onesToMove = 0;

        int idx = 0;

        while (idx < s.length()) {
            char ch = s.charAt(idx);

            if (ch == '1') {
                onesToMove++;
                idx++;
                continue;
            }

            do {
                idx++;
            } while (idx < s.length() && s.charAt(idx) == '0');
            moves += onesToMove;
        }

        return moves;
    }
}
