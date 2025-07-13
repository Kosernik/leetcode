package MonthlyChallenges.Year25.July;

import java.util.Arrays;

public class MaximumMatchingOfPlayersWithTrainers {

    /**
     * LeetCode №2410. Maximum Matching of Players With Trainers.
     * <p>
     * Complexity  - O(NlogN + MlogM) N = players.length, M = trainers.length.
     * Memory -  O(sorting complexity) + O(1)
     * <p>
     * The i-th player can match with the j-th trainer if the player's ability is less than or equal to the trainer's
     * training capacity. Additionally, the i-th player can be matched with at most one trainer, and the j-th trainer
     * can be matched with at most one player.
     *
     * @param players  - an array of positive integers.
     * @param trainers - an array of positive integers.
     * @return - the maximum number of matchings between players and trainers that satisfy these conditions.
     */
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int matches = 0;
        int availableTrainer = 0;

        for (int player : players) {
            while (availableTrainer < trainers.length && trainers[availableTrainer] < player) {
                availableTrainer++;
            }
            if (availableTrainer == trainers.length) break;

            matches++;
            availableTrainer++;
        }

        return matches;
    }
}
