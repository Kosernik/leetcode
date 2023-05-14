package MonthlyChallenges.Year23.May;


import java.util.Arrays;

public class MaximizeScoreAfterNOperations {
    public static void main(String[] args) {
        MaximizeScoreAfterNOperations solution = new MaximizeScoreAfterNOperations();
//        System.out.println(solution.gcd(12, 3));
//        System.out.println(solution.gcd(3, 12));
//        System.out.println(solution.gcd(12, 12));

    }


    /**
     * LeetCode #1799. Maximize Score After N Operations.
     *
     * @param nums - an array of integers. nums.length % 2 == 0, nums.length <= 14.
     * @return - the maximum score after all operations.
     */
    public int maxScore(int[] nums) {
        int[] computed = new int[1 << nums.length];
        Arrays.fill(computed, -1);

        return backtrack(nums, 0, 0, computed);
    }

    private int backtrack(int[] nums, int bitMask, int pairs, int[] computed) {
        if ((2 * pairs) == nums.length) {
            return 0;
        }
        if (computed[bitMask] != -1) {
            return computed[bitMask];
        }

        int result = 0;
        pairs += 1;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (((bitMask >> i) & 1) == 1 || ((bitMask >> j) & 1) == 1) {
                    continue;
                }
                int newMask = bitMask | (1 << i) | (1 << j);

                int score = pairs * gcd(nums[i], nums[j]);
                score += backtrack(nums, newMask, pairs, computed);

                result = Math.max(result, score);
            }
        }

        computed[bitMask] = result;
        return result;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
