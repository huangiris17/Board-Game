public class Board {
    private int row;
    private int col;
    private int occupied;
    private Disk[][] board;

    public Board(int row, int col) {
        this.row = row;
        this.col = col;
        this.board = new Disk[row][col];
        this.occupied = row * col;
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

    public char get(int row, int col) {
        return this.board[row][col].getColor();
    }

    public void showBoard() {
        System.out.println("Current board Status:");
        for (Disk[] row : this.board) {
            for (Disk d : row) {
                System.out.print(d);
            }
            System.out.println();
        }
    }

    public int canDrop(int c) {
        if (c >= 0 && c < this.col) {
            for (int i = this.row - 1; i >= 0; i--) {
                if (board[i][c].getColor() == '0')
                    return i;
            }
        }
        return -1;
    }

    public void setBoard(int row, int col, Disk disk) {
        board[row][col] = disk;
        this.occupied--;
    }

    public boolean fullboard() {
        return this.occupied == 0;
    }
}

// Board(int row, int col)
// + getRow(): return int
// + getCol(): return int
// - showBoard()
