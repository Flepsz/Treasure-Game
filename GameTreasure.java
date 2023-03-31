package c005;

import java.util.Random;
import java.util.Scanner;

public class GameTreasure {
    public static void main(String[] args) {
        int[][] matrix = new int [5][5];
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n==================== \33[7;33m FIND THE TREASURE \33[m =====================");
        System.out.println("You will have to match column and row to find the treasure");

        int treasureRow = random.nextInt(matrix.length);
        int treasureCol = random.nextInt(matrix[0].length);
        matrix[treasureRow][treasureCol] = 1;

        int attempts = 3;

        while (attempts > 0) {
            System.out.println("You Have \33[31m" + attempts + " attempts\33[m left.");

            int guessRow = -1;
            while (guessRow < 0 || guessRow > 4) {
                System.out.print("Enter a \33[35mROW\33[m number (0-4): ");
                guessRow = scanner.nextInt();
            }
            int guessCol = -1;
            while (guessCol < 0 || guessCol > 4) {
                System.out.print("Enter a \33[35mCOLUMN\33[m number (0-4): ");
                guessCol = scanner.nextInt();
                System.out.println();
            }
            System.out.println("                          \33[36m0 1 2 3 4\33[m");
            for (int i = 0; i < matrix.length; i++) {
                System.out.print("                       \33[36m" + i + "\33[m  ");
                for (int j = 0; j < matrix[i].length; j++) {
                    if (i == guessRow && j == guessCol) {
                        System.out.print(matrix[i][j] + " ");
                    } else if (matrix[i][j] == -1) {
                        System.out.print("X ");
                    } else {
                        System.out.print("* ");
                    }
                }
                System.out.println();
            }
            if (matrix[guessRow][guessCol] == 0) {
                matrix[guessRow][guessCol] = -1;
            }

            if (guessRow == treasureRow && guessCol == treasureCol) {
                System.out.println("\nCongratulations! You found the treasure!");
                break;
            } else {
                System.out.println("\nSorry, that was not the treasure.");
                attempts--;
            }
            if (attempts == 0) {
                System.out.println("YOU LOSE! The treasure was in the " + treasureRow + "º Row and " + treasureCol + "º Column");
            }
        }
    }
}
