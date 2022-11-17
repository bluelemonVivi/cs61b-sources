package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T> {
    private final Node<T> head = new Node<>(null, null, null);
    private int size;
    public LinkedListDeque() {
        head.prev = head;
        head.next = head;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        head.next = new Node<>(item, head, head.next);
        head.next.next.prev = head.next;
        size += 1;
    }
    @Override
    public void addLast(T item) {
        head.prev = new Node<>(item, head.prev, head);
        head.prev.prev.next = head.prev;
        size += 1;
    }
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T first = head.next.item;
        head.next.next.prev = head;
        head.next = head.next.next;
        size -= 1;
        return first;
    }
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T last = head.prev.item;
        head.prev.prev.next = head;
        head.prev = head.prev.prev;
        size -= 1;
        return last;
    }
    @Override
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        Node<T> pointer = head.next;
        for (int i = 0; i < index; i++) {
            pointer = pointer.next;
        }
        return pointer.item;
    }

    public T getRecursive(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        return recursiveHelper(index, head.next);
    }
    private T recursiveHelper(int index, Node<T> pointer) {
        if (index == 0) {
            return pointer.item;
        }
        return recursiveHelper(index - 1, pointer.next);
    }
    @Override
    public void printDeque() {
        String[] items = new String[size];
        Node<T> pointer = head.next;
        if (pointer == head) {
            return;
        }
        for (int i = 0; i < size; i++) {
            items[i] = pointer.toString();
            pointer = pointer.next;
        }
        System.out.println(String.join(" ", items));
    }

    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }
    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof LinkedListDeque)) {
            return false;
        }
        LinkedListDeque<?> lld = (LinkedListDeque<?>) o;
        if (lld.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (lld.get(i) != get(i)) {
                return false;
            }
        }
        return true;
    }
    private static class Node<T> {
        private final T item;
        private Node<T> prev;
        private Node<T> next;

        Node(T x, Node<T> p, Node<T> n) {
            item = x;
            prev = p;
            next = n;
        }

        @Override
        public String toString() {
            if (item == null) {
                return "null";
            }
            return item.toString();
        }
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        private Node<T> p;

        LinkedListDequeIterator() {
            p = head.next;
        }

        public boolean hasNext() {
            return p == head;
        }

        public T next() {
            T item = p.item;
            p = p.next;
            return item;
        }
    }
}
