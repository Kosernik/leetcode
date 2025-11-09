package MonthlyChallenges.Year25.November;

public class CountOperationsToObtainZero {
    public static void main(String[] args) {
        CountOperationsToObtainZero solution = new CountOperationsToObtainZero();

        int num1_0 = 2, num2_0 = 3, result0 = 3;
        System.out.println(solution.countOperations(num1_0, num2_0) == result0);
    }

    /**
     * LeetCode №2169. Count Operations to Obtain Zero.
     *
     * @param num1 - a non-negative integer.
     * @param num2 - a non-negative integer.
     * @return - the number of operations required to make either num1 = 0 or num2 = 0.
     */
    public int countOperations(int num1, int num2) {
        if (num1 == 0 || num2 == 0) return 0;
        if (num1 == num2) return 1;
        if (num2 > num1) return countOperations(num2, num1);

        int operations = Math.ceilDiv(num1 - num2, num2);

        return operations + countOperations(num2, num1 - operations * num2);
    }
}
