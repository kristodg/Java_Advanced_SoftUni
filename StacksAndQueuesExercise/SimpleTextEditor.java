package StacksAndQueuesExercise;

import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder currentText = new StringBuilder();

        for (int commandNumber = 1; commandNumber <= n ; commandNumber++) {
            String command = scanner.nextLine();

            if (command.startsWith("1")){
                String textToAppend = command.split("\\s+")[1];
                currentText.append(textToAppend);


            } else if (command.startsWith("2")) {
                int count = Integer.parseInt(command.split(" ")[1]);
                int startIndexForDelete = currentText.length() - count;
                currentText.delete(startIndexForDelete, currentText.length());
                
            } else if (command.startsWith("3")) {
                
            } else if (command.startsWith("4")) {
                
            }

        }
    }
}
