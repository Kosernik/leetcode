package ExploreCards.HashTable;

import java.util.ArrayList;

public class MyHashMap {
    private final int MODULO = 8192;
    private final ArrayList<int[]>[] table;
    /** Initialize your data structure here. */
    public MyHashMap() {
        table = new ArrayList[MODULO];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = getHashCode(key);
        if (table[hash] == null) {
            table[hash] = new ArrayList<>();
        }
        for (int[] entry : table[hash]) {
            if (entry[0] == key) {
                entry[1] = value;
                return;
            }
        }
        int[] newEntry = {key, value};
        table[hash].add(newEntry);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = getHashCode(key);
        ArrayList<int[]> listOfKeys = table[hash];
        if (listOfKeys != null) {
            for (int[] entry : listOfKeys) {
                if (entry[0] == key) return entry[1];
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = getHashCode(key);
        ArrayList<int[]> listOfKeys = table[hash];
        if (listOfKeys != null) {
            boolean foundKey = false;
            int index = -1;
            for (int idx = 0; idx < listOfKeys.size(); idx++) {
                if (listOfKeys.get(idx)[0] == key) {
                    foundKey = true;
                    index = idx;
                    break;
                }
            }
            if (foundKey) {
                listOfKeys.remove(index);
            }
        }
    }

    private int getHashCode(int number) {
        return number%MODULO;
    }
}
