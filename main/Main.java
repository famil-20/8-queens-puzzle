import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int size;
        String fileName;
        String in;
        String[] splitted;
        Scanner scanner = new Scanner(System.in);
        in = scanner.nextLine();
        splitted = in.split(" ");
        size = Integer.parseInt(splitted[0]);
        fileName = splitted[1];
        scanner.close();
        Queen[] queens = new Queen[size];
        Board x = new Board(size);
        for (int i = 0; i < queens.length; i++) {
            queens[i] = new Queen("Queen", x, i, 0);
        }
        Solver a = new Solver(queens, queens.length, fileName);
        a.solve();
    }
}
