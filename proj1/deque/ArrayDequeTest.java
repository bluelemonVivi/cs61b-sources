package deque;

public class ArrayDequeTest {
    public void test() {
        ArrayDeque<Integer> t = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            t.addLast(i);
        }
        for (int i : t) {
            System.out.println(i);
        }
    }
}
