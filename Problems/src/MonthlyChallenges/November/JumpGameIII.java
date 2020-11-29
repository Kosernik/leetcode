package MonthlyChallenges.November;

public class JumpGameIII {
    private boolean[] visited;

    /**
     * LeetCode #1306.
     *
     * @param arr - array of non-negative integers.
     * @param start - starting index.
     * @return - True - if it is possible to get to cell with 0 value, false - otherwise.
     */
    public boolean canReach(int[] arr, int start) {
        if (arr == null || arr.length == 0) return false;
        else if (arr[start] == 0) return true;

        visited = new boolean[arr.length];

        boolean left = false;
        if (start - arr[start] >= 0) {
            left = helper(arr, start - arr[start]);
        }
        if (left) return true;
        boolean right = false;
        if (start + arr[start] < arr.length) {
            right = helper(arr, start + arr[start]);
        }
        return right;
    }

    private boolean helper(int[] arr, int start) {
        if (arr[start] == 0) return true;
        else if (visited[start]) return false;

        visited[start] = true;
        boolean left = false;
        boolean right = false;

        if (start - arr[start] >= 0) {
            left = helper(arr, start - arr[start]);
        }
        if (start + arr[start] < arr.length) {
            right = helper(arr, start + arr[start]);
        }

        return left || right;
    }
}
