package deque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class ArrayDeque<T> implements Deque<T>{
    @SuppressWarnings("unchecked")
    private T[] items = (T[]) new Object[8];
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    public ArrayDeque(T item) {
        items[3] = item;
        size = 1;
        nextFirst = 2;
        nextLast = 4;
    }
    @Override
    public void addFirst(T item) {
        items[nextFirst] = item;
        size += 1;
        nextFirst -= 1;
        if (nextFirst == -1) {
            resize(size*2);
        }
    }
    @Override
    public void addLast(T item) {
        items[nextLast] = item;
        size += 1;
        nextLast += 1;
        if (nextLast == items.length) {
            resize(size*2);
        }
    }
    @Override
    public T removeFirst() {
        if (isEmpty()) {return null;}
        T first = items[nextFirst+1];
        items[nextFirst+1] = null;
        size -= 1;
        nextFirst += 1;
        shrinkSize();
        return first;
    }
    @Override
    public T removeLast() {
        if (isEmpty()) {return null;}
        T last = items[nextLast-1];
        items[nextLast-1] = null;
        size -= 1;
        nextLast -= 1;
        shrinkSize();
        return last;
    }
    @Override
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        int itemIndex = nextFirst + 1 + index;
        return items[itemIndex];
    }
    @Override
    public void printDeque() {

    }
    public int size() {
        return size;
    }

    private void shrinkSize() {
        if (isEmpty()) {
            resize(8);
        } else if (items.length > size && size > 8) {
            resize(size*2);
        }
    }
    // resize at the moment the array is full
    private void resize(int n) {
        T[] newItems = (T[]) new Object[n];
        int firstPos = Math.abs(n-size)/2;
        for (int i = 0; i < size; i++) {
            newItems[firstPos+i] = items[nextFirst+1+i];
        }
        items = newItems;
        nextFirst = firstPos - 1;
        nextLast = firstPos + size;
    }
    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (! (o instanceof ArrayDeque)) {
            return false;
        }
        ArrayDeque<T> ad = (ArrayDeque<T>) o;
        if (ad.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (ad.get(i) != get(i)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int index;

        ArrayDequeIterator() {
            index = 0;
        }
        public boolean hasNext() {
            return index < size;
        }
        public T next() {
            T item = get(index);
            index++;
            return item;
        }
    }
}
