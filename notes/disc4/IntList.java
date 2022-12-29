package disc4;

public class IntList {
    public int first;
    public IntList rest;
    public IntList (int f, IntList r) {
        this.first = f;
        this.rest = r;
    }

    public static void evenOdd(IntList lst) {
        if (lst == null || lst.rest == null) {
            return;
        }
        IntList sentinel = lst.rest;
        IntList odds = lst.rest;
        while (lst.rest != null && odds.rest != null) { /** Judge lst.rest first since lst always comes before odds */
            lst.rest = lst.rest.rest;
            odds.rest = odds.rest.rest;
            lst = lst.rest;
            odds = odds.rest;
        }
        lst.rest = sentinel;
    }

    /** Assume the method of "reverse" and ".length" is already known.*/
    public static IntList[] partition(IntList lst, int k) {
        IntList[] array = new IntList[k];
        int index = 0;
        IntList L = reverse(lst);
        while (L != null) {
            IntList temp = array[index];
            IntList next = L.rest;
            array[index] = L;
            array[index].rest = temp;
            L = next;
            index = (index + 1) % k;

        }
    }
}
