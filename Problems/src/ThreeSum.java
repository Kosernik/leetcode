import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        solution.testThreeSum();
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }

    private Map<Integer, List<Integer>> indexes;
    public List<List<Integer>> threeSum(int[] nums) {
        indexes = new HashMap<>();
        List<List<Integer>> triplets = new ArrayList<>();
        if (nums == null || nums.length <= 2) return triplets;

        boolean foundNegative = false, foundPositive = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) foundPositive = true;
            else if (nums[i] < 0) foundNegative = true;
            if (!indexes.containsKey(nums[i])) {
                indexes.put(nums[i], new ArrayList<>());
            }
            indexes.get(nums[i]).add(i);
        }

        if (!foundNegative || !foundPositive) {
            if (!indexes.containsKey(0) || indexes.get(0).size() < 3) return triplets;
            List<Integer> res = new ArrayList<>();
            res.add(0); res.add(0); res.add(0);
            triplets.add(res);
            return triplets;
        }

        Set<List<Integer>> tempSet = new HashSet<>();
        for (int i = 0, length = nums.length-2; i < length; i++) {
            List<List<Integer>> currList = twoSum(nums, nums[i], i+1);
            if (currList.size() > 0) {
                tempSet.addAll(currList);
            }
        }

        triplets.addAll(tempSet);
        return triplets;
    }

    private List<List<Integer>> twoSum(int[] nums, int target, int startIndex) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = startIndex; i < nums.length; i++) {
            long sum = -1L * ((long)target + nums[i]);
            if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) continue;
            if (indexes.containsKey((int)sum)) {
                List<Integer> idxs = indexes.get((int)sum);
                for (int idx : idxs) {
                    if (idx <= i) continue;
                    List<Integer> currList = new ArrayList<>();
                    currList.add(target); currList.add(nums[i]); currList.add((int)sum);
                    Collections.sort(currList);
                    result.add(currList);
                    break;
                }
            }
        }

        return result;
    }

    private void testThreeSum () {
        int[][] tests = {
                {-1, 0, 1, 2, -1, -4},
                {Integer.MIN_VALUE, Integer.MIN_VALUE, -12, -22, 0, -7, -12547},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 7, 8 , 15, 17, 51, 1},
                {0,0,0,0,0,0,1,2,3,4,5,6,7,8,9},
                {-1,-1,-1,-1,-1,-1,-1,0,1,1,1,1,1,1,1},
                {Integer.MIN_VALUE, -78, -215, -102, 0, 1, 2, 135, 12428, Integer.MAX_VALUE}};

        for (int[] test : tests) {
            List<List<Integer>> currentResult = threeSum(test);
            if (currentResult.size() == 0) {
                System.out.println("No triplets for test: " + Arrays.toString(test));
            } else {
                for (List<Integer> lst : currentResult) {
                    System.out.println(lst.toString());
                }
            }
            System.out.println("-----------");
        }
    }
}
