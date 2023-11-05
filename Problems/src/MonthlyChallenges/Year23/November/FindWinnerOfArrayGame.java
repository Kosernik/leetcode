package MonthlyChallenges.Year23.November;

public class FindWinnerOfArrayGame {

    /**
     * LeetCode #1535. Find the Winner of an Array Game.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param arr - an array of distinct integers.
     * @param k   - the total number of consecutive rounds to win.
     * @return - an integer that will win k rounds.
     */
    public int getWinner(int[] arr, int k) {
        if (k >= arr.length) {
            return getMax(arr);
        } else if (k == 1) {
            return Math.max(arr[0], arr[1]);
        }

        int result = arr[0];
        int winCount = 0;

        for (int i = 1; i < arr.length; i++) {
            if (result > arr[i]) {
                winCount++;
                if (winCount == k) return result;
            } else {
                result = arr[i];
                winCount = 1;
            }
        }

        return result;
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int element : arr) max = Math.max(max, element);
        return max;
    }
}
