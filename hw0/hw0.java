public class DrawTriangle{
    public static void main(String[] args){
        int col = 0;
        int row = 0;
        int size = 5;

        while (row <= size){
            row = row + 1;
            col = 0;
            while (col < row){
                col = col + 1;
                System.out.print('*');

            }
            System.out.println();

        }
    }
}