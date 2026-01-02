package MonthlyChallenges.Year21.April21;

public class DetermineIfStringHalvesAreAlike {
    /**
     * LeetCode #1704.
     * <p>
     * Checks if two halves of a string have the same number of vowels.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string of english letters, s.length() is even.
     * @return - true - if both halves of a string have the same number of vowels, false - otherwise.
     */
    public boolean halvesAreAlike(String s) {
        int vowelsCount = 0;

        for (int i = 0; i < s.length() / 2; i++) {
            if (isVowel(s.charAt(i))) {
                vowelsCount++;
            }
        }
        for (int i = s.length() / 2; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                vowelsCount--;
            }
        }

        return vowelsCount == 0;
    }

    private boolean isVowel(char ch) {
        if ('a' <= ch && ch <= 'z') {
            return isLowerVowel(ch);
        } else {
            return isCapitalVowel(ch);
        }
    }

    private boolean isLowerVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private boolean isCapitalVowel(char ch) {
        return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
