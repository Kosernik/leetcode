package Problems;

import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {
    public static void main(String[] args) {
        DeleteAndEarn solution = new DeleteAndEarn();

        int[] test2 = {4,10,10,8,1,4,10,9,7,6};
        System.out.println(solution.deleteAndEarn(test2));
    }

    /**
     * LeetCode #740. Delete and Earn.
     *
     * Complexity - O(N+M), N = nums.length, M = max value of a number in nums.
     * Memory - O(N+M)
     *
     * @param nums - an array of positive integers.
     * @return - the maximum number of points.
     */
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();

        int maxVal = -1;
        for (int number : nums) {
            maxVal = Math.max(maxVal, number);
            count.put(number, count.getOrDefault(number, 0) + 1);
        }

        int[] houses = new int[maxVal+1];
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            houses[entry.getKey()] = entry.getKey() * entry.getValue();
        }

        for (int house = 2; house < houses.length; house++) {
            houses[house] = Math.max(houses[house-1], houses[house] + houses[house-2]);
        }

        return houses[houses.length-1];
    }
}
