package MonthlyChallenges.August21;

public class SumOfSquareNumbers {
    /**
     * LeetCode #633. Sum of Square Numbers.
     *
     * Checks if input number can be represented as a sum of two squares. (c = a^2 + b^2)
     * @param c - a non -negative integer. 0 <= c <= 2^31 - 1
     * @return - True - if a number "c" is a sum of two squares. False - otherwise.
     */
    public boolean judgeSquareSum(int c) {
        for (int i = 0, length = (int) Math.ceil(Math.sqrt(c / 2.0)); i <= length; i++) {
            int sqr = c - i * i;
            int root = (int) Math.sqrt(sqr);
            if (root * root == sqr) return true;
        }

        return false;
    }
}
