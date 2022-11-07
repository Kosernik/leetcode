package MonthlyChallenges.Year22.November;

public class Maximum69Number {

    /**
     * LeetCode #1323. Maximum 69 Number.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param num - an integer consisting only of digits 6 and 9.
     * @return - the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
     */
    public int maximum69Number(int num) {
        char[] numChars = Integer.toString(num).toCharArray();

        for (int i = 0; i < numChars.length; i++) {
            if (numChars[i] == '6') {
                numChars[i] = '9';
                return Integer.parseInt(new String(numChars));
            }
        }
        return num;
    }
}
