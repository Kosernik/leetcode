package MonthlyChallenges.Year21.September21;

public class LongestTurbulentSubarray {
    /**
     * LeetCode #978. Longest Turbulent Subarray.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param arr - an array of integers. arr.length >= 1
     * @return - the length of a maximum size turbulent subarray of "arr".
     */
    public int maxTurbulenceSize(int[] arr) {
        int result = 1;

        int idx = 0;

        while (idx < arr.length) {
            int curLength = 1;
            if ((idx + 1) == arr.length) break;
            else if (arr[idx] == arr[idx + 1]) {
                idx++;
                continue;
            }
            boolean larger = arr[idx] < arr[idx + 1];

            while ((idx + 1) < arr.length && comparison(arr[idx], arr[idx + 1], larger)) {
                larger = !larger;
                idx++;
                curLength++;
            }

            result = Math.max(result, curLength);
        }

        return result;
    }

    private boolean comparison(int prev, int number, boolean larger) {
        if (larger) {
            return prev < number;
        } else {
            return prev > number;
        }
    }
}
