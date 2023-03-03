package JavaAdvancedExam.FirstProblem;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ApocalypsePreparation {

        private static final int PATCH_VALUE = 30;
        private static final int BANDAGE_VALUE = 40;
        private static final int MEDKIT_VALUE = 100;


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String[] infoTiles = scanner.nextLine().split(" ");
            ArrayDeque<Integer> textiles = new ArrayDeque<>(); //опашка за текстилите

            for (String liquid : infoTiles) {
                textiles.offer(Integer.parseInt(liquid));
            }
            String[] medicamentsInfo = scanner.nextLine().split(" ");
            ArrayDeque<Integer> medicaments = new ArrayDeque<>(); //стек за едикаментите

            for (String ingredient : medicamentsInfo) {
                medicaments.push(Integer.parseInt(ingredient));
            }

            int patchCount = 0, bandageCount = 0, medkitCount = 0;
            while (!textiles.isEmpty() && !medicaments.isEmpty()) {
                Integer textile = textiles.poll();
                Integer medicament = medicaments.pop();
                int possibleItem = textile + medicament;

                if (possibleItem == PATCH_VALUE) {
                    patchCount++;
                } else if (possibleItem == BANDAGE_VALUE) {
                    bandageCount++;
                } else if (possibleItem == MEDKIT_VALUE) {
                    medkitCount++;
                } else if (possibleItem > MEDKIT_VALUE) {
                    medkitCount++;
                    int remainder = possibleItem - MEDKIT_VALUE;
                    medicaments.push(medicaments.pop() + remainder);
                } else {
                    medicaments.push(medicament + 10);
                }
            }
            if (textiles.isEmpty() && medicaments.isEmpty()){
                System.out.println("Textiles and medicaments are both empty.");
            } else if (textiles.isEmpty()) {
                System.out.println("Textiles are empty.");
            } else if (medicaments.isEmpty()) {
                System.out.println("Medicaments are empty.");
            }

            HashMap<String, Integer> map = new HashMap<>();
            map.put("Patch", patchCount);
            map.put("Bandage", bandageCount);
            map.put("MedKit", medkitCount);
            map.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue()
                            .reversed()
                            .thenComparing(Map.Entry.comparingByKey()))
                    .forEach(entry -> {
                        if (entry.getValue() != 0){
                            System.out.println(entry.getKey() + " - " + entry.getValue());
                        }
                    });

            if(!textiles.isEmpty()){
                System.out.print("Textiles left: ");
                while(!textiles.isEmpty()){
                    if (textiles.size() > 1){
                        System.out.print(textiles.poll() + ", ");
                    } else {
                        System.out.print(textiles.poll());
                    }

                }
            }

            if(!medicaments.isEmpty()){
                System.out.print("Medicaments left: ");
                while(!medicaments.isEmpty()){
                    if (medicaments.size() > 1){
                        System.out.print(medicaments.pop() + ", ");
                    } else {
                        System.out.print(medicaments.pop());
                    }
                }
            }
        }
    }