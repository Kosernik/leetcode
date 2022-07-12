package MonthlyChallenges.Year22.July;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MatchsticksToSquare {
    public static void main(String[] args) {
        MatchsticksToSquare solution = new MatchsticksToSquare();

        int[][] tests = {
                {5969561,8742425,2513572,3352059,9084275,2194427,1017540,2324577,6810719,8936380,7868365,2755770,9954463,9912280,4713511},
                {1,1,2,2,2},
                {3,3,3,3,4},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,102},
                {1,3,5,7,1,3,5,6,1,2,4,6,4,6,5},
                {1,1,1,1,1,1,1,1,1,1,70,70,101,102,103}
        };

        boolean[] results = {
                false,
                true,
                false,
                false,
                false,
                false
        };

        int idx = 0;
        for (int[] test : tests) {
            boolean curResult = solution.makesquare(test);
            if (curResult != results[idx]) {
                System.out.println("Wrong result for test: " + Arrays.toString(test));
            }
            idx++;
        }
    }


    private Map<Integer, Map<String, Boolean>> memo;
    private int sideLength;

    /**
     * LeetCode #473. Matchsticks to Square.
     *
     * @param matchsticks - an array of lengths of sticks.
     * @return - True - if it is possible to form a square using all matchsticks, false - otherwise.
     */
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) return false;

        int perimeter = 0;
        for (int stick : matchsticks) {
            perimeter += stick;
        }
        if (perimeter % 4 != 0) return false;
        this.sideLength = perimeter / 4;
        this.memo = new HashMap<>();

        Arrays.sort(matchsticks);
        int start = 0, end = matchsticks.length-1;
        while (start < end) {
            int temp = matchsticks[start];
            matchsticks[start] = matchsticks[end];
            matchsticks[end] = temp;
            start++;
            end--;
        }

        return helper(matchsticks, 0, new int[4]);
    }

    private boolean helper(int[] sticks, int index, int[] sides) {
        String curLengthToString = sides[0] + "*" + sides[1] + "*" +sides[2] + "*" +sides[3];
        if (memo.containsKey(index) && memo.get(index).containsKey(curLengthToString)) {
            return memo.get(index).get(curLengthToString);
        }
        boolean result = false;

        if (index == sticks.length) {
            result = sides[0] == sides[1] && sides[2] == sides[3] && sides[1] == sides[2];

        } else {
            for (int i = 0; i < 4; i++) {
                int currSide = sides[i] + sticks[index];
                if (currSide > sideLength) continue;
                sides[i] = currSide;
                if (helper(sticks, index + 1, sides)) {
                    result = true;
                    break;
                }
                sides[i] -= sticks[index];
            }
        }

        Map<String, Boolean> prevCombinations = memo.getOrDefault(index, new HashMap<>());
        prevCombinations.put(curLengthToString, result);
        memo.put(index, prevCombinations);

        return result;
    }
}
