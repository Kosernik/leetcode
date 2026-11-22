package MonthlyChallenges.Year26.November;

public class CheckIfAllAAppearsBeforeAllB {

    /**
     * LeetCode №2124. Check if All A's Appears Before All B's.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string of 'a' and 'b'.
     * @return - true if every 'a' appears before every 'b' in the string. Otherwise, returns false.
     */
    public boolean checkString(String s) {
        boolean seenB = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                if (seenB) return false;
            } else {
                seenB = true;
            }
        }

        return true;
    }
}
