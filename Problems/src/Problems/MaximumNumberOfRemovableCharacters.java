package Problems;

public class MaximumNumberOfRemovableCharacters {

    /**
     * LeetCode #1898. Maximum Number of Removable Characters.
     *
     * Complexity - O((N+M)*logP), N = s.length, M = p.length, P = removable.length.
     * Memory - O(N+M)
     *
     * @param s - A string of lowercase English letters.
     * @param p - A string of lowercase English letters.
     * @param removable - An array of indices of "s". The elements in removable are distinct.
     * @return - The maximum 'k' you can choose such that p is still a subsequence of s after the removals.
     */
    public int maximumRemovals(String s, String p, int[] removable) {
        if (removable.length == 0) return 0;

        int left = 0, right = removable.length, middle;

        while (left < right) {
            middle = right - (right - left) / 2;

            String candidate = removeChars(s, removable, middle);

            if (isSubsequence(candidate, p)) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }

    private String removeChars(String s, int[] removable, int k) {
        char[] letters = s.toCharArray();
        for (int i = 0; i < k; i++) {
            letters[removable[i]] = '*';
        }

        StringBuilder builder = new StringBuilder();
        for (char letter : letters) {
            if (letter != '*') builder.append(letter);
        }

        return builder.toString();
    }

    private boolean isSubsequence(String s, String p) {
        if (s.length() < p.length()) return false;
        else if (s.length() == p.length()) return s.equals(p);

        int idxP = 0;

        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();
        for (char c : sChar) {
            if (c == pChar[idxP]) {
                idxP++;
                if (idxP == p.length()) return true;
            }
        }

        return false;
    }
}
