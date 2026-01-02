package MonthlyChallenges.Year21.February21;

public class NumberOfStepsToReduceANumberToZero {
    /**
     * LeetCode #1342.
     * <p>
     * Returns the number of steps to reduce given number to zero. If current number is even it`s divided by 2,
     * otherwise,it is reduced by 1.
     *
     * @param num - a non negative integer.
     * @return - number of steps to reduce given number to zero.
     */
    public int numberOfSteps(int num) {
        if (num == 0) return 0;

        int numOfSteps = 0;
        int number = num;

        while (number > 0) {
            if (number % 2 == 1) {
                number -= 1;
            } else {
                number /= 2;
            }
            numOfSteps++;
        }

        return numOfSteps;
    }
}
