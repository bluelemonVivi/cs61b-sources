public class fib {
    public static int fib1(int n){
        if (n == 0 || n == 1){
            return n;
        }
        else{
            return fib1(n-1) + fib1(n-2);
        }
    }
    public static int fib2(int n, int k, int f0, int f1){
        if (n == k){
            return f0;
        }
        else {
            return fib2(n, k+1, f1, f0+f1);
        }
    }
    public static void main(String[] args){
        System.out.println(fib1(5));
        System.out.println(fib2(5,0,0,1));
    }
}
