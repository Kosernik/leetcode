package MonthlyChallenges.Year23.July;

public class MaximumNumberOfAchievableTransferRequests {
    private int result = 0;

    /**
     * LeetCode #1601. Maximum Number of Achievable Transfer Requests.
     *
     * @param n        - the number of houses.
     * @param requests - an array of requests for moving from requests[i][0] to requests[i][1].
     * @return - the maximum achievable requests.
     */
    public int maximumRequests(int n, int[][] requests) {
        backtrack(0, requests, new int[n], 0);
        return result;
    }

    private void backtrack(int requestIdx, int[][] requests, int[] inOutBalance, int completedRequests) {
        if (requestIdx == requests.length) {
            for (int inOut : inOutBalance) {
                if (inOut != 0) return;
            }
            result = Math.max(result, completedRequests);
            return;
        }

        int[] currRequest = requests[requestIdx];
        inOutBalance[currRequest[0]]--;
        inOutBalance[currRequest[1]]++;

        backtrack(requestIdx + 1, requests, inOutBalance, completedRequests + 1);

        inOutBalance[currRequest[0]]++;
        inOutBalance[currRequest[1]]--;

        backtrack(requestIdx + 1, requests, inOutBalance, completedRequests);
    }
}
