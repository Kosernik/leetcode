package MonthlyChallenges.Year25.June;

import java.util.Arrays;

public class FindLexicographicallyLargestStringFromBoxI {

    /**
     * LeetCode №3403. Find the Lexicographically Largest String From the Box I.
     *
     * @param word       - a string of lowercase English letters.
     * @param numFriends - the total number of friends.
     * @return - the lexicographically largest string from the box after all the rounds are finished.
     */
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }

        int targetLength = word.length() - numFriends + 1;
        char[] letters = word.toCharArray();

        char[] largest = Arrays.copyOf(letters, targetLength);

        for (int i = 1; i <= (letters.length - targetLength); i++) {
            boolean larger = false;

            for (int j = 0; j < targetLength; j++) {
                if (letters[j + i] > largest[j]) {
                    larger = true;
                    break;
                } else if (letters[j + i] < largest[j]) {
                    break;
                }
            }

            if (larger) {
                largest = Arrays.copyOfRange(letters, i, i + targetLength);
            }
        }

        for (int i = letters.length - targetLength + 1; i < letters.length; i++) {
            boolean larger = false;

            for (int j = 0; ; j++) {
                if ((j + i) >= letters.length || letters[j + i] < largest[j]) {
                    break;
                } else if (letters[j + i] > largest[j]) {
                    larger = true;
                    break;
                }
            }

            if (larger) {
                largest = Arrays.copyOfRange(letters, i, letters.length);
            }
        }

        return new String(largest);
    }
}
