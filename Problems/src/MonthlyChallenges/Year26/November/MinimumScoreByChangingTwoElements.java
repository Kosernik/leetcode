package MonthlyChallenges.Year26.November;

public class MinimumScoreByChangingTwoElements {
    public static void main(String[] args) {
        MinimumScoreByChangingTwoElements solution = new MinimumScoreByChangingTwoElements();

        int[] nums0 = {1, 4, 7, 8, 5};
        int answer0 = 3;
        int result0 = solution.minimizeSum(nums0);
        System.out.println(result0 == answer0);
    }

    /**
     * LeetCode №2567. Minimum Score by Changing Two Elements.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     * <p>
     * The low score of nums is the minimum absolute difference between any two integers.
     * The high score of nums is the maximum absolute difference between any two integers.
     * The score of nums is the sum of the high and low scores.
     *
     * @param nums - an array of integers
     * @return - the minimum score after changing two elements of nums.
     */
    public int minimizeSum(int[] nums) {
        if (nums.length <= 3) return 0;

        int[] minAndMax = new int[6];
        initialFill(minAndMax);

        for (int number : nums) {
            addMinAndMax(number, minAndMax);
        }

        return Math.min(Math.min(minAndMax[5] - minAndMax[2], minAndMax[3] - minAndMax[0]), minAndMax[4] - minAndMax[1]);
    }

    private void initialFill(int[] minAndMax) {
        minAndMax[0] = Integer.MAX_VALUE;
        minAndMax[1] = Integer.MAX_VALUE;
        minAndMax[2] = Integer.MAX_VALUE;
        minAndMax[3] = Integer.MIN_VALUE;
        minAndMax[4] = Integer.MIN_VALUE;
        minAndMax[5] = Integer.MIN_VALUE;
    }

    private void addMinAndMax(int number, int[] minAndMax) {
        if (number < minAndMax[0]) {
            minAndMax[2] = minAndMax[1];
            minAndMax[1] = minAndMax[0];
            minAndMax[0] = number;
        } else if (number < minAndMax[1]) {
            minAndMax[2] = minAndMax[1];
            minAndMax[1] = number;
        } else if (number < minAndMax[2]) {
            minAndMax[2] = number;
        }
        if (number > minAndMax[5]) {
            minAndMax[3] = minAndMax[4];
            minAndMax[4] = minAndMax[5];
            minAndMax[5] = number;
        } else if (number > minAndMax[4]) {
            minAndMax[3] = minAndMax[4];
            minAndMax[4] = number;
        } else if (number > minAndMax[3]) {
            minAndMax[3] = number;
        }
    }
}
