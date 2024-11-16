package MonthlyChallenges.Year24.November;

public class FindPowerOfKSizeSubarraysI {

    /**
     * LeetCode №3254. Find the Power of K-Size Subarrays I.
     * <p>
     * Complexity - O(N*K), N = nums.length, K = k.
     * Memory - O(1)
     *
     * @param nums - an array of integers.
     * @param k    - the size of a subarray. 1 <= k <= N
     * @return - an array of powers of subarrays of size k.
     */
    public int[] resultsArray(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];

        boolean sorted = checkSubarray(0, k - 1, nums);
        if (sorted) {
            result[0] = nums[k - 1];
        } else {
            result[0] = -1;
        }

        for (int leftIdx = 0, rightIdx = k; rightIdx < nums.length; leftIdx++, rightIdx++) {
            if (sorted) {
                if ((nums[rightIdx - 1] + 1) == nums[rightIdx]) {
                    result[leftIdx + 1] = nums[rightIdx];
                } else {
                    result[leftIdx + 1] = -1;
                    sorted = false;
                }
            } else {
                if ((nums[rightIdx - 1] + 1) == nums[rightIdx]) {
                    sorted = checkSubarray(leftIdx + 1, rightIdx, nums);
                    if (sorted) {
                        result[leftIdx + 1] = nums[rightIdx];
                    } else {
                        result[leftIdx + 1] = -1;
                    }
                } else {
                    result[leftIdx + 1] = -1;
                }
            }
        }

        return result;
    }

    private boolean checkSubarray(int left, int right, int[] nums) {
        for (int i = left + 1; i <= right; i++) {
            if ((nums[i - 1] + 1) != nums[i]) {
                return false;
            }
        }
        return true;
    }
}
