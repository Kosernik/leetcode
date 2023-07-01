package MonthlyChallenges.Year23.July;

public class FairDistributionOfCookies {

    /**
     * LeetCode #2305. Fair Distribution of Cookies.
     * <p>
     * Complexity - O(N^2), N = cookies.length.
     * Memory - O(k)
     *
     * @param cookies - an array of positive integers.
     * @param k       - the total number of kids. 2 <= k <= cookies.length
     * @return - the minimum unfairness.
     */
    public int distributeCookies(int[] cookies, int k) {
        int[] totalCookies = new int[k];
        return backTrack(0, cookies, k, totalCookies);
    }

    private int backTrack(int index, int[] cookies, int kids, int[] totalCookies) {
        if (index >= cookies.length) {
            return getMaxCookies(totalCookies);
        }

        int result = Integer.MAX_VALUE;
        for (int kid = 0; kid < kids; kid++) {
            totalCookies[kid] += cookies[index];

            result = Math.min(result, backTrack(index + 1, cookies, kids, totalCookies));

            totalCookies[kid] -= cookies[index];
        }

        return result;
    }

    private int getMaxCookies(int[] totalCookies) {
        int result = totalCookies[0];
        for (int cookie : totalCookies) {
            result = Math.max(result, cookie);
        }
        return result;
    }
}
