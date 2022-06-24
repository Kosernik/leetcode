package MonthlyChallenges.Year22.June;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ConstructTargetArrayWithMultipleSums {
    public static void main(String[] args) {
        ConstructTargetArrayWithMultipleSums solution = new ConstructTargetArrayWithMultipleSums();

        int[][] tests = {
                {9,3,5},    //true
                {1,1,1,2},  //false
                {8,5},      //true
                {7},        //false
                {4096},     //false
                {2},        //false
                {1},        //true
                {1,1000000000},  //true
                {1,1000000000,1},//false
                {71,1000000000}, //true
                {1,2,3}          //false
        };

        boolean[] results = {
                true,false,true,false,false,false,true,true,false,true,false
        };

        if (tests.length != results.length) {
            System.out.println("Wrong input data!!");
        } else {
            int wrongResults = 0;
            for (int i = 0; i < tests.length; i++) {

                boolean res = solution.isPossible(tests[i]);
                if (res != results[i]) {
                    wrongResults++;
                    System.out.println("Wrong result for test #" + i);
                    System.out.println(Arrays.toString(tests[i]) + ", got " + res + ", instead of " + results[i]);
                }
            }

            System.out.println("The number of wrong results: " + wrongResults);
        }
    }

    /**
     * LeetCode #1354. Construct Target Array With Multiple Sums
     *
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param target - an array of positive integers.
     * @return - true if it is possible to construct the target array from arr, otherwise, return false.
     *           arr - is an array consisting of all 1`s
     */
    public boolean isPossible(int[] target) {
        if (target.length == 1) return (target[0] == 1);

        long sum = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int number : target) {
            sum += number;
            pq.offer(number);
        }

        while (pq.peek() > 1) {
            int curNumber = pq.remove();

            long remainder = sum - curNumber;
            if (remainder >= curNumber) return false;

            int number = (int) (curNumber % remainder);
            if (number == 0) {
                number = (int) remainder;
            }
            sum = sum - (curNumber - number);

            pq.offer(number);
        }

        return true;
    }

}
