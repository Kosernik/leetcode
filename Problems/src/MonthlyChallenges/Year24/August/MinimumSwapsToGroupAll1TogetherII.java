package MonthlyChallenges.Year24.August;

public class MinimumSwapsToGroupAll1TogetherII {
    public static void main(String[] args) {
        MinimumSwapsToGroupAll1TogetherII solution = new MinimumSwapsToGroupAll1TogetherII();

        int[] test2 = {1, 1, 0, 0, 1};
        System.out.println(solution.minSwaps(test2) == 0);
    }

    /**
     * LeetCode №2134. Minimum Swaps to Group All 1's Together II.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of 0 and 1.
     * @return - the minimum number of swaps required to group all 1's present in the array together at any location.
     */
    public int minSwaps(int[] nums) {
        int numberOfOnes = 0;
        int length = nums.length;
        int[] doubleNums = new int[length * 2];

        for (int i = 0; i < length; i++) {
            numberOfOnes += nums[i];

            doubleNums[i] = nums[i];
            doubleNums[i + length] = nums[i];
        }

        int currentZeroes = 0;
        for (int i = 0; i < numberOfOnes; i++) {
            if (doubleNums[i] == 0) currentZeroes++;
        }
        int swaps = currentZeroes;

        for (int i = 1; i < length; i++) {
            currentZeroes -= doubleNums[i - 1] == 0 ? 1 : 0;
            currentZeroes += doubleNums[i + numberOfOnes - 1] == 0 ? 1 : 0;

            swaps = Math.min(swaps, currentZeroes);
        }

        return swaps;
    }
}
