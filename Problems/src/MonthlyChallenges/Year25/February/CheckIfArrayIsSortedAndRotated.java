package MonthlyChallenges.Year25.February;

public class CheckIfArrayIsSortedAndRotated {

    /**
     * LeetCode №1752. Check if Array Is Sorted and Rotated.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of integers.
     * @return - true if the array was originally sorted in non-decreasing order, then rotated some number of
     * positions (including zero). Otherwise, returns false.
     */
    public boolean check(int[] nums) {
        boolean foundRotation = false;
        int prev = nums[0];
        int minNumber = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curNumber = nums[i];

            if (curNumber < prev) {
                if (foundRotation) return false;
                foundRotation = true;
            }

            if (foundRotation) {
                if (curNumber > minNumber) return false;
            }

            prev = curNumber;
        }

        return true;
    }
}
