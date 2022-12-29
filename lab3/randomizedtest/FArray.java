package randomizedtest;

import java.util.Scanner;

public class FArray {

    private long[] items;
    private int size;

    public FArray() {
        items = new long[100];
        size = 0;
    }

    private void resize(int capacity) {
        long[] a = new long[capacity];
        System.arraycopy(items,0,a,0,size);
        items = a;
    }

    public void rebuildADD(int capacity, int index) {
        long[] a = new long[capacity];
        System.arraycopy(items,0,a,0,index-1);
        System.arraycopy(items,index,a,index+1,size-index-1);
        items = a;
    }

    public void rebuildDELETE(int capacity, int index) {
        long[] a = new long[capacity];
        System.arraycopy(items,0,a,0,index-1);
        System.arraycopy(items,index+1,a,index,size-index-2);
        items = a;
    }

    public void addAt(int index,long add) {
        if (size == items.length) {
            rebuildADD(size*2,index);
        }

        items[index] = add;
        size += 1;
    }

    public void deleteAt(int index) {
        if (index > size) {
            System.exit(0);
        } else {
            rebuildDELETE(size-1,index);
        }
    }

    public long sum(int i, int f) {
        long result = 0;
        for (int n = i; n <= f; n++) {
            result = result + items[i];
        }
        return result;
    }

    public void addLast(long x) {
        if (size == items.length) {
            resize(size*2);
        }

        items[size] = x;
        size++;
    }

    public int size() {return size;}

    public static void main(String[] args) {
        FArray test = new FArray();
        Scanner input = new Scanner(System.in);
        input.nextInt();
        int numbers = input.nextInt();
        input.close();
        for (int i = 0; i < numbers; i++) {
            input.nextInt();
            int op = input.nextInt();
            int k = input.nextInt();
            long x = input.nextInt();
            input.close();
            if (op == 1) {
                test.addAt(k,x);
            } else if (op == 2) {
                test.deleteAt(k);
            } else if (op == 3) {
                long l = test.sum(0,k-1);
                long r = test.sum(k+1,test.size-1);
                System.out.print(l+r);
            }
        }
    }
}
