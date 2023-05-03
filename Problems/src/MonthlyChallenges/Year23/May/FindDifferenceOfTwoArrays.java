package MonthlyChallenges.Year23.May;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDifferenceOfTwoArrays {

    /**
     * LeetCode #2215. Find the Difference of Two Arrays.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums1 - an array of integers.
     * @param nums2 - an array of integers.
     * @return - a list of 2 lists.
     * result[0] is a list of all distinct integers in nums1 which are not present in nums2.
     * result[1] is a list of all distinct integers in nums2 which are not present in nums1.
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> nums1Unique = getUnique(nums1);
        Set<Integer> nums2Unique = getUnique(nums2);

        List<Integer> diff1 = getDifference(nums1, nums2Unique);
        List<Integer> diff2 = getDifference(nums2, nums1Unique);

        List<List<Integer>> result = new ArrayList<>();
        result.add(diff1);
        result.add(diff2);

        return result;
    }

    private List<Integer> getDifference(int[] numbers, Set<Integer> unique) {
        List<Integer> result = new ArrayList<>();

        for (int number : numbers) {
            if (!unique.contains(number)) {
                result.add(number);
                unique.add(number);
            }
        }

        return result;
    }

    private Set<Integer> getUnique(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (int number : nums) {
            unique.add(number);
        }
        return unique;
    }
}
