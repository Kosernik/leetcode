package Problems;

public class PermutationInString {

    /**
     * LeetCode #567. Permutation in String.
     *
     * Complexity - O(N), N - s2.length().
     * Memory - O(M), M - s1.length().
     *
     * @param s1 - a string of lowercase English letters.
     * @param s2 - a string of lowercase English letters.
     * @return - True - if any permutation of "s1" is a substring in "s2". False - otherwise.
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] countS1 = countLetters(s1);
        int[] countS2 = countLetters(s2.substring(0, s1.length()));
        if (equalCounts(countS1, countS2)) return true;

        for (int i = 1, len = s1.length(); len < s2.length(); i++, len++) {
            countS2[s2.charAt(i-1)-'a']--;
            countS2[s2.charAt(len)-'a']++;
            if (equalCounts(countS1, countS2)) return true;
        }

        return false;
    }

    private boolean equalCounts(int[] c1, int[] c2) {
        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) return false;
        }

        return true;
    }

    private int[] countLetters(String word) {
        int[] count = new int[26];

        for (char ch : word.toCharArray()) {
            count[ch - 'a']++;
        }

        return count;
    }
}
