package MonthlyChallenges.Year21.May21;

public class MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {
        MaximumPointsYouCanObtainFromCards solution = new MaximumPointsYouCanObtainFromCards();

        int[] test0 = {1, 79, 80, 1, 1, 1, 200, 1};
        System.out.println(solution.maxScore(test0, 3));
    }

    /**
     * LeetCode #1423.
     * <p>
     * Complexity -O(k)
     * Memory - O(1)
     *
     * @param cardPoints - array of integers.
     * @param k          -   1 <= k <= cardPoints.length
     * @return - maximum score.
     */
    public int maxScore(int[] cardPoints, int k) {
        int result = 0;
        for (int i = 0; i < k; i++) {
            result += cardPoints[i];
        }

        int rightIdx = cardPoints.length - 1;
        int currSum = result;

        for (int i = 0; i < k; i++, rightIdx--) {
            currSum = currSum - cardPoints[k - i - 1] + cardPoints[rightIdx];
            result = Math.max(result, currSum);
        }

        return result;
    }
}
