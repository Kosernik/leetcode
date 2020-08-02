package MonthlyChallenges.August;

import java.util.ArrayList;
import java.util.LinkedList;

public class DesignHashSet {
    class MyHashSet {
        private final int MODULO = 8192;
        private final LinkedList<Integer>[] buckets;

        /** Initialize your data structure here. */
        public MyHashSet() {
            this.buckets = new LinkedList[MODULO];
        }

        public void add(int key) {
            if (!contains(key)) {
                int curHash = getHashCode(key);
                if (buckets[curHash] == null) {
                    buckets[curHash] = new LinkedList<>();
                }
                buckets[curHash].add(key);
            }
        }

        public void remove(int key) {
            int curHash = getHashCode(key);
            if (buckets[curHash] == null) return;
            int count = 0;
            boolean found = false;
            for (Integer val : buckets[curHash]) {
                if (val == key) {
                    found = true;
                    break;
                }
                count++;
            }
            if (found) buckets[curHash].remove(count);
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int curHash = getHashCode(key);
            if (buckets[curHash] == null) return false;

            for (Integer val : buckets[curHash]) {
                if (val == key) return true;
            }

            return false;
        }

        private int getHashCode(int number) {
            return number%MODULO;
        }
    }
}
