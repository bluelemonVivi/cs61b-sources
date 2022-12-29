package disc4;

public class fillGrid {
    public static void fillGrid(int[] LL, int[] UR, int[][] S) {
        int N = S.length;
        int kL, kR;
        kL = kR = 0;

        for (int i = 0; i < N; i += 1) {
            System.arraycopy(LL,kL,S[i],0,i);
            System.arraycopy(UR,kR,S[i],i+1,N-i-1);
            kL += i;
            kR += N - i -1;
        }
    }
    public static void main(String[] args) {
        int[] LL =  {1,2,3,4,5,6,7,8,9,10,0,0};
        int[] UR = {11,12,13,14,15,16,17,18,19,20};
        int[][] S ={
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };
        fillGrid(LL,UR,S);
        System.out.println(java.util.Arrays.toString(S[0]));
        System.out.println(java.util.Arrays.toString(S[1]));
        System.out.println(java.util.Arrays.toString(S[2]));
        System.out.println(java.util.Arrays.toString(S[3]));
        System.out.println(java.util.Arrays.toString(S[4]));
    }
}
