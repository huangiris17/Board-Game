import java.util.*;

public class Game {
    private Board board;
    private Player p1;
    private Player p2;
    private List<Player> playerLst;
    private boolean isEnd;
    private final int row = 6;
    private final int col = 7;

    public Game(String name1, String name2) {
        this.p1 = new Player(name1, 'R');
        this.p2 = new Player(name2, 'Y');
        this.playerLst = new ArrayList<>(Arrays.asList(p1, p2));
        this.isEnd = false;
    }

    private void newGame() {
        this.board = new Board(this.row, this.col);
    }

    public void gameStart() {
        newGame();
        Scanner in = new Scanner(System.in);
        while (!isEnd) {
            for (Player p : playerLst) {
                if (this.board.fullboard()) {
                    System.out.println("🛑 Battle to a draw. Game restart 🛑");
                    newGame();
                }
                while (true) {
                    System.out.println(
                            "=====================================================================================");
                    showStatus();
                    System.out.println(p.getName() + "'s turn. Select a column or press R to restart: ");
                    String res = in.next();
                    if (res.equals("R")) {
                        System.out.println("\n🟠 Game restarts!\n");
                        newGame();
                    } else {
                        int col = Integer.valueOf(res);
                        if (dropDisk(p, col)) {
                            System.out.println("\n✅ Successfully dropped at: " + col + " ✅\n");
                            break;
                        } else {
                            System.out.println("\n🛑 Column not available 🛑\n");
                        }
                    }
                }
                if (checkWin(p)) {
                    System.out.println("⭐️ " + p.getName() + " get 1 score!");
                    p.addScore();
                    if (checkScore(p)) {
                        isEnd = true;
                        System.out.println("🔥 " + p.getName() + " win!");
                        break;
                    }
                    newGame();
                }
            }
        }
        in.close();
    }

    private void showStatus() {
        System.out.println(
                p1.getName() + "'s score: " + p1.getScore() + ", " + p2.getName() + "'s score: " + p2.getScore());
        this.board.showBoard();
    }

    private boolean dropDisk(Player player, int col) {
        Disk curdisk = new Disk(player.getColor());
        int res = board.canDrop(col - 1);
        if (res != -1) {
            board.setBoard(res, col - 1, curdisk);
            return true;
        }
        return false;
    }

    private boolean checkScore(Player p) {
        return p.getScore() >= 2;
    }

    private boolean checkWin(Player player) {
        return checkRow(player) || checkCol(player);
    }

    // private boolean checkDiag(Player player) {

    // }

    private boolean checkRow(Player player) {
        char color = player.getColor();
        for (int i = 0; i < row; i++) {
            int c = 0;
            while (c < col) {
                if (this.board.get(i, c) == color) {
                    int count = 0;
                    while (c < col && this.board.get(i, c) == color) {
                        count++;
                        c++;
                    }
                    if (count >= 4)
                        return true;
                } else
                    c++;
            }
        }
        return false;
    }

    private boolean checkCol(Player player) {
        char color = player.getColor();
        for (int i = 0; i < col; i++) {
            int r = 0;
            while (r < row) {
                if (this.board.get(r, i) == color) {
                    int count = 0;
                    while (r < row && this.board.get(r, i) == color) {
                        count++;
                        r++;
                    }
                    if (count >= 4)
                        return true;
                } else
                    r++;
            }
        }
        return false;
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