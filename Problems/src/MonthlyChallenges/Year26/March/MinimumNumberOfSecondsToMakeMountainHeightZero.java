package MonthlyChallenges.Year26.March;

import java.util.PriorityQueue;

public class MinimumNumberOfSecondsToMakeMountainHeightZero {

    /**
     * LeetCode №3296. Minimum Number of Seconds to Make Mountain Height Zero.
     *
     * @param mountainHeight - the height of the mountain.
     * @param workerTimes    - an array of work times of each worker.
     * @return - the minimum number of time required for the workers to make the height of the mountain 0.
     */
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        if (workerTimes.length == 1) {
            return workerTimes[0] * (long) mountainHeight * (mountainHeight + 1L) / 2;
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        for (int worker : workerTimes) {
            pq.offer(new long[]{worker, worker, 1});
        }

        long result = 0L;

        for (int height = 0; height < mountainHeight; height++) {
            long[] worker = pq.poll();

            long curTime = worker[0];
            result = curTime;

            worker[0] = curTime + worker[1] * (worker[2] + 1);
            worker[2]++;
            pq.offer(worker);
        }

        return result;
    }
}
