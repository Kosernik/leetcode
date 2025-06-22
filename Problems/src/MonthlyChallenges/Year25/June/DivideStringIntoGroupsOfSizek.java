package MonthlyChallenges.Year25.June;

public class DivideStringIntoGroupsOfSizek {

    /**
     * LeetCode №2138. Divide a String Into Groups of Size k.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s    - a string.
     * @param k    - the length of substrings.
     * @param fill - a character added to the last substring if needed.
     * @return - the resulting array filled with substrings of size k.
     */
    public String[] divideString(String s, int k, char fill) {
        int resultSize = Math.ceilDiv(s.length(), k);

        String[] result = new String[resultSize];

        for (int i = 0, idx = 0; i < resultSize - 1; i++, idx += k) {
            result[i] = s.substring(idx, idx + k);
        }

        int lettersAtEnd = resultSize * k - s.length();
        if (lettersAtEnd == 0) {
            result[result.length - 1] = s.substring(s.length() - k);
        } else {
            String ending = String.valueOf(fill).repeat(lettersAtEnd);
            result[result.length - 1] = s.substring((resultSize - 1) * k).concat(ending);
        }

        return result;
    }
}
