package MonthlyChallenges.Year23.December;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DestinationCity {

    /**
     * LeetCode №1436. Destination City.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param paths - a list of paths, where paths[i] = [StartCity, DestinationCity].
     * @return - the destination city, that is, the city without any path outgoing to another city.
     */
    public String destCity(List<List<String>> paths) {
        //  start -> end
        Map<String, String> starts = new HashMap<>();
        //  end -> start
        Map<String, String> ends = new HashMap<>();


        for (List<String> path : paths) {
            String start = path.get(0);
            String end = path.get(1);

            if (ends.containsKey(start)) {
                String oldStart = ends.get(start);

                starts.remove(oldStart);
                ends.remove(start);
                start = oldStart;
            }
            if (starts.containsKey(end)) {
                String oldEnd = starts.get(end);

                ends.remove(oldEnd);
                starts.remove(end);
                end = oldEnd;
            }


            starts.put(start, end);
            ends.put(end, start);
        }
        for (String end : ends.keySet()) {
            return end;
        }
        return "";
    }
}
