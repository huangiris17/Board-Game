import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Connect4! Please follow the insturctions.");

        System.out.print("- Player1 Name: ");
        String name1 = in.next();

        System.out.print("- Player2 Name: ");
        String name2 = in.next();

        System.out.println("Welcome to the game " + name1 + ", " + name2 + "!");
        System.out.println();

        Game curGame = new Game(name1, name2);
        curGame.gameStart();
        in.close();
    }
}