package MonthlyChallenges.August;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        if (nums == null || nums.length < 2) return duplicates;

        Set<Integer> uniques = new HashSet<>();
        for (int number : nums) {
            if (!uniques.add(number)) {
                duplicates.add(number);
            }
        }

        return duplicates;
    }
}
