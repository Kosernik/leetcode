package MonthlyChallenges.Year23.December;

public class FindWordsThatCanBeFormedByCharacters {
    private final int NUMBER_OF_CHARS = 26;

    /**
     * LeetCode №1160. Find Words That Can Be Formed by Characters.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param words - an array of strings. All strings consist of english lowercase letters.
     * @param chars - a string of available characters. All characters are english lowercase.
     * @return - the sum of lengths of all good strings in words. A string is good if it can be formed by characters
     * from chars (each character can only be used once).
     */
    public int countCharacters(String[] words, String chars) {
        int[] counts = countChars(chars);

        int result = 0;
        for (String word : words) {
            if (isWordValid(word, counts)) {
                result += word.length();
            }
        }

        return result;
    }

    private boolean isWordValid(String word, int[] availableChars) {
        int[] count = countChars(word);

        for (int i = 0; i < count.length; i++) {
            if (count[i] > availableChars[i]) return false;
        }

        return true;
    }

    private int[] countChars(String word) {
        int[] count = new int[NUMBER_OF_CHARS];

        for (char letter : word.toCharArray()) {
            count[letter - 'a']++;
        }

        return count;
    }
}
