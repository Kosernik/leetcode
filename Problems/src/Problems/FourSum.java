package Problems;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        FourSum solution = new FourSum();

        int[] testTLE = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 20, 20, 20, 20,
                20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30,
                30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40,
                40, 40, 40, 40, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 60, 60,
                60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 70, 70, 70, 70, 70, 70, 70, 70,
                70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80,
                80, 80, 80, 80, 80, 80, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90};
        int testTarget = 200;

        List<List<Integer>> testRes = solution.fourSum(testTLE, testTarget);
        System.out.println(testRes.size());
        for (List<Integer> res : testRes) {
            System.out.println(res);
        }
        //[[10,10,90,90],[10,20,80,90],[10,30,70,90],[10,30,80,80],[10,40,60,90],
        // [10,40,70,80],[10,50,50,90],[10,50,60,80],[10,50,70,70],[10,60,60,70],
        // [20,20,70,90],[20,20,80,80],[20,30,60,90],[20,30,70,80],[20,40,50,90],
        // [20,40,60,80],[20,40,70,70],[20,50,50,80],[20,50,60,70],[20,60,60,60],
        // [30,30,50,90],[30,30,60,80],[30,30,70,70],[30,40,40,90],[30,40,50,80],
        // [30,40,60,70],[30,50,50,70],[30,50,60,60],[40,40,40,80],[40,40,50,70],
        // [40,40,60,60],[40,50,50,60],[50,50,50,50]]
    }

    /**
     * LeetCode №18. 4Sum.
     * TLE
     *
     * @param nums   - an array of integers.
     * @param target - the target sum.
     * @return - an array of all the unique quadruplets that sum up to target.
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        int length = nums.length;
        long targetL = (long) target;

        Arrays.sort(nums);
        Map<Long, List<int[]>> pairSums = new HashMap<>();
        Set<String> used = new HashSet<>();

        for (int i = 0; i < length - 1; i++) {
            int num = nums[i];
            for (int j = i + 1; j < length; j++) {
                int[] pair = new int[2];
                pair[0] = i;
                pair[1] = j;
                long sum = num + nums[j];

                if (!pairSums.containsKey(sum)) {
                    pairSums.put(sum, new ArrayList<>());
                }

                pairSums.get(sum).add(pair);
            }
        }

        for (int i = 0; i < length - 3; i++) {
            int num = nums[i];
            for (int j = i + 1; j < length - 2; j++) {
                int curNum = nums[j];
                long remainder = targetL - num - curNum;

                if (!pairSums.containsKey(remainder)) continue;

                for (int[] pair : pairSums.get(remainder)) {
                    if (pair[0] == i || pair[0] == j || pair[1] == i || pair[1] == j) continue;

                    List<Integer> combination = new ArrayList<>();
                    combination.add(num);
                    combination.add(curNum);
                    combination.add(nums[pair[0]]);
                    combination.add(nums[pair[1]]);

                    Collections.sort(combination);

                    if (!used.contains(combination.toString())) {
                        used.add(combination.toString());

                        result.add(combination);
                    }
                }
            }
        }

        return result;
    }
}
