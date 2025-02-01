package MonthlyChallenges.Year25.February;

public class SpecialArrayI {

    /**
     * LeetCode №3151. Special Array I.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of positive integers.
     * @return - true if nums is a special array, otherwise, returns false.
     */
    public boolean isArraySpecial(int[] nums) {
        boolean prevOdd = (nums[0] & 1) == 1;

        for (int i = 1; i < nums.length; i++) {
            boolean curOdd = (nums[i] & 1) == 1;

            if (curOdd == prevOdd) return false;

            prevOdd = curOdd;
        }

        return true;
    }
}
