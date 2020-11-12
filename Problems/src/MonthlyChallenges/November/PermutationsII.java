package MonthlyChallenges.November;

import Utils.ListNode;

import java.util.*;

public class PermutationsII {
    public static void main(String[] args) {
        PermutationsII solution = new PermutationsII();

        List<List<Integer>> testSol = solution.permuteUnique(new int[] {1,2,3,4,5,6,5,2});
        System.out.println(testSol.size());
        System.out.println(testSol.get(0));
    }

    private final Set<String> set = new HashSet<>();
    private final List<List<Integer>> permutations = new ArrayList<>();

    /**
     * Returns a list of all unique permutations of given numbers.
     *
     * Complexity - O(N!)
     * Memory - O(N!)
     *
     * @param nums - array of integers.
     * @return - list of all unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> numbers = getList(nums);
        permute(numbers, new ArrayList<>(), nums.length);
        return permutations;
    }

    private void permute (List<Integer> numbers, List<Integer> permutation, int length) {
        if (permutation.size() == length) {
            if (set.add(getString(permutation))) {
                List<Integer> copy = new ArrayList<>(permutation);
                this.permutations.add(copy);
            }
        } else {
            for (int i = 0, len = numbers.size(); i < len; i++) {
                int curr = numbers.remove(i);
                permutation.add(curr);
                permute(numbers, permutation, length);
                permutation.remove(permutation.size()-1);
                numbers.add(i, curr);
            }
        }
    }

    private List<Integer> getList(int[] permutation) {
        List<Integer> list = new ArrayList<>();
        for (int i : permutation) list.add(i);
        return list;
    }
    private String getString(List<Integer> permutation) {
        StringBuilder builder = new StringBuilder();
        for (Integer num : permutation) {
            builder.append(num);
            builder.append("-");
        }
        return builder.toString();
    }
}
