package MonthlyChallenges.Year21.January21;

import java.util.Arrays;

public class BoatsToSavePeople {
    /**
     * LeetCode #881.
     *
     * @param people - array of weights of people.
     * @param limit  - weight limit of each boat.
     * @return - minimum number of boats.
     */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int boats = 0;
        int lightest = 0;
        int heaviest = people.length - 1;

        while (lightest < heaviest) {
            if (people[heaviest] + people[lightest] <= limit) {
                lightest++;
            }

            heaviest--;
            boats++;
        }
        if (lightest == heaviest) boats++;

        return boats;
    }
}
