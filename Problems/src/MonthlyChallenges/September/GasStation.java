package MonthlyChallenges.September;

import java.util.Arrays;

public class GasStation {
    public static void main(String[] args) {
        GasStation solution = new GasStation();
        solution.testCanCompleteCircuit();
    }

    /**
     * Returns the starting gas station's index if you can travel around the circuit once in the clockwise direction,
     * otherwise return -1.
     *
     * Complexity - O(N^2)
     * Memory - O(N)
     *
     * @param gas - an array of positive integers representing amount of fuel on each station.
     * @param cost - an array of positive integers representing cost of traveling from i-th station to i+1 station.
     * @return - starting index of a route if it exists, -1 otherwise.
     */
    public int canCompleteCircuitBrute(int[] gas, int[] cost) {
        int length = gas.length;

        int[] balance = new int[length];
        for (int i = 0; i < length; i++) {
            balance[i] = gas[i] - cost[i];
        }

        for (int i = 0; i < length; i++) {
            if (balance[i] >= 0) {
                int currFuel = 0;
                for (int j = 0; j < length; j++) {
                    currFuel += balance[(j+i+length)%length];
                    if (currFuel < 0) break;
                }
                if (currFuel >= 0) return i;
            }
        }
        return -1;
    }

    private void testCanCompleteCircuit() {
        int[][][] tests = {
                {{1,2,3,4,5},{3,4,5,1,2}},
                {{2,3,4},{3,4,3}},
                {{1,3,4,5,7,9,8,2,1,3,4,5,5,7,4,6,8,2,4,8,1},{3,5,4,2,3,1,7,8,6,2,1,8,6,2,1,8,6,3,2,9,9}},
                {{5,1,2,3,4},{4,4,1,5,1}}
        };
        int[] results = {
                3,
                -1,
                2,
                4
        };

        int failed = 0;
        for (int i = 0; i < results.length; i++) {
            if (canCompleteCircuitBrute(tests[i][0], tests[i][1]) != results[i]) {
                failed++;
                System.out.println("Wrong result for test #" + i);
                System.out.println(Arrays.toString(tests[i][0]));
                System.out.println(Arrays.toString(tests[i][1]));
                System.out.println("Got: " + canCompleteCircuitBrute(tests[i][0], tests[i][1]));
                System.out.println("Should be:" + results[i]);
            }
        }

        System.out.println("Success rate: " + (results.length - failed) * 100.0 / results.length);
    }
}
