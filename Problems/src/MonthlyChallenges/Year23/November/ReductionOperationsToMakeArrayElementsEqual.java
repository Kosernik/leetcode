package MonthlyChallenges.Year23.November;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ReductionOperationsToMakeArrayElementsEqual {
    public static void main(String[] args) {
        ReductionOperationsToMakeArrayElementsEqual solution = new ReductionOperationsToMakeArrayElementsEqual();

        int[] test0 = {5, 1, 3};
        System.out.println(solution.reductionOperations(test0) == 3);
    }

    /**
     * LeetCode №1887. Reduction Operations to Make the Array Elements Equal.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @return - the number of operations to make array elements equal.
     */
    public int reductionOperations(int[] nums) {
        int result = 0;

        Map<Integer, Integer> counts = new HashMap<>();
        for (int number : nums) {
            counts.put(number, counts.getOrDefault(number, 0) + 1);
        }
        if (counts.size() == 1) return result;

        int[][] unique = new int[counts.size()][2];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            unique[idx][0] = entry.getKey();
            unique[idx][1] = entry.getValue();
            idx++;
        }
        Arrays.sort(unique, Comparator.comparingInt(a -> a[0]));

        for (int i = unique.length - 1; i > 0; i--) {
            result += unique[i][1];
            unique[i - 1][1] += unique[i][1];
        }

        return result;
    }
}
