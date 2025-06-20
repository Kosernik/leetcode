package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        System.out.println(testRes.size()); // 33
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
     * <p>
     * Complexity - O(N^3)
     * Memory - O(1)
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

        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            long num = nums[i];

            for (int j = i + 1; j < length - 2; j++) {
                if (j > (i + 1) && nums[j] == nums[j - 1]) continue;

                long curSum = num + nums[j];
                long remainingSum = targetL - curSum;

                if (remainingSum < curSum) {
                    break;
                }

                int left = j + 1, right = length - 1;
                while (left < right) {
                    if ((remainingSum - nums[left] - nums[right]) == 0) {
                        List<Integer> quadruplet = new ArrayList<>();
                        quadruplet.add(nums[i]);
                        quadruplet.add(nums[j]);
                        quadruplet.add(nums[left]);
                        quadruplet.add(nums[right]);
                        result.add(quadruplet);

                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if ((remainingSum - nums[left] - nums[right]) > 0) {
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                    } else {
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
