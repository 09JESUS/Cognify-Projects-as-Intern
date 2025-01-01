//Forget Nukeri Task 3
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Expanded Student Grade Calculator Level1-Task3!");
        System.out.print("Enter the number of students: ");
        int numberOfStudents;

        // Validate number of students user want to calculate for the average
        while (true) {
            if (scanner.hasNextInt()) {
                numberOfStudents = scanner.nextInt();
                if (numberOfStudents > 0) {
                    break;
                } else {
                    System.out.print("Please enter a positive number for students: ");
                }
            } else {
                System.out.print("Invalid input. Enter a positive integer: ");
                scanner.next();
            }
        }

        double classTotal = 0; // Total for class average calculation

        // Process grades for each student
        for (int student = 1; student <= numberOfStudents; student++) {
            System.out.println("\n--- Student " + student + " ---");
            System.out.print("Enter the number of grades for Student " + student + ": ");
            int numberOfGrades;

            // Validate number of grades must be a positive integer from numberOfGrades>0
            while (true) {
                if (scanner.hasNextInt()) {
                    numberOfGrades = scanner.nextInt();
                    if (numberOfGrades > 0) {
                        break;
                    } else {
                        System.out.print("Please enter a positive number for grades: ");
                    }
                } else {
                    System.out.print("Invalid input. Enter a positive integer: ");
                    scanner.next();
                }
            }

            double[] grades = new double[numberOfGrades];// store the grades into an array
            double total = 0;// assigned the total to 0 at first

            // Collect grades (store the grades into an array)
            for (int i = 0; i < numberOfGrades; i++) {
                System.out.print("Enter grade " + (i + 1) + " for Student " + student + ": ");
                while (true) {
                    if (scanner.hasNextDouble()) {
                        double grade = scanner.nextDouble();
                        if (grade >= 0 && grade <= 100) {
                            grades[i] = grade;
                            total += grade;
                            break;
                        } else {
                            System.out.print("Grade must be between 0 and 100. Try again: ");
                        }
                    } else {
                        System.out.print("Invalid input. Enter a valid grade: ");
                        scanner.next();
                    }
                }
            }

            // Calculate average and letter grades
            double average = total / numberOfGrades;
            classTotal += average;

            System.out.println("\n--- Grades for Student " + student + " ---");
            for (int i = 0; i < numberOfGrades; i++) {
                System.out.printf("Grade %d: %.2f (%s)%n", i + 1, grades[i], getLetterGrade(grades[i]));
            }
            System.out.printf("Average Grade: %.2f (%s)%n", average, getLetterGrade(average));
        }

        // Calculate and display class average
        double classAverage = classTotal / numberOfStudents;
        System.out.printf("\n--- Class Average ---\nAverage Grade: %.2f (%s)%n", classAverage,
                getLetterGrade(classAverage));

        scanner.close();
    }

    // Function to convert a numerical grade to a letter grade
    public static String getLetterGrade(double grade) {
        if (grade >= 90) {
            return "A";
        } else if (grade >= 80) {
            return "B";
        } else if (grade >= 70) {
            return "C";
        } else if (grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
