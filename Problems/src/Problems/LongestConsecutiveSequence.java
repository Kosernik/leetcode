package Problems;

import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();

        int[] test = {-7,-1,3,-9,-4,7,-3,2,4,9,4,-9,8,-7,5,-1,-7};
        System.out.println(solution.longestConsecutive(test));
    }

    /**
     * LeetCode #128. Longest Consecutive Sequence.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @return - the length of the longest consecutive elements sequence.
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        else if (nums.length == 1) return 1;

        int result = 1;
        Map<Integer, Integer> starts = new HashMap<>();
        Map<Integer, Integer> ends = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int number : nums) {
            if (!visited.add(number)) continue;

            int low = number-1;
            int high = number+1;

            int[] pair = {ends.getOrDefault(low, number), starts.getOrDefault(high, number)};

            result = Math.max(result, pair[1]-pair[0]+1);

            ends.remove(low);
            starts.remove(high);

            starts.put(pair[0], pair[1]);
            ends.put(pair[1], pair[0]);
        }

        return result;
    }
}
