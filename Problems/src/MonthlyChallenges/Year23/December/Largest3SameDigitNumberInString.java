package MonthlyChallenges.Year23.December;

public class Largest3SameDigitNumberInString {

    /**
     * LeetCode №2264. Largest 3-Same-Digit Number in String.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param num - a string consisting only of digits.
     * @return - the largest good integer of length 3.
     */
    public String largestGoodInteger(String num) {
        int largestInteger = -1;

        char[] digits = num.toCharArray();
        for (int i = 0; i < digits.length - 2; i++) {
            if (digits[i] == digits[i + 1] && digits[i] == digits[i + 2]) {
                int curResult = digits[i] - '0';

                largestInteger = Math.max(largestInteger, curResult);
            }
        }

        if (largestInteger == -1) {
            return "";
        } else {
            char digit = (char) ('0' + largestInteger);
            return String.valueOf(digit).repeat(3);
        }
    }
}
