import java.util.ArrayList;

/**
 * Created by bhavinchauhan on 1/13/16.
 */
public class Game {
    Board board;
    Game(Board board) {
       this.board = board;
    }

    boolean isSodukoSolved(Board board) {
        int rowSum = 0, colSum = 0, boxSum = 0;
        for (int i = 0; i < 9; i++) {
            rowSum = 0;
            colSum = 0;
            boxSum = 0;
            for (int j = 0; j < 9; j++) {
                if (i % 3 == 0 && j % 3 == 0) {
                    boxSum += board.getElement(i, j) + board.getElement(i + 1, j)
                            + board.getElement(i + 2, j) + board.getElement(i, j + 1)
                            + board.getElement(i, j + 2) + board.getElement(i + 1, j + 1)
                            + board.getElement(i + 1, j + 2) + board.getElement(i + 2, j + 1 )
                            + board.getElement(i + 2, j + 2);
                    if (boxSum != 36) {
                        return false;
                    }
                }
                if (board.getElement(i, j) == 0) {
                    return false;
                }
                rowSum += board.getElement(i, j);
                colSum += board.getElement(j, i);
            }
            if (rowSum != 36 || colSum != 36) {
                return false;
            }
        }
        return true;
    }

    boolean findUnAssignedCells(Board board, IntWrap row, IntWrap col) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
               if(board.getElement(i, j) == 0) {
                   row.setA(i);
                   col.setA(j);
                   return true;
               }
            }
        }
//        System.out.println("No unassigned cell");
        return false;
    }

    boolean isSafePos(int row, int col, int k) {
        for (int i = 0; i < 9; i++) {
            if (board.getElement(i, col) == k) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board.getElement(row, i) == k) {
                return false;
            }
        }
        int boxStartRow = row - row % 3;
        int boxStartCol = col - col % 3;
        for (int i = 0; i <  3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getElement(i + boxStartRow, j + boxStartCol) == k) {
                    return false;
                }
            }
        }
        return true;
    }

    public  void solveSudoku(ArrayList<ArrayList<Character>> arr) {
        int[][] a = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr.get(i).get(j) != '.') {
                    a[i][j] = Character.getNumericValue(arr.get(i).get(j));
                } else {
                    a[i][j] = 0;
                }
            }
        }
        Board board = new Board(a);
        solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr.get(i).set(j, Character.forDigit(board.getElement(i, j), 36));
            }
        }
        return;
    }

    boolean solveSudoku(Board board) {
//        System.out.println("\n");
        IntWrap row = new IntWrap(0), col = new IntWrap(0);
        if (!findUnAssignedCells(board, row, col)) {
//            System.out.println("No unassigned cell found!! Game Over!");
            return true;
        }
        for (int k = 1; k <= 9; k++) {
            if (isSafePos(row.a, col.a, k)) {
                board.setElement(row.a, col.a, k);
                if (solveSudoku(board)) {
                    return true;
                }
                board.setElement(row.a, col.a, 0);
            } else {
//                System.out.println("Not safe position for Cell:" +  "," + col + "k value" + k);
            }
        }
        return false;
    }
}
