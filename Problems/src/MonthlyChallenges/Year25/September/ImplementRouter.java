package MonthlyChallenges.Year25.September;

import java.util.*;

public class ImplementRouter {

    /**
     * LeetCode №3508. Implement Router.
     */
    class Router {
        private final Deque<int[]> packets; // Oldest entries at the end

        private final int memoryLimit;

        private final Map<Integer, List<Integer>> countsForDestinations;

        private final int[] empty = new int[]{};

        public Router(int memoryLimit) {
            this.memoryLimit = memoryLimit;
            this.packets = new ArrayDeque<>(memoryLimit);

            countsForDestinations = new HashMap<>();
        }

        public boolean addPacket(int source, int destination, int timestamp) {
            for (int[] packet : packets) {
                if (packet[2] < timestamp) break;
                if (packet[0] == source && packet[1] == destination) return false;
            }

            int[] packet = new int[]{source, destination, timestamp};
            if (packets.size() == memoryLimit) {
                forwardPacket();
            }
            packets.addFirst(packet);

            if (!countsForDestinations.containsKey(destination)) {
                countsForDestinations.put(destination, new ArrayList<>());
            }

            countsForDestinations.get(destination).add(timestamp);

            return true;
        }

        public int[] forwardPacket() {
            if (packets.isEmpty()) {
                return empty;
            }

            int[] forwarded = packets.removeLast();

            List<Integer> times = countsForDestinations.get(forwarded[1]);
            times.remove(0);
            if (times.isEmpty()) {
                countsForDestinations.remove(forwarded[1]);
            }

            return forwarded;
        }

        public int getCount(int destination, int startTime, int endTime) {
            List<Integer> times = countsForDestinations.getOrDefault(destination, new ArrayList<>());

            if (times.isEmpty()) return 0;

            int startIdx = binarySearchLeft(startTime, times);
            int endIdx = binarySearchRight(endTime, times);

            return endIdx - startIdx + 1;
        }

        private int binarySearchLeft(int time, List<Integer> times) {
            int left = 0, right = times.size(), middle;

            while (left < right) {
                middle = left + (right - left) / 2;

                if (times.get(middle) < time) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }

            return left;
        }

        private int binarySearchRight(int time, List<Integer> times) {
            int left = 0, right = times.size(), middle;

            while (left < right) {
                middle = left + (right - left) / 2;

                if (times.get(middle) > time) {
                    right = middle;
                } else {
                    left = middle + 1;
                }
            }

            return right - 1;
        }
    }
}
