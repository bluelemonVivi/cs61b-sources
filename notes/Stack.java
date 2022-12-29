public class Stack {
    Node head;
    int size;
    private class Node<Item> {
        Node<Item> next;
        Item element;
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    public Stack() {
        this.head = new Node<>();
        size = 1;
    }

    void push(Object x) {
        Node tmpNode = new Node();
        tmpNode.element = x;
        tmpNode.next = head.next;
        head.next = tmpNode;
        size += 1;
    }

    public Object pop() {
        Node firstNode = null;
        if (isEmpty()) {
            return null;
        } else {
            firstNode = head.next;
            head.next = firstNode.next;
            size -= 1;
            return firstNode.element;
        }
    }

    public Object top() {
        if (!isEmpty()) {
            return head.next.element;
        } else {
            return null;
        }
    }
}
