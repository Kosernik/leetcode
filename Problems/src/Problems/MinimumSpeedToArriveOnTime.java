package Problems;

public class MinimumSpeedToArriveOnTime {

    /**
     * LeetCode #1870. Minimum Speed to Arrive on Time.
     *
     * Complexity - O(N*logM), N = dist.length, M = 10_000_000(maximum value of dist).
     * Memory - O(1)
     *
     * @param dist - An array of positive integers.
     * @param hour - A positive double.
     * @return - The minimum positive integer speed.
     */
    public int minSpeedOnTime(int[] dist, double hour) {
        if (Math.ceil(hour) < dist.length) {
            return -1;
        }
        int lowSpeed = 1, highSpeed = 10_000_000, candidateSpeed;

        while (lowSpeed < highSpeed) {
            candidateSpeed = (highSpeed-lowSpeed)/2 + lowSpeed;
            double candidateTime = getTravelTime(dist, candidateSpeed);

            if (candidateTime > hour) {
                lowSpeed = candidateSpeed + 1;
            } else {
                highSpeed = candidateSpeed;
            }
        }

        return lowSpeed;
    }

    private double getTravelTime(int[] dist, int speed) {
        double time = 0.0;

        for (int i = 0; i < dist.length-1; i++) {
            time += Math.ceil(dist[i]/ (double)speed);
        }
        time += dist[dist.length-1] / (double) speed;

        return time;
    }
}
