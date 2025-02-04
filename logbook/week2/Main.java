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

        /* Close the scanner to prevent resource leaks */
        scanner.close();
    }
}
