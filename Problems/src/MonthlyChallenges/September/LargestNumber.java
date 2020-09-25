package MonthlyChallenges.September;

import java.util.*;

public class LargestNumber {
    public static void main(String[] args) {
        LargestNumber solution = new LargestNumber();

        int[] test0 = {10,2};
        System.out.println(solution.largestNumber(test0));

        int[] test1 = {3,30,34,5,9};
        System.out.println(solution.largestNumber(test1));

        int[] test2 = {3,30,34,5,9,7,27,72,23,14,1};
        System.out.println(solution.largestNumber(test2));
    }

    /**
     * Arranging numbers from the input array such they form the largest number
     *
     * Complexity - O(NLogN)
     * Memory - O(N)
     *
     * @param nums - array if non-negative integers
     * @return - string representation of the largest number that can be build by rearranging input array.
     */
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        else if (nums.length == 1) return new String(String.valueOf(nums[0]));

        StringBuilder builder = new StringBuilder();

        String[] parsed = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            parsed[i] = String.valueOf(nums[i]);
        }

        Comparator<String> myComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String case1 = o1 + o2;
                String case2 = o2 + o1;

                // for reverse order sorting
                return case2.compareTo(case1);
            }
        };

        Arrays.sort(parsed, myComparator);

        // Only zeroes in the input array
        if (parsed[0].charAt(0) == '0') return "0";

        for (String str : parsed) {
            builder.append(str);
        }

        return builder.toString();
    }
}
