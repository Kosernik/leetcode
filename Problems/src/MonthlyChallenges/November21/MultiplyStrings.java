package MonthlyChallenges.November21;

public class MultiplyStrings {

    /**
     * LeetCode #43. Multiply Strings.
     *
     * Complexity - O(N*M), N = num1.length(), M - num2.length()
     * Memory - O(N+M)
     *
     * @param num1 - a string representation of a non-negative integer.
     * @param num2 - a string representation of a non-negative integer.
     * @return - the result of multiplying num1*num2.
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        else if (num1.equals("1")) return num2;
        else if (num2.equals("1")) return num1;

        String result = "0";
        String zeroes = "";

        for (int i = num2.length()-1; i >= 0; i--) {
            int digit = num2.charAt(i) - '0';
            String curNum = multiplyNumberByDigit(num1, digit);
            curNum = curNum.concat(zeroes);

            result = addNumbers(result, curNum);
            zeroes = zeroes.concat("0");
        }
        return result;
    }

    // Multiplies a number by a digit, 0 <= digit <= 9.
    private String multiplyNumberByDigit(String number, int digit) {
        if (digit == 0) return "0";
        else if (digit == 1) return number;

        StringBuilder result = new StringBuilder();
        int carry = 0;
        char[] numDigits = number.toCharArray();

        for (int i = numDigits.length-1; i >= 0; i--) {
            int curNum = (numDigits[i]-'0') * digit + carry;
            result.append(curNum % 10);
            carry = curNum / 10;
        }

        while (carry != 0) {
            result.append(carry % 10);
            carry = carry / 10;
        }

        result.reverse();

        return result.toString();
    }

    // LeetCode #415. Add Strings.
    private String addNumbers(String num1, String num2) {
        if (num1.equals("0")) return num2;
        else if (num2.equals("0")) return num1;

        StringBuilder result = new StringBuilder();
        int carry = 0;
        int length = Math.min(num1.length(), num2.length());
        int idx1 = num1.length()-1;
        int idx2 = num2.length()-1;

        for (int i = 0; i < length; i++) {
            int curNumber = (num1.charAt(idx1--) - '0') + (num2.charAt(idx2--) - '0') + carry;
            result.append(curNumber % 10);
            carry = curNumber / 10;
        }

        while (idx1 >= 0) {
            int curNumber = (num1.charAt(idx1--) - '0') + carry;
            result.append(curNumber % 10);
            carry = curNumber / 10;
        }
        while (idx2 >= 0) {
            int curNumber = (num2.charAt(idx2--) - '0') + carry;
            result.append(curNumber % 10);
            carry = curNumber / 10;
        }

        if (carry > 0) result.append(carry);
        result.reverse();
        return result.toString();
    }
}
