package Problems;

public class DecryptStringFromAlphabetToIntegerMapping {

    /**
     * LeetCode #1309. Decrypt String from Alphabet to Integer Mapping.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string of digits and the '#' letter.
     *      Characters ('a' to 'i') are represented by ('1' to '9') respectively.
     *      Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
     *
     * @return - decrypted string.
     */
    public String freqAlphabets(String s) {
        StringBuilder result = new StringBuilder();

        int idx = 0;
        while (idx < s.length()) {
            if ((s.charAt(idx) == '1' || s.charAt(idx) == '2') && idx + 2 < s.length() && s.charAt(idx+2) == '#') {
                int charInt = Integer.parseInt(s.substring(idx, idx+2));
                result.append((char) ('a' + (charInt - 1)));
                idx += 3;
            } else {
                result.append((char) ('a' + ((int)s.charAt(idx) - '1')));
                idx++;
            }
        }

        return result.toString();
    }
}
