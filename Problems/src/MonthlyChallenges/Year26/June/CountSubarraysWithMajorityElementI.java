package MonthlyChallenges.Year26.June;

public class CountSubarraysWithMajorityElementI {

    /**
     * LeetCode №3737. Count Subarrays With Majority Element I.
     * <p>
     * Brute force solution.
     *
     * @param nums   - an array of integers.
     * @param target - an integer.
     * @return - the number of subarrays of nums in which target is the majority element. The majority element of
     * a subarray is the element that appears strictly more than half of the times in that subarray.
     */
    public int countMajoritySubarrays(int[] nums, int target) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int curCount = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == target) {
                    curCount++;
                }

                int targetLength = curCount * 2 - 1;
                if ((j - i + 1) <= targetLength) result++;
            }
        }

        return result;
    }
}
