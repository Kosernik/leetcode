package MonthlyChallenges.January21;

public class KthMissingPositiveNumber {

    /**
     * LeetCode #1539.
     * Returns the k-th positive integer that is missing from the array.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param arr - an array of positive integers sorted in a strictly increasing order. No duplicates.
     * @param k - positive integer.
     * @return - k-th missing element.
     */
    public int findKthPositive(int[] arr, int k) {
        int missed = 0;

        for (int i = 0; i < arr.length; i++) {
            int prev = i > 0 ? arr[i-1] : 0;
            if ((prev+1) < arr[i]) {
                int diff = arr[i] - prev - 1;
                if (missed+diff >= k) {
                    return prev+(k-missed);
                }
                missed += diff;
            }
        }

        return arr[arr.length-1] + (k-missed);
    }
}
