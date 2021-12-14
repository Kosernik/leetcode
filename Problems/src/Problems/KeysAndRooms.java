package Problems;

import java.util.*;

public class KeysAndRooms {

    /**
     * LeetCode #841. Keys and Rooms.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param rooms - a list of rooms with the set of keys in each room.
     * @return - True - if it is possible to visit each room. False - otherwise.
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);

        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        while (!queue.isEmpty()) {
            int room = queue.poll();

            for (int key : rooms.get(room)) {
                if (visited.add(key)) {
                    queue.offer(key);
                }
            }
        }

        return visited.size() == rooms.size();
    }
}
