package MonthlyChallenges.Year26.February;

public class TrionicArrayI {

    /**
     * LeetCode №3637. Trionic Array I.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     * <p>
     * An array is trionic if there exist indices 0 < p < q < n − 1 such that:
     * * nums[0...p] is strictly increasing,
     * *nums[p...q] is strictly decreasing,
     * *nums[q...n − 1] is strictly increasing.
     *
     * @param nums - an array of integers.
     * @return - true if nums is isotonic, false - otherwise.
     */
    public boolean isTrionic(int[] nums) {
        if (nums.length <= 3 || nums[1] <= nums[0]) return false;

        int increasing = 1, decreasing = 0;
        boolean nowIncreasing = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return false;
            } else if (nums[i - 1] < nums[i]) {
                if (!nowIncreasing) {
                    nowIncreasing = true;
                    increasing++;
                }
            } else { // nums[i - 1] > nums[i]
                if (nowIncreasing) {
                    nowIncreasing = false;
                    decreasing++;
                }
            }

            //if (increasing > 2 || decreasing > 1) return false;
            if (decreasing > 1) return false;
        }

        return increasing == 2; // && decreasing == 1;
    }
}
