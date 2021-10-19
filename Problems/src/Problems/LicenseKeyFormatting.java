package Problems;

public class LicenseKeyFormatting {

    /**
     * LeetCode #482. License Key Formatting.
     *
     *
     * @param s - a string of English letters, digits, and dashes '-'.
     * @param k - max length of a group.
     * @return - reformatted string "s".
     */
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder result = new StringBuilder();

        int curGroupLen = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                result.append(getUpper(s.charAt(i)));
                curGroupLen++;
                if (curGroupLen == k) {
                    result.append('-');
                    curGroupLen = 0;
                }
            }
        }

        if (result.length() == 0) return "";
        if (result.charAt(result.length()-1) == '-') result.deleteCharAt(result.length()-1);
        result.reverse();
        return result.toString();
    }

    private static char getUpper(char ch) {
        if (('A' <= ch && ch <= 'Z') || ('0' <= ch && ch <= '9')) return ch;
        return (char) ('A' + (ch - 'a'));
    }
}
