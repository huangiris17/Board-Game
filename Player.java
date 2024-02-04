public class Player {
    private String name;
    private char color;
    private int score;
    private int winCount;

    public Player(String name, char color) {
        this.name = name;
        this.score = 0;
        this.color = color;
        this.winCount = 0;
    }

    public int getScore() {
        return this.score;
    }

    public char getColor() {
        return this.color;
    }

    public int getWinCount() {
        return this.winCount;
    }

    public String getName() {
        return this.name;
    }
}

// +Player(int name)
// + getScore(): return int
// + getWin(): return int
