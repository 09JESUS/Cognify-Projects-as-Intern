//Forget Nukeri Task1
import java.util.Scanner;//Import te library that allow user to enter input

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Temperature Converter   Level1-Task1!");
        try {
            System.out.print("Enter the temperature value: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid temperature value. Please enter a number.");
                return;
            }
            // make user input be double
            double temperature = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character.

            System.out.print("Enter the unit of measurement (C for Celsius, F for Fahrenheit): ");
            String input = scanner.nextLine().trim().toUpperCase();// convert the character to the uppercase

            if (input.length() != 1 || (input.charAt(0) != 'C' && input.charAt(0) != 'F')) {// check user input for the
                                                                                            // unit
                System.out.println("Invalid unit of measurement. Please enter C or F.");
                return;
            }

            char unit = input.charAt(0);// accept the unit for user input

            // check if the user have entered one of the unit either(C-Celsius or
            // F-Fahrenheit)
            if (unit == 'C') {
                // convert the celsius to fahrenheit
                double fahrenheit = (temperature * 9 / 5) + 32;
                // display the Results to the user
                System.out.printf("%.2f°C is equal to %.2f°F%n", temperature, fahrenheit);
            } else if (unit == 'F') {
                double celsius = (temperature - 32) * 5 / 9;
                System.out.printf("%.2f°F is equal to %.2f°C%n", temperature, celsius);
            }
        } catch (Exception e) {// try catch report back error message if the input vallidation not properly
                               // implemented
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
