package MonthlyChallenges.Year25.July;

import java.util.HashSet;
import java.util.Set;

public class BitwiseORsOfSubarrays {

    /**
     * LeetCode №898. Bitwise ORs of Subarrays.
     *
     * @param arr - an array of integers.
     * @return - the number of distinct bitwise ORs of all the non-empty subarrays of arr.
     */
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();

        Set<Integer> current = new HashSet<>();
        current.add(0);

        for (int number : arr) {
            Set<Integer> next = new HashSet<>();

            for (Integer computed : current) {
                next.add(computed | number);
            }

            next.add(number);
            current = next;

            result.addAll(current);
        }

        return result.size();
    }
}
