import java.util.Scanner;

public class Game {
    private Board board;
    private Player p1;
    private Player p2;
    private Player turn;
    private boolean isEnd;
    private final int row = 6;
    private final int col = 7;

    public Game(String name1, String name2) {
        this.p1 = new Player(name1, 'R');
        this.p2 = new Player(name2, 'Y');
        this.board = new Board(this.row, this.col);
        this.turn = p1;
        this.isEnd = false;
    }

    public void gameStart() {
        Scanner in = new Scanner(System.in);
        while (!isEnd) {
            int col = in.nextInt();
            while (dropDisk(this.turn, col)) {
            }
        }
        in.close();
    }

    public void showStatus() {

    }

    public boolean dropDisk(Player player, int col) {
        Disk curdisk = new Disk(player.getColor());
        int res = board.canDrop(col);
        if (res > -1) {
            board.setBoard(res, col, curdisk);
            return true;
        }
        return false;
    }

    public boolean checkWin(Player player) {
        return player.getScore() == 3;
    }
}

// +board:Board
// +player1:Player
// +player2:Player
// + Game()
// + gameStart()
// + showStatus()
// + dropDisk()
// + checkWin()