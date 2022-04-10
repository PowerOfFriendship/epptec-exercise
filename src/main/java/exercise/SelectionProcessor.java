package exercise;

import java.io.IOException;
import java.util.Scanner;

public class SelectionProcessor {

    private final InputService inputService;
    private final MenuSelector menuSelector;

    public SelectionProcessor(InputService inputService, MenuSelector menuSelector) {
        this.inputService = inputService;
        this.menuSelector = menuSelector;
    }

    public void executeEverything() {
        boolean goAhead = true;
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Hello user, and welcome!");

        do {
            try {
                String selection  = menuSelector.getUserInputSelection();
                runSelection(selection);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println();
            System.out.println("Would you like to continue? (Y/N)");
            String input = inputScanner.nextLine().toLowerCase();

            while (!input.equals("n") && !input.equals("y")) {
                System.out.println("Please enter Y or N");
                input = inputScanner.nextLine().toLowerCase();
            }

            if (input.equals("n")) {
                goAhead = false;
            }
        } while (goAhead);
    }

    public void runSelection(String selection) {
        switch (selection) {
            case "1" -> {
                System.out.println("Add a person!");
                inputService.createPersonAndSaveInDatabase();
            }
            case "2" -> {
                System.out.println("Delete a person!");
                inputService.deletePerson();
            }
            case "3" -> {
                System.out.println("Look up a person by ID!");
                inputService.lookUpPerson();
            }
            case "4" -> {
                System.out.println("Terminating program");
                System.exit(0);
            }
            default -> {
                System.out.println("please pick 1 - 4");
            }
        }
    }


}
