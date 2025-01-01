//Forget Nukeri Task4
import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Random Password Generator!");

        // Prompt for password length
        System.out.print("Enter the desired length of the password: ");
        int length;
        while (true) {
            if (scanner.hasNextInt()) {
                length = scanner.nextInt();
                if (length > 0) {
                    break;
                } else {
                    System.out.print("Please enter a positive number: ");
                }
            } else {
                System.out.print("Invalid input. Enter a positive integer: ");
                scanner.next();
            }
        }

        // Prompt for character preferences
        System.out.println("Should the password include the following?");
        System.out.print("Numbers (0-9)? (yes/no): ");
        boolean includeNumbers = getYesOrNo(scanner);

        System.out.print("Lowercase letters (a-z)? (yes/no): ");
        boolean includeLowercase = getYesOrNo(scanner);

        System.out.print("Uppercase letters (A-Z)? (yes/no): ");
        boolean includeUppercase = getYesOrNo(scanner);

        System.out.print("Special characters (!@#$%^&*...)? (yes/no): ");
        boolean includeSpecial = getYesOrNo(scanner);

        // Ensure at least one character type is selected
        if (!includeNumbers && !includeLowercase && !includeUppercase && !includeSpecial) {
            System.out.println("You must select at least one character type. Exiting program.");
            scanner.close();
            return;
        }

        // Generate password
        String password = generatePassword(length, includeNumbers, includeLowercase, includeUppercase, includeSpecial,
                random);
        System.out.println("\nGenerated Password: " + password);

        scanner.close();
    }

    // Method to validate yes/no input
    private static boolean getYesOrNo(Scanner scanner) {
        while (true) {
            String input = scanner.next().trim().toLowerCase();
            if (input.equals("yes") || input.equals("y")) {
                return true;
            } else if (input.equals("no") || input.equals("n")) {
                return false;
            } else {
                System.out.print("Invalid input. Please enter 'yes' or 'no': ");
            }
        }
    }

    // function to generate random password
    private static String generatePassword(int length, boolean includeNumbers, boolean includeLowercase,
            boolean includeUppercase, boolean includeSpecial, Random random) {
        String numbers = "0123456789";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special = "!@#$%^&*()-_=+[]{}|;:,.<>?/~`";

        StringBuilder characterPool = new StringBuilder();

        // if(yes) ->append(add random characterpool variable)
        if (includeNumbers) {
            characterPool.append(numbers);
        }
        if (includeLowercase) {
            characterPool.append(lowercase);
        }
        if (includeUppercase) {
            characterPool.append(uppercase);
        }
        if (includeSpecial) {
            characterPool.append(special);
        }

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        return password.toString();// return the combination of yes as password to the user.
    }
}
