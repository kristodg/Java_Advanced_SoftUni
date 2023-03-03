package MultiDimensionalArraysEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class rallyRacing_ExamProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String carNumber = scanner.nextLine();

        String[][] trace = new String[n][n];

        fillMatrix(trace, scanner);

        int currentRow = 0;
        int currentCol = 0;

        List<Integer> tunnelsCoordinates = new ArrayList<>();
        findTunnels(trace, tunnelsCoordinates);
        int km = 0;
        int countTunnels = 0;
        String direction = scanner.nextLine();
        while (direction.equals("End")){
            switch (direction){
                case "left":
                    currentCol--;
                    break;
                case"right":
                    currentCol++;
                    break;
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
            }

            String movedPlace = trace[currentRow][currentRow];

            if (".".equals(movedPlace)) {
                km = 10;
            } else if ("F".equals(movedPlace)) {
                System.out.printf("Racing car %s finished the stage!%n", carNumber);
                km += 20;
                break;
            } else if (movedPlace.equals("T")) {
                countTunnels++;
                if (countTunnels == 1){
                    currentRow = tunnelsCoordinates.get(2);
                    currentCol = tunnelsCoordinates.get(3);
                    km += 30;
                    trace[tunnelsCoordinates.get(0)][tunnelsCoordinates.get(1)] = ".";
                    trace[tunnelsCoordinates.get(2)][tunnelsCoordinates.get(3)] = ".";
                }
            }

            direction = scanner.nextLine();
        }

        if (direction.equals("End")){
            System.out.printf("Racing car %s DNF.", carNumber);
            System.out.printf("Racing car %s DNF.", carNumber);
        }

        System.out.printf("Distance covered %d km.", km);

        trace[currentRow][currentCol] = "C";

        printMatrix(trace);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }

            System.out.println();
        }
    }

    private static void findTunnels(String[][] trace, List<Integer> tunnelCoordinates ){
        for (int row = 0; row < trace.length; row++) {
            for (int col = 0; col < trace.length; col++) {
                String currentElement = trace[row][col];
                if (trace[row][col].equals("T")){
                    tunnelCoordinates.add(row);
                    tunnelCoordinates.add(col);

                }
            }
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner){
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}
