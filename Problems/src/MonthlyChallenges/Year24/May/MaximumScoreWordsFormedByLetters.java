package MonthlyChallenges.Year24.May;

public class MaximumScoreWordsFormedByLetters {

    /**
     * LeetCode №1255. Maximum Score Words Formed by Letters.
     * <p>
     * Complexity - O(2^N * N*M), N = words.length, M = words[i].length.
     * Memory - O(N*M)
     *
     * @param words   - an array of strings. All words contain only lowercase english letters.
     * @param letters - an array of available letters.
     * @param score   - an array of scores of every letter.
     * @return - the maximum score of any valid set of words formed by using the given letters.
     */
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        char[][] wordsChars = convertWordsToChars(words);
        int[] counts = getCount(letters);

        int maxScore = 0;

        for (int i = 1; i < (1 << words.length); i++) {
            maxScore = Math.max(maxScore, getScore(i, wordsChars, counts, score));
        }

        return maxScore;
    }

    private int getScore(int usedWords, char[][] wordsChars, int[] counts, int[] scores) {
        int[] usedLetters = new int[26];

        for (int i = 0; i < wordsChars.length; i++) {
            if (bitIsSet(usedWords, i)) {
                char[] word = wordsChars[i];
                for (char c : word) {
                    int charIdx = c - 'a';
                    usedLetters[charIdx]++;

                    if (usedLetters[charIdx] > counts[charIdx]) return 0;
                }
            }
        }

        int score = 0;
        for (int i = 0; i < 26; i++) {
            score += usedLetters[i] * scores[i];
        }
        return score;
    }

    private boolean bitIsSet(int usedWords, int idx) {
        return (usedWords & (1 << idx)) == (1 << idx);
    }

    private int[] getCount(char[] letters) {
        int[] result = new int[26];

        for (char letter : letters) {
            result[letter - 'a']++;
        }

        return result;
    }

    private char[][] convertWordsToChars(String[] words) {
        char[][] result = new char[words.length][];

        for (int i = 0; i < words.length; i++) {
            result[i] = words[i].toCharArray();
        }

        return result;
    }
}
