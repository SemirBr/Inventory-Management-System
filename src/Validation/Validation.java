package Validation;

import java.util.Date;

import static Aplication.ECommerceApp.scanner;

public class Validation implements IValidation {


    @Override
    public int validateNumber() {
        int number = 0;
        try {

            number = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.err.println("Please insert number!");
            validateNumber();
        }
        return number;
    }

    @Override
    public double validateDouble() {
        double number = 0;
        try {
            number = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.err.println("Please insert decimal number!");
            validateDouble();
        }
        return number;
    }
    @Override
    public String validateString() {
        String input = scanner.nextLine();

        if (!input.matches("[a-zA-Z ]+")) {
            System.err.println("Please insert only letters!");
            validateString();
        }
        return input;
    }
}
