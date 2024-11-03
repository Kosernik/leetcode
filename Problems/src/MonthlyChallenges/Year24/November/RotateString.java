package MonthlyChallenges.Year24.November;

public class RotateString {

    /**
     * LeetCode №796. Rotate String.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s    - a string.
     * @param goal - a string.
     * @return - true if and only if "s" can become "goal" after some number of shifts on "s".
     */
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        return rotateString(s.toCharArray(), goal.toCharArray());
    }

    public boolean rotateString(char[] s, char[] goal) {
        int length = s.length;
        for (int i = 0; i < length; i++) {
            if (goal[0] == s[i]) {
                int sIdx = i;
                int gIdx = 0;

                while (gIdx < length && goal[gIdx] == s[sIdx]) {
                    gIdx++;
                    sIdx = (sIdx + 1) % length;
                }

                if (gIdx == length) return true;
            }
        }

        return false;
    }
}
