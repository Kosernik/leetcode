package MonthlyChallenges.Year23.November;

import java.util.HashSet;
import java.util.Set;

public class FindUniqueBinaryString {

    /**
     * LeetCode №1980. Find Unique Binary String.
     *
     * @param nums - an array of unique binary strings. nums.length = n, nums[i].length() = n.
     * @return - a binary string of length n that does not appear in nums
     */
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> numbers = new HashSet<>();

        for (String number : nums) {
            int curNumber = Integer.parseInt(number, 2);
            numbers.add(curNumber);
        }

        for (int i = (int) Math.pow(2, nums.length) - 1; ; i--) {
            if (!numbers.contains(i)) {
                String result = Integer.toBinaryString(i);
                if (result.length() != nums.length) {
                    result = "0".repeat(nums.length - result.length()) + result;
                }
                return result;
            }
        }
    }
}
