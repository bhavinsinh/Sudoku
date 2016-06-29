/**
 * Created by bhavinchauhan on 1/13/16.
 */
public class Board {
    private int [][] a;
    Board() {
        a = new int [9][9];
    }

    Board(int [][] a) {
        this.a = a;
    }

    void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(this.getElement(i, j) + "\t");
            }
            System.out.println(" ");
        }

    }

    public int getElement(int row, int col) {
        return a[row][col];
    }

    public void setElement(int row, int col, int k) {
         a[row][col] = k;
    }
}
