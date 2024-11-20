package MonthlyChallenges.Year24.November;

public class TakeKOfEachCharacterFromLeftAndRight {

    /**
     * LeetCode №2516. Take K of Each Character From Left and Right.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string consisting only of 'a', 'b' and 'c'.
     * @param k - a non-negative integer.
     * @return - the minimum number of minutes needed for you to take at least k of each character, or return -1 if it
     * is not possible to take k of each character.
     */
    public int takeCharacters(String s, int k) {
        if (k == 0) return 0;

        char[] letters = s.toCharArray();
        int result = Integer.MAX_VALUE;

        int[] counts = new int[3];
        int length = 0;
        int leftIdx = 0;

        for (; leftIdx < letters.length; leftIdx++) {
            length++;
            counts[letters[leftIdx] - 'a']++;

            if (validCount(counts, k)) {
                result = length;
                break;
            }
        }

        //  Not enough letters
        if (!validCount(counts, k)) {
            return -1;
        }

        for (int i = letters.length - 1; i >= 0; i--) {
            counts[letters[i] - 'a']++;
            length++;

            while (leftIdx >= 0) {
                char prevLetter = letters[leftIdx];

                if (counts[prevLetter - 'a'] > k) {
                    counts[prevLetter - 'a']--;

                    leftIdx--;
                    length--;
                } else {
                    break;
                }
            }

            result = Math.min(result, length);
        }

        return result;
    }

    private boolean validCount(int[] counts, int k) {
        return counts[0] >= k && counts[1] >= k && counts[2] >= k;
    }
}
