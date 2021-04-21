package Contests;

public class MinimumDeletionsToMakeStringBalanced {
    /**
     * LeetCode #1653.
     *
     * Complexity O(N)
     * Memory - O(N)
     *
     * @param s - a string of characters 'a' and 'b'
     * @return - minimum number of deletions to make "s" balanced.
     */
    public int minimumDeletions(String s) {
        int[] Aafter = new int[s.length()];
        int[] Bbefore = new int[s.length()];

        for (int i = 0, b = 0; i < s.length(); i++) {
            Bbefore[i] = b;
            if (s.charAt(i) == 'b') b++;
        }
        for (int i = s.length()-1, a = 0; i >= 0; i--) {
            Aafter[i] = a;
            if (s.charAt(i) == 'a') a++;
        }

        int result = s.length();

        for (int i = 0; i < s.length(); i++) {
            result = Math.min(result, Aafter[i] + Bbefore[i]);
        }

        return result;
    }
}
