public class Main {

    public static void main(String[] args) {

        int a[][] = {{0, 0, 0, 0, 0, 2, 0, 0, 0},
                {0, 5, 0, 3, 8, 0, 0, 0, 0},
                {0, 1, 9, 0, 0, 0, 0, 5, 0},
                {0, 0, 4, 0, 0, 0, 1, 6, 0},
                {2, 0, 0, 0, 4, 0, 0, 0, 8},
                {0, 7, 5, 0, 0, 0, 3, 0, 0},
                {0, 4, 0, 0, 0, 0, 5, 7, 0},
                {0, 0, 0, 0, 1, 6, 0, 4, 0},
                {0, 0, 0, 2, 0, 0, 0, 0, 0}};
        Board board = new Board(a);
//        board.setElement(1, 0, 3);
//        board.setElement(4, 0, 1);
//        board.setElement(7, 0, 7);
//        board.setElement(3, 1, 4);
//        board.setElement(5, 1, 2);
//        board.setElement(2, 2, 1);
//        board.setElement(3, 2, 9);
//        board.setElement(4, 2, 3);
//        board.setElement(5, 2, 7);
//        board.setElement(6, 2, 6);
//        board.setElement(0, 3, 8);
//        board.setElement(1, 3, 9);
//        board.setElement(7, 3, 6);
//        board.setElement(8, 3, 7);
        Game game = new Game(board);
//        board.print();
        boolean returnVal = game.solveSudoku(board);
        if (returnVal) {
//            System.out.println("Solved");
        } else {
//            System.out.println("Not solved");
        }
        board.print();

    }
}
