package MonthlyChallenges.Year26.May;

public class JumpGameIX {
    public static void main(String[] args) {
        JumpGameIX solution = new JumpGameIX();

        int[] nums3 = {11, 18, 11};
        int[] result3 = {11, 18, 18};
        int[] answer3 = solution.maxValue(nums3);
        for (int i = 0; i < result3.length; i++) {
            System.out.println(answer3[i] == result3[i]);
        }
        System.out.println("---------------");

        int[] nums4 = {30, 21, 5, 35, 24};
        int[] result4 = {35, 35, 35, 35, 35};
        int[] answer4 = solution.maxValue(nums4);
        for (int i = 0; i < result4.length; i++) {
            System.out.println(answer4[i] == result4[i]);
        }
    }

    /**
     * LeetCode №3660. Jump Game IX.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     * <p>
     * From any index i, you can jump to another index j under the following rules:
     * * Jump to index j where j > i is allowed only if nums[j] < nums[i].
     * * Jump to index j where j < i is allowed only if nums[j] > nums[i].
     *
     * @param nums - an array of integers.
     * @return - an array result where result[i] - is the maximum reachable value from cell i.
     */
    public int[] maxValue(int[] nums) {
        int length = nums.length;

        int[] result = new int[length];

        int[] leftJumps = new int[length];
        leftJumps[0] = nums[0];

        int prevMax = nums[0];
        for (int i = 1; i < length; i++) {
            prevMax = Math.max(prevMax, nums[i]);

            leftJumps[i] = prevMax;
        }

        result[length - 1] = leftJumps[length - 1];

        int[] rightJumps = new int[length];
        rightJumps[length - 1] = nums[length - 1];

        int prevMin = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            prevMin = Math.min(prevMin, nums[i]);

            rightJumps[i] = prevMin;

            if (leftJumps[i] > rightJumps[i + 1]) {
                result[i] = result[i + 1];
            } else {
                result[i] = leftJumps[i];
            }
        }

        return result;
    }
}
