package MonthlyChallenges.Year23.February;

public class ShuffleArray {

    /**
     * LeetCode #1470. Shuffle the Array.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of integers.
     * @param n    - half of the nums length.
     * @return - shuffled array.
     */
    public int[] shuffle(int[] nums, int n) {
        int[] shuffled = new int[nums.length];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            shuffled[idx++] = nums[i];
            shuffled[idx++] = nums[i + n];
        }

        return shuffled;
    }
}
