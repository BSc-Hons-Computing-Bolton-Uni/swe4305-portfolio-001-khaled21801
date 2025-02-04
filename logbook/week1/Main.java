package logbook.week1;

import java.util.Scanner; // Import Scanner to take user input
import java.time.Year; // Import Year to get the current year
import java.time.LocalDate; // Import LocalDate to handle date calculations
import java.time.temporal.ChronoUnit; // Import ChronoUnit to calculate the difference in days

public class Main {
    public static void main(String[] args) {
        // Print "Hello World!" (Original Code)
        System.out.println("Hello World!");

        // Create a Scanner object to get user input
        Scanner scanner = new Scanner(System.in);

        /* -------------------- User Name Input -------------------- */
        // Ask the user for their name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine(); // Store the name in a variable

        // Print a personalized greeting
        System.out.println("Hello " + name + "!");

        /* -------------------- Rectangle Calculations -------------------- */
        // Ask user to enter the length and height of a rectangle
        System.out.print("Enter the length of the rectangle: ");
        double length = scanner.nextDouble();

        System.out.print("Enter the height of the rectangle: ");
        double height = scanner.nextDouble();

        // Calculate perimeter and area
        double perimeter = 2 * (length + height);
        double area = length * height;

        // Display the results
        System.out.println("The perimeter of the rectangle is: " + perimeter);
        System.out.println("The area of the rectangle is: " + area);

        /* -------------------- Averaging Two Numbers -------------------- */
        // Ask the user to enter two numbers for averaging
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        // Calculate the average
        double average = (num1 + num2) / 2;

        // Display the result
        System.out.println("The average of " + num1 + " and " + num2 + " is: " + average);

        /* -------------------- Swapping Two Integers -------------------- */
        // Ask the user to enter two integers for swapping
        System.out.print("Enter the first integer: ");
        int firstNum = scanner.nextInt();

        System.out.print("Enter the second integer: ");
        int secondNum = scanner.nextInt();

        // Display the original order
        System.out.println("\nOriginal Order:");
        System.out.println("First number: " + firstNum);
        System.out.println("Second number: " + secondNum);

        // Swap the values using a temporary variable
        int temp = firstNum;
        firstNum = secondNum;
        secondNum = temp;

        // Display the reversed order
        System.out.println("\nAfter Swapping:");
        System.out.println("First number: " + firstNum);
        System.out.println("Second number: " + secondNum);

        /* -------------------- Calculate Year of Birth -------------------- */
        // Get the current year
        int currentYear = Year.now().getValue();

        // Ask the user to enter their age
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        // Calculate the year of birth
        int birthYear = currentYear - age;

        // Display the year of birth
        System.out.println("You were born in the year: " + birthYear);

        /* -------------------- Calculate Days Old -------------------- */
        // Ask the user for their full date of birth
        System.out.print("Enter your birth year (YYYY): ");
        int dobYear = scanner.nextInt();

        System.out.print("Enter your birth month (MM): ");
        int dobMonth = scanner.nextInt();

        System.out.print("Enter your birth day (DD): ");
        int dobDay = scanner.nextInt();

        // Store the user's date of birth as a LocalDate object
        LocalDate birthDate = LocalDate.of(dobYear, dobMonth, dobDay);

        // Get today's date
        LocalDate today = LocalDate.now();

        // Calculate the number of days old
        long daysOld = ChronoUnit.DAYS.between(birthDate, today);

        // Display the result
        System.out.println("You are approximately " + daysOld + " days old.");

        /* -------------------- Convert Feet to Miles -------------------- */
        // Ask the user to enter the number of feet
        System.out.print("Enter the number of feet: ");
        double feet = scanner.nextDouble(); // Store the feet value

        // Convert feet to miles (1 mile = 5280 feet)
        double miles = feet / 5280;

        // Display the result
        System.out.println(feet + " feet is equal to " + miles + " miles.");

        /* -------------------- Interest Calculation -------------------- */
        // Fixed interest rate of 1% (0.01 in decimal)
        final double INTEREST_RATE = 0.01;

        // Ask the user to enter the deposit amount
        System.out.print("Enter the deposit amount: $");
        double deposit = scanner.nextDouble(); // Store deposit amount

        // Calculate total amount after interest
        double totalAmount = deposit * (1 + INTEREST_RATE);

        // Display the result
        System.out.println("After 1 year at 1% interest, your total balance will be: $" + totalAmount);

        // Close the scanner (Good practice)
        scanner.close();
    }
}
