package MonthlyChallenges.August;

import java.util.Arrays;

public class DistributeCandiesToPeople {
    public static void main(String[] args) {
        DistributeCandiesToPeople solution = new DistributeCandiesToPeople();
        solution.testDistributeCandies();
    }

    // O(N)
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];

        int currIdx = 0;                // index of current person
        int candiesLeft = candies;      // number of undistributed candies
        int currNumOfCandies = 1;       // current number of candies that we are giving

        // Distribute all candies until we ran out of them
        while (candiesLeft > 0) {
            // Giving next amount of candies to current person and going to next person (using modulo operator to loop
            // in circle).
            res[currIdx] += currNumOfCandies;
            currIdx = (currIdx+1) % num_people;

            // Decreasing number of candies left and calculating next number of candies, if number of candies is fewer
            // then needed,  we give all of remaining candies to next person.
            candiesLeft -= currNumOfCandies;
            currNumOfCandies = Math.min(candiesLeft, currNumOfCandies+1);
        }

        return res;
    }

    private void testDistributeCandies() {
        int[][] tests = {{7,4},{10,3},{7,5},{7,3},{22,3},{20,3},{1,3}};
        int[][] results = {{1,2,3,1},{5,2,3},{1,2,3,1,0},{2,2,3},{6,7,9},{5,7,8},{1,0,0}};

        int failed = 0;
        for (int i = 0; i < tests.length; i++) {
            int[] currResult = distributeCandies(tests[i][0], tests[i][1]);

            if (!Arrays.equals(currResult, results[i])) {
                failed++;
                System.out.println("Wrong result for test # " + i);
                System.out.println("Got: " + Arrays.toString(currResult) + " , instead of: " + Arrays.toString(results[i]));
            }
        }

        System.out.println("Success rate: " + (tests.length - failed) * 100.0 / tests.length);
    }
}
