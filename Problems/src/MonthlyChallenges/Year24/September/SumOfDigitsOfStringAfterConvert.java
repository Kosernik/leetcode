package MonthlyChallenges.Year24.September;

public class SumOfDigitsOfStringAfterConvert {

    /**
     * LeetCode №1945. Sum of Digits of String After Convert.
     *
     * @param s - a string of lower case english letters.
     * @param k - the number of transform operations.
     * @return - the resulting integer after performing the operations.
     */
    public int getLucky(String s, int k) {
        String digits = convertToDigits(s);

        int transformed = transformToInteger(digits);

        for (int i = 1; i < k; i++) {
            transformed = transform(transformed);
        }

        return transformed;
    }

    private int transform(int number) {
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

    private int transformToInteger(String digits) {
        int sum = 0;

        for (char ch : digits.toCharArray()) {
            sum += ch - '0';
        }

        return sum;
    }

    private String convertToDigits(String s) {
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            result.append(ch - 'a' + 1);
        }

        return result.toString();
    }
}
