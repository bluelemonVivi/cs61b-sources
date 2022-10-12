package randomizedtest;

public class testThreeAddThreeMove {

    public static void main(String[] args) {
        AListNoResizing<Integer> testList1 = new AListNoResizing<>();
        BuggyAList<Integer> testList2 = new BuggyAList<>();
        boolean check = true;
        for (int i = 4; i <= 6; i++) {
            testList1.addLast(i);
            testList2.addLast(i);
        }
        for (int i = 0; i < 3; i++) {
            int result1 = testList1.removeLast();
            int result2 = testList2.removeLast();
            if (result1 != result2) {check = false;}
        }
        if (check) {System.out.println("Equal");}
        else {System.out.println("Not equal");}
    }
}
