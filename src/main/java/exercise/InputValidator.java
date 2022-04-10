package exercise;

import java.util.regex.Pattern;

public class InputValidator {

    public boolean validateID(String idInput) throws ValidationException {

        if (idInput.isEmpty()) {
            throw new ValidationException("ID can not be empty.");
        }

        Pattern pattern = Pattern.compile("^\\d{6}/?\\d{4}$");
        if (!pattern.matcher(idInput).matches()){
            throw new ValidationException("Entered ID is invalid. Please enter a valid ID, "
                    + "either in format YYMMDDXXXX or YYMMDD/XXXX.");
        }
        return true;
    }

    public boolean validateNameOrSurname(String nameInput) throws ValidationException {

        if (nameInput.isBlank()) {
            throw new ValidationException("Name can not be empty.");
        }
        Pattern pattern = Pattern.compile("^[A-Z][a-z]+$");
        if (!pattern.matcher(nameInput).matches()){
            throw new ValidationException("Invalid input. Must start with an uppercase letter, " +
                    "can only contain English letters " +
                    "can not be a single letter");
        }
        return true;
    }

}
