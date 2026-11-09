package MonthlyChallenges.Year26.November;

import java.util.*;

public class FindServersThatHandledMostNumberOfRequests {

    /**
     * LeetCode №1606. Find Servers That Handled Most Number of Requests.
     *
     * @param k       - the total number of servers.
     * @param arrival - an array representing the start times for each task. arrival is strictly increasing.
     * @param load    - an array representing the duration times for each task.
     * @return - a list containing the IDs (0-indexed) of the busiest servers.
     */
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] processed = new int[k];

        NavigableSet<Integer> free = new TreeSet<>();
        for (int i = 0; i < k; i++) free.add(i);

        PriorityQueue<Job> busy = new PriorityQueue<>();

        for (int i = 0; i < arrival.length; i++) {
            int startTime = arrival[i];
            int duration = load[i];

            while (!busy.isEmpty() && busy.peek().time <= startTime) {
                free.add(busy.poll().id);
            }

            if (free.isEmpty()) continue;

            int targetID = i % k;
            Integer serverID = free.ceiling(targetID);

            if (serverID == null) {
                serverID = free.pollFirst();
            } else {
                free.remove(serverID);
            }

            busy.offer(new Job(serverID, startTime + duration));
            processed[serverID]++;
        }

        return getBusiest(processed);
    }

    private List<Integer> getBusiest(int[] processed) {
        List<Integer> result = new ArrayList<>();
        int maxJobs = 0;
        for (int p : processed) maxJobs = Math.max(maxJobs, p);

        for (int i = 0; i < processed.length; i++) {
            if (processed[i] == maxJobs) result.add(i);
        }

        return result;
    }

    static class Job implements Comparable<Job> {
        int id;
        int time;

        Job(int id, int time) {
            this.id = id;
            this.time = time;
        }

        @Override
        public int compareTo(Job other) {
            return Integer.compare(this.time, other.time);
        }
    }
}
