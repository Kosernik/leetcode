package MonthlyChallenges.Year25.October;

public class FinalValueOfVariableAfterPerformingOperations {

    /**
     * LeetCode №2011. Final Value of Variable After Performing Operations.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     * <p>
     * Initial value of X = 0.
     *
     * @param operations - an array of strings representing the operations.
     * @return - the final value of X after performing all the operations.
     */
    public int finalValueAfterOperations(String[] operations) {
        int result = 0;

        for (String operation : operations) {
            if (operation.charAt(1) == '+') {
                result++;
            } else {
                result--;
            }
        }

        return result;
    }
}
