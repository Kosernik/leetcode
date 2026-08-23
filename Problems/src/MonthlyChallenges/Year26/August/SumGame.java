package MonthlyChallenges.Year26.August;

public class SumGame {
    public static void main(String[] args) {
        SumGame solution = new SumGame();

        String num0 = "5023";
        boolean result0 = false;
        System.out.println(solution.sumGame(num0) == result0);

        String num1 = "25??";
        boolean result1 = true;
        System.out.println(solution.sumGame(num1) == result1);

        String num2 = "?3295???";
        boolean result2 = false;
        System.out.println(solution.sumGame(num2) == result2);
    }

    /**
     * LeetCode №1927. Sum Game.
     * <p>
     * You are given a string num of even length consisting of digits and '?' characters. On each turn, a player will do
     * the following if there is still at least one '?' in num:
     * <p>
     * * Choose an index i where num[i] == '?'.
     * * Replace num[i] with any digit between '0' and '9'.
     * * The game ends when there are no more '?' characters in num.
     * <p>
     * For Bob to win, the sum of the digits in the first half of num must be equal to the sum of the digits in the
     * second half. For Alice to win, the sums must not be equal.
     *
     * @param num - a string of digits and '?'. num.length is even.
     * @return - true if Alice will win and false if Bob will win.
     */
    public boolean sumGame(String num) {
        char QUESTION_MARK = '?';

        int leftQuestions = 0, rightQuestions = 0;
        int leftSum = 0, rightSum = 0;

        int i = 0;
        for (; i < num.length() / 2; i++) {
            if (num.charAt(i) == QUESTION_MARK) {
                leftQuestions++;
            } else {
                leftSum += Character.getNumericValue(num.charAt(i));
            }
        }
        for (; i < num.length(); i++) {
            if (num.charAt(i) == QUESTION_MARK) {
                rightQuestions++;
            } else {
                rightSum += Character.getNumericValue(num.charAt(i));
            }
        }

        if (((leftQuestions + rightQuestions) & 1) == 1) {
            return true;
        }

        return (leftSum - rightSum) * 2 != (rightQuestions - leftQuestions) * 9;
    }
}
