package MonthlyChallenges.September;

public class LengthOfLastWord {

    /**
     * Returns the length of the last word in a string.
     * @param s - a string of upper/lower-case alphabets and empty space characters ' '.
     * @return - length of the last word or 0 if no words in a string.
     */
    public int lengthOfLastWord(String s) {
        int length = 0;
        if (s == null || s.length() == 0) return length;

        int i = s.length()-1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            } else {
                length++;
            }
        }
        return length;
    }
}
