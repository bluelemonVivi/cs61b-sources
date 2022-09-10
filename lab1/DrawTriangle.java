public class DrawTriangle {
    public static void drawTriangle(int n)

    {
        int col = 0;
        int row = 0;
        int size = n;
        while (col < size) {
            col += 1;
            row = 0;
            while (row < col) {
                row += 1;
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        drawTriangle(10);
    }
}
