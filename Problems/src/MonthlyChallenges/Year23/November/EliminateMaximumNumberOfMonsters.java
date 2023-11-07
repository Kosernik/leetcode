package MonthlyChallenges.Year23.November;

import java.util.PriorityQueue;

public class EliminateMaximumNumberOfMonsters {

    /**
     * LeetCode #1921. Eliminate Maximum Number of Monsters.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param dist  - an array of distances of monsters from the city.
     * @param speed - an array of speeds of each monster.
     * @return - the total number of eliminated monsters.
     */
    public int eliminateMaximum(int[] dist, int[] speed) {
        int eliminatedMonsters = 0;
        double curTime = 0.0;

        PriorityQueue<Double> arrivalTime = new PriorityQueue<>();
        for (int i = 0; i < dist.length; i++) {
            arrivalTime.offer(dist[i] / (double) speed[i]);
        }

        while (!arrivalTime.isEmpty()) {
            double curMonster = arrivalTime.poll();
            if (curMonster <= curTime) return eliminatedMonsters;

            eliminatedMonsters++;
            curTime += 1.0;
        }

        return eliminatedMonsters;
    }
}
