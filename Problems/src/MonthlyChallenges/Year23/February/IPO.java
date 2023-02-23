package MonthlyChallenges.Year23.February;

import java.util.PriorityQueue;

public class IPO {

    /**
     * LeetCode #502. IPO.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param k       - the maximum number of projects to finish.
     * @param w       - start capital.
     * @param profits - an array of profits for each project.
     * @param capital - an array of required capital to start a project.
     * @return - the final maximized capital after finishing at most "k" projects.
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        //  project with the lowest capital goes first
        PriorityQueue<Pair> allProjects = new PriorityQueue<>((a, b) -> Integer.compare(a.capital, b.capital));

        //  project with the highest profit goes first
        PriorityQueue<Pair> plannedProjects = new PriorityQueue<>((a, b) -> Integer.compare(b.profit, a.profit));

        for (int i = 0; i < profits.length; i++) {
            Pair pair = new Pair(profits[i], capital[i]);

            if (pair.capital <= w) {
                plannedProjects.add(pair);
            } else {
                allProjects.add(pair);
            }
        }

        int totalCapital = w;
        int projectsFinished = 0;

        while (projectsFinished < k && !plannedProjects.isEmpty()) {
            totalCapital += plannedProjects.poll().profit;

            while (!allProjects.isEmpty() && allProjects.peek().capital <= totalCapital) {
                plannedProjects.offer(allProjects.poll());
            }

            projectsFinished++;
        }

        return totalCapital;
    }

    class Pair {
        int profit;
        int capital;

        public Pair(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
}
