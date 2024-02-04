public class Board {
    private int row;
    private int col;

    private Disk[][] board;

    public Board(int row, int col) {
        this.row = row;
        this.col = col;
        this.board = new Disk[row][col];
        startBoard();
    }

    private void startBoard() {
        for (Disk[] row : board) {
            for (int i = 0; i < row.length; i++) {
                row[i] = new Disk('0');
            }
        }
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public void showBoard() {
        System.out.println("Current board Status:");
        for (Disk[] row : this.board) {
            System.out.println(row);
        }
    }

    public int canDrop(int col) {
        for (int i = this.row - 1; i >= 0; i--) {
            if (board[i][col].getColor() == '0')
                return i;
        }
        return -1;
    }

    public void setBoard(int row, int col, Disk disk) {
        board[row][col] = disk;
    }
}

// Board(int row, int col)
// + getRow(): return int
// + getCol(): return int
// - showBoard()
