package Problems;

public class ReverseStringII {

    /**
     * LeetCode #541. Reverse String II.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string.
     * @param k - positive integer.
     * @return - the string 's' after reversing every 'k' characters in every 2*k window.
     */
    public String reverseStr(String s, int k) {
        char[] letters = s.toCharArray();

        int start = 0; int end = k-1; int twoK = 2 * k;
        int numberOfReverses = letters.length / twoK;

        for (int i = 0; i < numberOfReverses; i++) {
            reverseInArray(letters, start, end);
            start += twoK;
            end += twoK;
        }

        end = Math.min(end, letters.length-1);
        reverseInArray(letters, start, end);

        return new String(letters);
    }

    /**
     * Reverses chars in an array inplace.
     *
     * @param letters - an array of characters.
     * @param start - start index inclusive
     * @param end - end index inclusive
     */
    private void reverseInArray(char[] letters, int start, int end) {
        while (start <= end) {
            char temp = letters[start];
            letters[start] = letters[end];
            letters[end] = temp;
            start++;
            end--;
        }
    }
}
