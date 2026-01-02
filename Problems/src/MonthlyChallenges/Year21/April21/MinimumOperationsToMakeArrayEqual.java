package MonthlyChallenges.Year21.April21;

public class MinimumOperationsToMakeArrayEqual {
    // LeetCode #1551.
    public int minOperations(int n) {
        if (n % 2 == 1) {
            int half = n / 2;
            return half * (half + 1);
        } else {
            return (n - 1) * n / 2 - minOperations(n - 1);
        }
    }
}
