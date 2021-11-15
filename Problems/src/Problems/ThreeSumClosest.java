package Problems;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

public class ThreeSumClosest {
    public static void main(String[] args) {
        ThreeSumClosest solution = new ThreeSumClosest();

        int[] test0nums = {-1,2,1,-4,-1,2,1,-4,1,7,52,6,7,1,2,32,8,4};
        int test0target = -8;

        System.out.println(solution.threeSumClosest(test0nums, test0target));
    }

    /**
     * LeetCode #16. 3Sum Closest.
     *
     * Complexity - O(N^2)
     * Memory - O(N^2)
     *
     * @param nums - an array of integers.
     * @param target - required sum of 3 integers.
     * @return - the sum of 3 integers such that this sum is closest to target.
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }

        NavigableMap<Integer, List<int[]>> twoSums = new TreeMap<>();

        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int curSum = nums[i] + nums[j];
                int[] idxs = {i, j};

                List<int[]> existingLst = twoSums.getOrDefault(curSum, new ArrayList<>());
                existingLst.add(idxs);
                twoSums.put(curSum, existingLst);
            }
        }

        int result = nums[0] + nums[1] + nums[2];
        int delta = Math.abs(target - result);

        for (int i = 0; i < nums.length; i++) {
            int curTarget = target - nums[i];

            if (twoSums.containsKey(curTarget)) {
                List<int[]> existingLst = twoSums.get(curTarget);
                for (int[] idx : existingLst) {
                    if (idx[0] != i && idx[1] != i) return target;
                }
            }

            Integer lowest = twoSums.lowerKey(curTarget);
            Integer upper = twoSums.higherKey(curTarget);

            if (lowest != null) {
                if (validIndices(i, twoSums.get(lowest))) {
                    int curDelta = Math.abs(curTarget - lowest);
                    if (curDelta < delta) {
                        result = nums[i] + lowest;
                        delta = curDelta;
                    }
                }
            }
            if (upper != null) {
                if (validIndices(i, twoSums.get(upper))) {
                    int curDelta = Math.abs(curTarget - upper);
                    if (curDelta < delta) {
                        result = nums[i] + upper;
                        delta = curDelta;
                    }
                }
            }
        }

        return result;
    }

    private boolean validIndices(int idx, List<int[]> existingLst) {
        for (int[] idxs : existingLst) {
            if (idxs[0] != idx && idxs[1] != idx) {
                return true;
            }
        }
        return false;
    }
}
