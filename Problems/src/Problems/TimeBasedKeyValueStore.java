package Problems;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {

    /**
     * LeetCode #981. Time Based Key-Value Store.
     */
    class TimeMap {
        //  key -> map(timestamp -> value)
        private final Map<String, NavigableMap<Integer, String>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) {
                map.put(key, new TreeMap<>());
            }
            NavigableMap<Integer, String> timeline = map.get(key);
            timeline.put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) return "";

            NavigableMap<Integer, String> timeline = map.get(key);
            Map.Entry<Integer, String> result = timeline.floorEntry(timestamp);
            return result == null ? "" : result.getValue();
        }
    }
}
