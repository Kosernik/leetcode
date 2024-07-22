package MonthlyChallenges.Year24.July;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortPeople {

    /**
     * LeetCode №2418. Sort the People.
     * <p>
     * Complexity - O(N + NlogN)
     * Memory - O(N + sorting memory)
     *
     * @param names   - a string of people`s names.
     * @param heights - a string of people`s heights.
     * @return - array 'names' sorted in descending order by the people's heights.
     */
    public String[] sortPeople(String[] names, int[] heights) {
        List<Pair> people = new ArrayList<>(names.length);
        for (int i = 0; i < names.length; i++) {
            people.add(new Pair(names[i], heights[i]));
        }
        Collections.sort(people);

        String[] result = new String[people.size()];
        int idx = 0;
        for (Pair name : people) {
            result[idx] = name.name;
            idx++;
        }
        return result;
    }

    static class Pair implements Comparable<Pair> {
        String name;
        int height;

        Pair(String name, int height) {
            this.name = name;
            this.height = height;
        }

        @Override
        public int compareTo(@NotNull Pair o) {
            return Integer.compare(o.height, this.height);
        }
    }
}
