public class MaxInt {
    public static int max(int[] m) {
        int max = 0;
        int i = 0;
        while (i < m.length) {
            if (max <= m[i]) {
                max = m[i];
            }
            i += 1;
        }
        System.out.println(max);
        return max;
    }
    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        max(numbers);
    }
}
