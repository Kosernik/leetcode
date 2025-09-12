package MonthlyChallenges.Year25.September;

public class VowelsGameInString {

    /**
     * LeetCode №3227. Vowels Game in a String.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string of lowercase english letters.
     * @return - true if Alice wins the game, and false otherwise.
     */
    public boolean doesAliceWin(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) return true;
        }
        return false;
    }

    public boolean doesAliceWinAlt(String s) {
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) return true;
        }
        return false;
    }

    private static boolean isVowel(char letter) {
        return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u';
    }
}
