package logbook.week1;

import java.util.Scanner; // Import Scanner to take user input

public class Main {
    public static void main(String[] args) {
        // Print "Hello World!" (Original Code)
        System.out.println("Hello World!");

        // Create a Scanner to get user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user for their name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine(); // Store the name in a variable

        // Print a personalized greeting
        System.out.println("Hello " + name + "!");

        scanner.close(); // Close the scanner (Good practice)
    }
}
