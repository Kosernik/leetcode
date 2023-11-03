package MonthlyChallenges.Year23.November;

import java.util.ArrayList;
import java.util.List;

public class BuildArrayWithStackOperations {

    /**
     * LeetCode #1441. Build an Array With Stack Operations.
     * <p>
     * Complexity - O(N), N = target.length.
     * Memory - O(1)
     *
     * @param target - an array of positive integers.
     * @param n      - the total number of integers in a stack.
     * @return - any valid combination of stack commands to create target array from the stream of integers in the
     * range [1, n].
     */
    public List<String> buildArray(int[] target, int n) {
        String PUSH = "Push";
        String POP = "Pop";

        List<String> result = new ArrayList<>();

        int prev = 0;

        for (int curNum : target) {
            int missed = curNum - prev - 1;

            for (int j = 0; j < missed; j++) {
                result.add(PUSH);
                result.add(POP);
            }
            result.add(PUSH);

            prev = curNum;
        }

        return result;
    }
}
