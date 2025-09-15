package MonthlyChallenges.Year25.September;

public class MaximumNumberOfWordsYouCanType {

    /**
     * LeetCode №1935. Maximum Number of Words You Can Type.
     * <p>
     * Complexity - O(N+M), N = text.length, M = brokenLetters.length
     * Memory - O(N+M)
     *
     * @param text          - a string of words, each word only consists of lowercase English letters.
     * @param brokenLetters - a string of broken letters, brokenLetters consists of distinct lowercase English letters.
     * @return -  the number of words in text you can fully type using this keyboard.
     */
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] broken = new boolean[26];
        for (char brokenLetter : brokenLetters.toCharArray()) {
            broken[brokenLetter - 'a'] = true;
        }

        int canType = 0;

        boolean canBeTyped = true;
        for (char letter : text.toCharArray()) {
            if (letter == ' ') {
                if (canBeTyped) {
                    canType++;
                }

                canBeTyped = true;
                continue;
            }

            if (broken[letter - 'a']) {
                canBeTyped = false;
            }
        }

        if (canBeTyped) canType++;

        return canType;
    }
}
