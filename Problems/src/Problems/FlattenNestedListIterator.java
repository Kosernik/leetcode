package Problems;

import java.util.*;

public class FlattenNestedListIterator {

    /**
     * LeetCode #341. Flatten Nested List Iterator.
     */
    public class NestedIterator implements Iterator<Integer> {
        private final List<Integer> flatList = new ArrayList<>();
        private int idx = 0;

        public NestedIterator(List<NestedInteger> nestedList) {
            setFlatList(nestedList);
        }

        @Override
        public Integer next() {
            return flatList.get(idx++);
        }

        @Override
        public boolean hasNext() {
            return idx < flatList.size();
        }

        private void setFlatList(List<NestedInteger> nestedList) {
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger()) {
                    this.flatList.add(ni.getInteger());
                } else {
                    List<NestedInteger> curList = ni.getList();
                    setFlatList(curList);
                }
            }
        }
    }

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
