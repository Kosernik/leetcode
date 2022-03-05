package Problems;

public class CheckIfOneStringSwapCanMakeStringsEqual {

    /**
     * LeetCode #1790. Check if One String Swap Can Make Strings Equal.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s1 - a string of lowercase English letters.
     * @param s2 - a string of lowercase English letters. s1.length() == s2.length()
     * @return - True - if it is possible to make both strings equal by performing at most one string swap on exactly
     *           one of the strings. Otherwise, return false.
     */
    public boolean areAlmostEqual(String s1, String s2) {
        int[] countS1 = countLetters(s1);
        int[] countS2 = countLetters(s2);

        if (!compareWords(countS1, countS2)) return false;

        int numberOfDifferentPositions = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) numberOfDifferentPositions++;
        }

        return numberOfDifferentPositions == 2 || numberOfDifferentPositions == 0;
    }

    private int[] countLetters(String word) {
        int[] count = new int[26];

        for (char letter : word.toCharArray()) {
            count[letter - 'a']++;
        }

        return count;
    }

    private boolean compareWords(int[] word1, int[] word2) {
        for (int i = 0; i < word1.length; i++) {
            if (word1[i] != word2[i]) return false;
        }
        return true;
    }
}
