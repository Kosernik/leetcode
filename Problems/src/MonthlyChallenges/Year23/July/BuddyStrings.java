package MonthlyChallenges.Year23.July;

public class BuddyStrings {

    /**
     * LeetCode #859. Buddy Strings.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s    - a string of lowercase english letters.
     * @param goal - a string of lowercase english letters.
     * @return - True - if it is possible to make 's' equal 'goal' after swapping exactly two letters, false - otherwise.
     */
    public boolean buddyStrings(String s, String goal) {
        if (s.length() == 1 || s.length() != goal.length()) return false;

        int mismatch = 0;
        char sChar = ' ';
        char goalChar = ' ';

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (mismatch == 0) {
                    sChar = s.charAt(i);
                    goalChar = goal.charAt(i);
                } else if (mismatch == 1) {
                    if (sChar != goal.charAt(i) || goalChar != s.charAt(i)) {
                        return false;
                    }
                } else {
                    return false;
                }
                mismatch++;
            }
        }

        if (mismatch == 0) {
            return equalStringsSwap(s);
        } else {
            return mismatch != 1;
        }
    }

    private boolean equalStringsSwap(String s) {
        int[] count = new int[26];

        for (char letter : s.toCharArray()) {
            count[letter - 'a']++;
            if (count[letter - 'a'] == 2) return true;
        }

        return false;
    }
}
