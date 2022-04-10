package exercise;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class InputService {

    private final PersonRepository personRepository;
    private final InputValidator inputValidator;
    private final Scanner scanner;

    public InputService(PersonRepository personRepository, InputValidator inputValidator, Scanner scanner) {
        this.personRepository = personRepository;
        this.inputValidator = inputValidator;
        this.scanner = scanner;
    }

    public void createPersonAndSaveInDatabase() {

        String validId = getValidUniqueIdForNewPerson(personRepository);
        String validName = getValidNameOrSurname("Please enter Name (\"q\" to cancel):");
        String validSurname = getValidNameOrSurname("Please enter surname (\"q\" to cancel):");

        personRepository.addPerson(new Person(validName, validSurname, validId));
    }

    private String getValidIdFormatFromInput() {

        String validId = "";

        System.out.println("Please enter ID (\"q\" to cancel):");

        while (true) {
            try {
                String id = scanner.nextLine();
                if (id.matches("q")) {
                    break;
                }
                if (inputValidator.validateID(id)) {
                    validId = id.replaceAll("/", "");
                    break;
                }
            } catch (ValidationException e) {
                System.err.println(e.getMessage());
            }
        }
        return validId;
    }

    private String getValidUniqueIdForNewPerson(PersonRepository personRepository) {
        String validIdForNewPerson = "";

        try {
            validIdForNewPerson = getValidIdFormatFromInput();
            if (personRepository.personExistsInDatabase(validIdForNewPerson)) {
                throw new ValidationException("Entered ID already exists in database.");
            }
        } catch (ValidationException e) {
            System.err.println(e.getMessage());
        }
        return validIdForNewPerson;
    }

    private String getValidNameOrSurname(String message) {
        String name = "";
        System.out.println(message);
        while (true) {
            try {
                String s = scanner.nextLine();
                if (s.matches("q")) {
                    break;
                }
                if (inputValidator.validateNameOrSurname(s)) {
                    name = s;
                    break;
                }
            } catch (ValidationException e) {
                System.err.println(e.getMessage());
            }
        }
        return name;
    }

    public void lookUpPerson() {
        try {
            String validId = getValidIdFormatFromInput();
            if (!validId.isBlank()) {
                if (!personRepository.personExistsInDatabase(validId)) {
                    throw new ValidationException("Entered ID does not exist in database!");
                }
                Person person = personRepository.getPesonById(validId);
                System.out.println("ID: " + person.getId());
                System.out.println("Name: " + person.getName());
                System.out.println("Surname: " + person.getSurname());
                System.out.println("Age: " + calculateAge(validId));
            }

        } catch (ValidationException e) {
            System.err.println(e.getMessage());
        }
    }

    public int calculateAge(String id) {
        int year = Integer.parseInt(id.substring(0, 2));
        int month = Integer.parseInt(id.substring(2, 4));
        int day = Integer.parseInt(id.substring(4, 6));

        if (year > 22) {
            year += 1900;
        } else {
            year += 2000;
        }

        if (month > 12) {
            month -= 50;
        }

        LocalDate birthDate = LocalDate.of(year, month, day);
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public void deletePerson() {
        try {
            String validId = getValidIdFormatFromInput();
            if (!validId.isBlank()) {
                if (!personRepository.personExistsInDatabase(validId)) {
                    throw new ValidationException("Entered ID does not exist in database!");
                }
                personRepository.deletePerson(validId);
                System.out.println("The person with the id " + validId + " has been deleted.");
            }
        } catch (ValidationException e) {
            System.err.println(e.getMessage());
        }
    }
}
