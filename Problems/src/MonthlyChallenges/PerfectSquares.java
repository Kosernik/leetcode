package MonthlyChallenges;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {
    public static void main(String[] args) {
        PerfectSquares perfectSquares = new PerfectSquares();

        int[] tests = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,25,26};
        int[] results = {0,1,2,3,1,2,3,4,2,1,2,3,3,2,1,2};
        float failed = 0.0f;
        for (int i = 0; i < tests.length; i++) {
            int res = perfectSquares.numSquares(tests[i]);
            if (res != results[i]) {
                failed++;
                System.out.println("Result for number " + tests[i] + " is: " + res + " , should be: " + results[i]);
            }
        }
        System.out.println((tests.length-failed)*100/tests.length + "%");
    }

    public int numSquares(int n) {
        if (n <= 1) {
            return n;
        }

        //Coins (squares)
        List<Integer> squares = new ArrayList<>();
        //Array of numbers of coins (squares)
        int[] numberOfWaysToMakeN = new int[n+1];
        int currNumber = 1;

        //Creating coins (squares)
        while (currNumber*currNumber <= n){
            numberOfWaysToMakeN[currNumber*currNumber] = 1;
            squares.add(currNumber*currNumber);
            currNumber++;
        }

        //DP method for solving coin change problem
        for (int i = 2; i <= n; i++) {
            int currentBest = numberOfWaysToMakeN[i] == 0 ? Integer.MAX_VALUE : numberOfWaysToMakeN[i];
            for (int square : squares) {
                if (i - square > 0) {
                    currentBest = Math.min(currentBest, numberOfWaysToMakeN[i-square]+1);
                }
            }
            numberOfWaysToMakeN[i] = currentBest;
        }

        return numberOfWaysToMakeN[n];
    }
}
