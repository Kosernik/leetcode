package Problems;

import java.util.*;

public class AvoidFloodInTheCity {

    /**
     * LeetCode #1488. Avoid Flood in The City.
     *
     * Complexity - O(N*logN)
     * Memory - O(N)
     *
     * @param rains - an array of positive integers.
     * @return - the resulting array.
     */
    public int[] avoidFlood(int[] rains) {
        int[] result = new int[rains.length];

        Map<Integer, Integer> rainOverLake = new HashMap<>();
        NavigableSet<Integer> zeroes = new TreeSet<>();

        for (int i = 0; i < rains.length; i++) {
            int currentLake = rains[i];
            if (currentLake == 0) {
                zeroes.add(i);
                result[i] = 1;
            } else {
                if (rainOverLake.containsKey(currentLake)) {
                    Integer prevDryDay = zeroes.ceiling(rainOverLake.get(currentLake));
                    if (prevDryDay == null) {
                        return new int[] {};
                    }
                    result[prevDryDay] = currentLake;
                    zeroes.remove(prevDryDay);
                }
                result[i] = -1;
                rainOverLake.put(currentLake, i);
            }
        }

        return result;
    }
}
