package MonthlyChallenges.Year26.June;

public class EarliestFinishTimeForLandAndWaterRidesI {

    /**
     * LeetCode №3633. Earliest Finish Time for Land and Water Rides I.
     *
     * @param landStartTime  - an array of start times for each land ride.
     * @param landDuration   - an array of durations of each land ride.
     * @param waterStartTime - an array of start times for each water ride.
     * @param waterDuration  - an array of durations of each water ride.
     * @return - the earliest possible time at which the tourist can finish exactly one land ride and exactly one water
     * ride.
     */
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int result = Integer.MAX_VALUE;

        int landEarlyFinish = landStartTime[0] + landDuration[0];

        for (int i = 1; i < landStartTime.length; i++) {
            int start = landStartTime[i];
            int finish = start + landDuration[i];

            if (finish < landEarlyFinish) {
                landEarlyFinish = finish;
            }
        }

        int waterEarlyFinish = waterStartTime[0] + waterDuration[0];

        for (int i = 0; i < waterStartTime.length; i++) {
            int start = waterStartTime[i];
            int duration = waterDuration[i];

            if (start >= landEarlyFinish) {
                result = Math.min(result, start + duration);
            } else {
                result = Math.min(result, landEarlyFinish + duration);
            }

            if ((start + duration) < waterEarlyFinish) {
                waterEarlyFinish = start + duration;
            }
        }

        for (int i = 0; i < landStartTime.length; i++) {
            if (landStartTime[i] >= waterEarlyFinish) {
                result = Math.min(result, landStartTime[i] + landDuration[i]);
            } else {
                result = Math.min(result, waterEarlyFinish + landDuration[i]);
            }
        }

        return result;
    }
}
