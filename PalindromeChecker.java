//Forget Nukeri Task2
import java.util.Scanner;//import the library that allow user input

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user input
        System.out.println("Welcome to the Palindrome Checker Level1-Task2!");
        System.out.print("Enter a string or number to check: ");
        String input = scanner.nextLine();

        // Check if the input is a palindrome or not
        if (isPalindrome(input)) {
            System.out.println("\"" + input + "\" is a palindrome!");
        } else {
            System.out.println("\"" + input + "\" is not a palindrome.");
        }

        scanner.close();
    }

    // Function to check if a string is a palindrome or not
    public static boolean isPalindrome(String input) {
        // Remove non-alphanumeric characters and convert to
        // lowercase
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Reverse the normalized string
        String reversed = new StringBuilder(normalized).reverse().toString();

        // Check if the original normalized string is equal to its reverse
        return normalized.equals(reversed);
    }
}
