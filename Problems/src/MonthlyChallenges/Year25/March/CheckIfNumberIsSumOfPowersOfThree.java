package MonthlyChallenges.Year25.March;

public class CheckIfNumberIsSumOfPowersOfThree {

    /**
     * LeetCode №1780. Check if Number is a Sum of Powers of Three.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param n - a positive integer.
     * @return - true if n is a sum of distinct powers of three, false otherwise.
     */
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) return false;
            n /= 3;
        }

        return true;
    }
}
