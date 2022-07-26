package Problems;

import java.util.*;

public class ThreeSumClosest {
    public static void main(String[] args) {
        ThreeSumClosest solution = new ThreeSumClosest();

        int[] test0nums = {1, 1, 1, 0};
        int test0target = -100;
        int result0 = 2;

        System.out.println(solution.threeSumClosest(test0nums, test0target) == result0);

        int[] test1nums = {321, 413, 82, 812, -646, -858, 729, 609, -339, 483, -323, -399, -82, -455, 18, 661, 890, -328, -311, 520, -865, -174, 55, 685, -636, 462, -172, -696, -296, -832, 766, -808, -763, 853, 482, 411, 703, 655, -793, -121, -726, 105, -966, -471, 612, 551, -257, 836, -94, -213, 511, 317, -293, 279, -571, 242, -519, 386, -670, -806, -612, -433, -481, 794, 712, 378, -325, -564, 477, 169, 601, 971, -300, -431, -152, 285, -899, 978, -419, 708, 536, -816, -335, 284, 384, -922, -941, 633, 934, 497, -351, 62, 392, -493, -44, -400, 646, -912, -864, 835, 713, -12, 322, -228, 340, -42, -307, -580, -802, -914, -142, 575, -684, -415, 718, -579, 759, 579, 732, -645, 525, 114, -880, -603, -699, -101, -738, -887, 327, 192, 747, -614, 393, 97, -569, 160, 782, -69, 235, -598, -116, 928, -805, -76, -521, 671, 417, 600, -442, 236, 831, 637, -562, 613, -705, -158, -237, -299, 808, -734, 364, 919, 251, -163, -343, 899};
        int test1target = 2218;
        int result1 = 2218;

        System.out.println(solution.threeSumClosest(test1nums, test1target) == result1);
    }

    /**
     * LeetCode #16. 3Sum Closest.
     *
     * Complexity - O(N^2)
     * Memory - O(N^2)
     *
     * @param nums   - an array of integers.
     * @param target - required sum of 3 integers.
     * @return - the sum of 3 integers such that this sum is closest to target.
     */
    public int threeSumClosestSlow(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }

        NavigableMap<Integer, List<int[]>> twoSums = new TreeMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
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


    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];
        if (nums.length == 3) {
            return result;
        }

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int curSum = nums[i] + nums[left] + nums[right];
                if (curSum == target) return target;

                if (Math.abs(target - result) > Math.abs(target - curSum)) {
                    result = curSum;
                }
                if (curSum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return result;
    }
}
