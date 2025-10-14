package MonthlyChallenges.Year25.October;

import java.util.List;

public class AdjacentIncreasingSubarraysDetectionI {
    public static void main(String[] args) {
        AdjacentIncreasingSubarraysDetectionI solution = new AdjacentIncreasingSubarraysDetectionI();
    }

    /**
     * LeetCode №3349. Adjacent Increasing Subarrays Detection I.
     *
     * @param nums - a list of integers.
     * @param k    - the length of a subarray.
     * @return - true - if there exist two adjacent subarrays of length k such that both subarrays are strictly
     * increasing. False - otherwise.
     */
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int length = nums.size();
        int firstMaxLength = length - k - k;

        int left = 0;

        while (left <= firstMaxLength) {
            boolean valid = true;
            int right = left + 1;

            for (int i = 1; i < k; i++, right++) {
                if (nums.get(right - 1) >= nums.get(right)) {
                    valid = false;
                    break;
                }
            }

            if (!valid) {
                left = right;
                continue;
            }

            int secondLeft = right;

            for (int i = 1, secondRight = secondLeft + 1; i < k; i++, secondRight++) {
                if (nums.get(secondRight - 1) >= nums.get(secondRight)) {
                    valid = false;
                    break;
                }
            }

            if (valid) return true;

            left++;
        }

        return false;
    }
}
