package JavaAdvancedExam.SecondProblem;

import java.util.Scanner;

public class BlindMan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        char[][] playground = new char[rows][cols];
        int playerRow = 0, playerCol = 0;
        int opponentsTouched = 0;
        int movesMade = 0;
        int opponentsCount = 3;

        for (int i = 0; i < rows; i++) {
            String row = scanner.nextLine();
            String[] cells = row.split(" ");
            for (int j = 0; j < cols; j++) {
                playground[i][j] = cells[j].charAt(0);
                if (playground[i][j] == 'B') {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }
        while (true) {
            String direction = scanner.nextLine();
            if (direction.equals("Finish")) {
                break;
            }

            int newRow = playerRow, newCol = playerCol;
            switch (direction) {
                case "up":
                    newRow--;
                    break;
                case "down":
                    newRow++;
                    break;
                case "left":
                    newCol--;
                    break;
                case "right":
                    newCol++;
                    break;
                default:
                    continue;
            }

            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                continue;
            }

            char newPosition = playground[newRow][newCol];
            if (newPosition == 'O') {
                // obstacle, stay in place
                continue;
            } else if (newPosition == 'P') {
                // opponent, touch and update position
                opponentsTouched++;
                movesMade++;
                opponentsCount--;
                playground[playerRow][playerCol] = '-';
                playground[newRow][newCol] = 'B';
                playerRow = newRow;
                playerCol = newCol;
                if (opponentsCount == 0) {
                    break;
                }
            } else if (newPosition == '-') {
                movesMade++;
                playground[playerRow][playerCol] = '-';
                playground[newRow][newCol] = 'B';
                playerRow = newRow;
                playerCol = newCol;
            }
        }

        System.out.println("Game over!");
        System.out.print("Touched opponents: " + opponentsTouched + " ");
        System.out.println("Moves made: " + movesMade);
    }
}

