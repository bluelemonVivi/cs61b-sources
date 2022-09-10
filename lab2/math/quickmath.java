package math;

public class quickmath{
    int weight;
    int height;
    public quickmath(int a, int b){
        weight = a;
        height = b;
    }
    public static void main(String[] args){
        quickmath target = new quickmath(2,3);
        quickmath x = target;
        quickmath y = target;
        if (x.equals(y)) {
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }
    }
}
