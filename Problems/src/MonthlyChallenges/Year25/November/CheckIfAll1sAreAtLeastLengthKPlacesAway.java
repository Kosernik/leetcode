package MonthlyChallenges.Year25.November;

public class CheckIfAll1sAreAtLeastLengthKPlacesAway {

    /**
     * LeetCode №1437. Check If All 1's Are at Least Length K Places Away.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of 0 and 1.
     * @param k    - the minimum distance between 1`s
     * @return - Returns true if all 1's are at least k places away from each other, otherwise returns false.
     */
    public boolean kLengthApart(int[] nums, int k) {
        int prevLength = k;

        for (int num : nums) {
            if (num == 0) {
                prevLength++;
            } else { // num == 1
                if (prevLength < k) return false;
                prevLength = 0;
            }
        }

        return true;
    }
}
