package MonthlyChallenges.Year23.January;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    //  Key -> number of uses
    private final Map<Integer, Integer> counts = new HashMap<>();

    //  Key -> value
    private final Map<Integer, Integer> values = new HashMap<>();

    private final int CAPACITY;
    private int minCount = -1;

    //  number of uses -> List of keys
    private final Map<Integer, LinkedHashSet<Integer>> lists = new HashMap<>();

    /**
     * LeetCode #460. LFU Cache.
     *
     * @param capacity - the maximum capacity of the cache
     */
    public LFUCache(int capacity) {
        this.CAPACITY = capacity;
        lists.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!values.containsKey(key)) return -1;

        int curCount = counts.get(key);
        counts.put(key, curCount + 1);
        lists.get(curCount).remove(key);

        if (curCount == minCount && lists.get(curCount).size() == 0) minCount++;

        if (!lists.containsKey(curCount + 1)) lists.put(curCount + 1, new LinkedHashSet<>());

        lists.get(curCount + 1).add(key);

        return values.get(key);
    }

    public void put(int key, int value) {
        if (CAPACITY <= 0) return;

        if (values.containsKey(key)) {
            values.put(key, value);
            get(key);
            return;
        }

        if (values.size() >= CAPACITY) {
            int lruElement = lists.get(minCount).iterator().next();
            lists.get(minCount).remove(lruElement);
            values.remove(lruElement);
        }

        values.put(key, value);
        counts.put(key, 1);
        minCount = 1;

        lists.get(1).add(key);
    }
}
