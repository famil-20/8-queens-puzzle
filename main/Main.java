import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int size;
        Scanner scanner = new Scanner(System.in);
        System.out.println("~~~~~~~~~Queen problem~~~~~~~~~");
        System.out.print("\n\n");
        System.out.print("Enter the size of the Board: ");
        size = scanner.nextInt();
        scanner.close();
        System.out.print("\n\n");
        System.out.println("Processing...");

        Queen[] queens = new Queen[size];
        Board x = new Board(size);
        for (int i = 0; i < queens.length; i++) {
            queens[i] = new Queen("Queen", x, i, 0);
        }
        Solver a = new Solver(queens, queens.length);
        a.solve();
    }
}