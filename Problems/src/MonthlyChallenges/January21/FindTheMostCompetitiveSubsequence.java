package MonthlyChallenges.January21;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTheMostCompetitiveSubsequence {
    public static void main(String[] args) {
        FindTheMostCompetitiveSubsequence solution = new FindTheMostCompetitiveSubsequence();
        int[] test1 = {2,4,3,3,5,4,9,6};
        int k1 = 4;
        int[] res1 = solution.mostCompetitive(test1, k1);

        System.out.println(Arrays.toString(res1));
    }

    // LeetCode #1673.
    public int[] mostCompetitive(int[] nums, int k) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peekLast()] && (length - i + stack.size()) > k) {
                stack.removeLast();
            }
            if (stack.size() < k) {
                stack.offerLast(i);
            }
        }

        int[] result = new int[k];

        for (int i = k-1; i >= 0; i--) {
            result[i] = nums[stack.removeLast()];
        }
        return result;
    }

    public int[] mostCompetitiveTLEToo(int[] nums, int k) {
        int[] result = new int[k];

        int length = nums.length;
        int prevMinIdx = 0;


        for (int i = 0; i < k; i++) {
            int[] mins = minValue(nums, prevMinIdx, length - k + i);
            result[i] = mins[0];
            prevMinIdx = mins[1]+1;
        }

        return result;
    }

    private int[] minValue(int[] nums, int startIdx, int endIdx) {
        int min = nums[startIdx];
        int minIdx = startIdx;

        for (int i = startIdx; i <= endIdx; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
        }

        return new int[] {min, minIdx};
    }

    public int[] mostCompetitiveTLE(int[] nums, int k) {
        if (k >= nums.length) return Arrays.copyOf(nums, nums.length);

        int length = nums.length;
        List<Integer> candidates = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            int currDigit = nums[i];
            int startIdx = (length- i) > k ? 0 : (k - (length- i));

            for (int j = startIdx; j < k; j++) {
                if (j >= candidates.size()) {
                    candidates.add(currDigit);
                    break;
                }
                if (candidates.get(j) > currDigit) {
                    candidates = candidates.subList(0,j);
                    candidates.add(currDigit);
                    break;
                }
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = candidates.get(i);
        }
        return result;
    }
}
