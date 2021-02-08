package MonthlyChallenges.February21;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private boolean hasNext;
    private Integer peekElement;

    /**
     * LeetCode # 284.
     * An iterator class that supports operations: next(), hasNext() and peek().
     * @param iterator - java iterator.
     */
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        if (iterator == null) {
            hasNext = false;
            peekElement = null;
        } else {
            this.iterator = iterator;
            peekElement = iterator.next();
            hasNext = true;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return peekElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer next = peekElement;
        if (this.iterator.hasNext()) {
            peekElement = this.iterator.next();
        } else {
            this.hasNext = false;
        }

        return next;
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }
}
