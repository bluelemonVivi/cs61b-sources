public class MaxInt2 {
    public static int forMax(int[] m) {
        int max = 0;
        for (int i = 0; i < m.length; i += 1){
            if (max <= m[i]) {max = m[i];}
        }
        System.out.println(max);
        return max;
    }
    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        forMax(numbers);
    }
}
