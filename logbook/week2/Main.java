package logbook.week2;

import java.util.Scanner; // Import Scanner for user input
import java.time.Year; // Import Year to get the current year

public class Main {
    public static void main(String[] args) {
        /* Create a Scanner object to take user input */
        Scanner scanner = new Scanner(System.in);

        /* Get the current year dynamically */
        int currentYear = Year.now().getValue();

        /* Prompt the user to enter their age */
        System.out.print("Enter your age: ");
        int age = scanner.nextInt(); // Store the user input in the variable 'age'

        /* Calculate the user's year of birth */
        int birthYear = currentYear - age;

        /* Display the calculated birth year */
        System.out.println("You were born in the year: " + birthYear);

        /* Check if the user is 18 or older */
        if (age >= 18) {
            System.out.println("You are an adult."); // Display if the user is 18 or older
        } else {
            System.out.println("You are under 18."); // Display if the user is under 18
        }

        /* Prompt the user to enter a letter grade */
        System.out.print("Enter your letter grade (A, B, C, D, E, F): ");
        char grade = scanner.next().toUpperCase().charAt(0); // Convert input to uppercase for consistency

        /* Convert letter grade to university classification */
        String classification;

        switch (grade) {
            case 'A':
                classification = "1st"; // First-class degree
                break;
            case 'B':
                classification = "2:1"; // Upper second-class degree
                break;
            case 'C':
                classification = "2:2"; // Lower second-class degree
                break;
            case 'D':
                classification = "3rd"; // Third-class degree
                break;
            case 'E':
                classification = "Ordinary"; // Ordinary degree
                break;
            case 'F':
                classification = "Fail"; // Failed
                break;
            default:
                classification = "Invalid grade entered"; // Handle incorrect input
                break;
        }
        /* Display the classification */
        System.out.println("Your classification is: " + classification);

        /* Use a for loop to print digits from 0 to 9 */
        System.out.println("Digits from 0 to 9:");
        for (int i = 0; i <= 9; i++) {
            System.out.print(i + " "); // Print each digit
        }
        System.out.println(); // Move to the next line

        /* Loop from 1 to 12 to print the 7 times table */
        System.out.println("Seven times multiplication table:");
        for (int i = 1; i <= 12; i++) {
            System.out.println(i + " x 7 = " + (i * 7)); // Print multiplication result
        }

        char choice; // Variable to store user choice

        /* Do-while loop to allow the user to restart the program */
        do {
            // Ask the user to enter a number
            System.out.print("\nEnter a number to see its multiplication table: ");
            int number = scanner.nextInt(); // Store user input

            // Loop from 1 to 12 to print the multiplication table
            for (int i = 1; i <= 12; i++) {
                System.out.println(i + " x " + number + " = " + (i * number)); // Print result
            }

            // Ask the user if they want to see another table
            System.out.print("Would you like to see another table? (Y/N): ");
            choice = scanner.next().charAt(0); // Get user input

        } while (choice == 'Y' || choice == 'y'); // Continue if user enters 'Y' or 'y'

        // Goodbye message when the user exits
        System.out.println("Thank you for using the multiplication table program. Goodbye!");
        /* Prompt the user to enter an exam mark */
        System.out.print("Enter your exam mark (0-100): ");
        int mark = scanner.nextInt(); // Read user input
        /* Validate input to ensure it is within the valid range */
        if (mark < 0 || mark > 100) {
            System.out.println("Invalid mark! Please enter a value between 0 and 100.");
        } else {
            /* Determine the grade based on the mark */
            char Grade;
            if (mark >= 90) {
                Grade = 'A'; // Excellent
            } else if (mark >= 80) {
                Grade = 'B'; // Very good
            } else if (mark >= 70) {
                Grade = 'C'; // Good
            } else if (mark >= 60) {
                Grade = 'D'; // Satisfactory
            } else if (mark >= 50) {
                Grade = 'E'; // Pass
            } else {
                Grade = 'F'; // Fail
            }
            /* Display the grade */
            System.out.println("Your grade is: " + Grade);
        }
        /* Loop from 1 to 10 */
        for (int i = 1; i <= 10; i++) {
            /* Check if the number is even */
            if (i % 2 == 0) {
                System.out.println(i); // Print the even number
            }
        }
        /* Close the scanner to prevent resource leaks */
        scanner.close();
    }
}
