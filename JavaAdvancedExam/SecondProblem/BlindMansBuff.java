package JavaAdvancedExam.SecondProblem;

import java.util.Arrays;
import java.util.Scanner;

public class BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //You will be given N and M – integers, indicating the playground’s dimensions.
        // On the next N lines, you will receive the rows of the playground, with M columns.

        int[] dimensions =  Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        //, furniture or other obstacles will be marked with the letter 'O'
        //The other players (opponents) will be marked with the letter 'P'.
        //There will always be three other players participating in the game.
        //All of the empty positions will be marked with '-'.


        //The possible directions are "up", " down", "right", and "left".
        String command = scanner.nextLine();

        while(!command.equals("Finish")){
            scanner.nextLine();
            continue;
        }
    }
}
