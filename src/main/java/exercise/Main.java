package exercise;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PersonRepository personRepository = new PersonRepository();
        Scanner scanner = new Scanner(System.in);
        InputValidator inputValidator = new InputValidator();
        InputService inputService = new InputService(personRepository, inputValidator, scanner);
        MenuSelector menuSelector = new MenuSelector(scanner);
        SelectionProcessor selectionProcessor = new SelectionProcessor(inputService, menuSelector);

        selectionProcessor.executeEverything();
    }
}
