package week6.discussion;

import week4.discussion.IntList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Katsura on 2017/3/2.
 */
public class KthIntList implements Iterator<Integer> {

    public int k;
    private IntList curList;
    private boolean hasNext;

    public KthIntList(IntList I, int k) {
        this.k = k;
        this.curList = I;
        this.hasNext = true;
    }

    @Override
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override
    public Integer next() {
        if (curList == null) {
            throw new NoSuchElementException();
        }
        Integer toReturn = curList.head;
        for (int i = 0; i < k && curList != null; i++) {
            curList = curList.tail;
        }
        hasNext = (curList != null);
        return toReturn;
    }

}
