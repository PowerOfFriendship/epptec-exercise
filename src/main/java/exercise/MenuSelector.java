package exercise;

import java.io.IOException;
import java.util.Scanner;

public class MenuSelector {

    private final Scanner scanner;

    public MenuSelector(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getUserInputSelection() throws IOException {

        System.out.println();
        System.out.println("Please select an option (enter number and press ENTER)");
        System.out.println("======================================================");
        System.out.println("| 1 to add a person                                  |");
        System.out.println("| 2 to delete a person                               |");
        System.out.println("| 3 to look up a person by ID (format: YYMMDDXXXX)   |");
        System.out.println("| 4 to exit                                          |");
        System.out.println("======================================================");
        System.out.println();

        return scanner.nextLine();
    }
}


