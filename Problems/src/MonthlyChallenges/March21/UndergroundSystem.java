package MonthlyChallenges.March21;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {
    private final Map<String, Map<String, long[]>> times;
    private final Map<Integer, Pair> unfinishedRoutes;

    // LeetCode #1396.
    public UndergroundSystem() {
        this.times = new HashMap<>();
        this.unfinishedRoutes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        this.unfinishedRoutes.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        if (this.unfinishedRoutes.containsKey(id)) {
            Pair route = this.unfinishedRoutes.get(id);
            String startStation = route.stationName;

            if (!this.times.containsKey(startStation)) {
                this.times.put(startStation, new HashMap<>());
            }

            Map<String, long[]> destinations = this.times.get(startStation);

            if (!destinations.containsKey(stationName)) {
                destinations.put(stationName, new long[2]);
            }

            long[] prev = destinations.get(stationName);
            prev[0] += t - route.t;
            prev[1]++;
            destinations.put(stationName, prev);

            this.unfinishedRoutes.remove(id);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        if (this.times.containsKey(startStation)) {
            Map<String, long[]> destinations = this.times.get(startStation);

            long[] travels = destinations.get(endStation);

            return travels[0] * 1.0 / travels[1];
        } else {
            return 0;
        }
    }

    class Pair {
        String stationName;
        int t;

        public Pair(String stationName, int t) {
            this.stationName = stationName;
            this.t = t;
        }
    }
}
