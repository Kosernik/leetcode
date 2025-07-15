package MonthlyChallenges.Year25.July;

public class ValidWord {

    /**
     * LeetCode №3136. Valid Word.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     * <p>
     * A word is considered valid if:
     * * It contains a minimum of 3 characters.
     * * It contains only digits (0-9), and English letters (uppercase and lowercase).
     * * It includes at least one vowel.
     * * It includes at least one consonant.
     *
     * @param word - a string.
     * @return - true - if word is valid, false - otherwise.
     */
    public boolean isValid(String word) {
        if (word.length() < 3) return false;
        char[] vowels = {'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'};
        boolean hasVowel = false, hasConsonant = false;

        for (char letter : word.toCharArray()) {
            if (('a' <= letter && letter <= 'z') || ('A' <= letter && letter <= 'Z')) {
                if (isVowel(letter, vowels)) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            } else if (!('0' <= letter && letter <= '9')) {
                return false;
            }
        }

        return hasVowel && hasConsonant;
    }

    private static boolean isVowel(char candidate, char[] vowels) {
        for (char vowel : vowels) {
            if (vowel == candidate) return true;
        }
        return false;
    }
}
