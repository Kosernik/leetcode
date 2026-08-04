package MonthlyChallenges.Year26.August;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMissingElements {

    /**
     * LeetCode №3731. Find Missing Elements.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(1)
     *
     * @param nums - an array of unique integers.
     * @return - a sorted list of all the missing integers in the range [min(nums), max(nums)].
     */
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {
            for (int number = nums[i - 1] + 1; number < nums[i]; number++) {
                result.add(number);
            }
        }

        return result;
    }
}
