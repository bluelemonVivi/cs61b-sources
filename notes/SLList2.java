public class SLList2 {
    Node sentinel;

    public SLList2() {
        this.sentinel = new Node();
    }

    private static class Node {
        int item = 3;
        Node next;
    }

    public int findFirst(int n) {
        return findFirstHelper(n, 0, sentinel.next);
    }

    private int findFirstHelper(int n, int index, Node curr) {
        if (curr == null) {
            return -1;
        }
        if (curr.item == n) {
            return index;
        } else {
            return findFirstHelper(n, index+1, curr.next);
        }
    }

    public static void main(String[] args) {
        SLList2 lst = new SLList2();
        System.out.println(lst.findFirst(3));
    }
}
