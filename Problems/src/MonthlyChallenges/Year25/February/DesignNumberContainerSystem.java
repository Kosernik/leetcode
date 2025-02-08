package MonthlyChallenges.Year25.February;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

public class DesignNumberContainerSystem {

    /**
     * LeetCode №2349. Design a Number Container System.
     */
    class NumberContainers {
        private Map<Integer, Integer> containers = new HashMap<>();
        private Map<Integer, NavigableSet<Integer>> indices = new HashMap<>();

        public NumberContainers() {

        }

        public void change(int index, int number) {
            if (containers.containsKey(index)) {    // remove old number from the index
                int prevNumber = containers.get(index);
                if (prevNumber == number) return;

                NavigableSet<Integer> prevIndices = indices.get(prevNumber);
                prevIndices.remove(index);
            }

            containers.put(index, number);

            if (!indices.containsKey(number)) {
                indices.put(number, new TreeSet<>());
            }

            indices.get(number).add(index);
        }

        public int find(int number) {
            if (!indices.containsKey(number) || indices.get(number).isEmpty()) {
                return -1;
            }

            return indices.get(number).first();
        }
    }
}
