package MonthlyChallenges.November;

public class ConsecutiveCharacters {

    /**
     * Returns the maximum length of a non-empty substring that contains only one unique character.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string, may be null.
     * @return - the maximum length of a non-empty substring that contains only one unique character.
     */
    public int maxPower(String s) {
        if (s == null || s.length() == 0) return 0;

        int max = 1;
        char[] letters = s.toCharArray();
        char currLetter = letters[0];
        int currCount = 1;

        for (int i = 1; i < letters.length; i++) {
            if (letters[i] == currLetter) {
                currCount++;
            } else {
                max = Math.max(max, currCount);
                currLetter = letters[i];
                currCount = 1;
            }
        }

        max = Math.max(max, currCount);
        return max;
    }
}
