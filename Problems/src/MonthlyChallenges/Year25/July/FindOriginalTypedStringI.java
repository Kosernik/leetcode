package MonthlyChallenges.Year25.July;

public class FindOriginalTypedStringI {

    /**
     * LeetCode №3330. Find the Original Typed String I.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param word - a string of english lowercase letters.
     * @return - the total number of possible original strings that Alice might have intended to type.
     */
    public int possibleStringCount(String word) {
        int result = 1;

        char prevLetter = ' ';
        int prevCount = 1;

        for (char letter : word.toCharArray()) {
            if (letter == prevLetter) {
                prevCount++;
            } else {
                result += prevCount - 1;

                prevLetter = letter;
                prevCount = 1;
            }
        }

        result += prevCount - 1;
        return result;
    }
}
