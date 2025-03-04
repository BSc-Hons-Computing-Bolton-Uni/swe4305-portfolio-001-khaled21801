package ProjectA.A_Solution;

import java.util.*;

// The song class represents a single song in the music streaming application
class Song {
    private final String title;  // Title of the song
    private final String artist; // Artist of the song
    private final int playCount; // Number of plays the song has

    // Constructor to initialize the song object
    public Song(String title, String artist, int playCount) {
        this.title = title;
        this.artist = artist;
        this.playCount = playCount;
    }

    // Getter for song title
    public String getTitle() {
        return title;
    }

    // Getter for play count of the song
    public int getPlayCount() {
        return playCount;
    }

    // Overridden toString method to return song details as a string
    @Override
    public String toString() {
        return "Title: " + title + ", Artist: " + artist + ", Play Count: " + playCount;
    }
}

public class MusicStreamingApp {
    private final List<Song> songs = new ArrayList<>(); // List to store songs in the app
    private final Scanner scanner = new Scanner(System.in); // Scanner object for user input

    // Main method to start the music streaming application
    public static void main(String[] args) {
        MusicStreamingApp app = new MusicStreamingApp(); // Create a new music app instance
        app.run(); // Run the app
    }

    // Run method contains the main loop for handling user input
    public void run() {
        initializeSongs(); // Initialize the list of songs when the app starts
        while (true) {
            // Display menu options
            System.out.println("\nMusic Streaming Service");
            System.out.println("1. Add a new song");
            System.out.println("2. Remove a song");
            System.out.println("3. Print all Songs");
            System.out.println("4. Print songs over a given play count");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            // Get the user's choice from the menu
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Switch case to handle different menu options
            switch (choice) {
                case 1: addSong(); break; // Option 1: Add a new song
                case 2: removeSong(); break; // Option 2: Remove a song
                case 3: printAllSongs(); break; // Option 3: Print all songs
                case 4: printSongsAbovePlayCount(); break; // Option 4: Print songs above a certain play count
                case 5:
                    System.out.println("Exiting application."); // Option 5: Exit the app
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice. Please try again."); // Invalid option
            }
        }
    }

    // Method to initialize some sample songs for the app
    private void initializeSongs() {
        // Adding some predefined songs to the list
        songs.add(new Song("Song A", "Artist A", 10000));
        songs.add(new Song("Song B", "Artist B", 50000));
        songs.add(new Song("Song C", "Artist C", 120000));
        songs.add(new Song("Song D", "Artist D", 4500));
        songs.add(new Song("Song E", "Artist E", 300000));
        songs.add(new Song("Song F", "Artist F", 80000));
        songs.add(new Song("Song G", "Artist G", 15000));
        songs.add(new Song("Song H", "Artist H", 200000));
        songs.add(new Song("Song I", "Artist I", 75000));
        songs.add(new Song("Song J", "Artist J", 9000));
    }

    // Method to add a new song to the app
    private void addSong() {
        System.out.print("Enter song title: "); // Prompt for song title
        String title = scanner.nextLine(); // Read title
        System.out.print("Enter artist name: "); // Prompt for artist name
        String artist = scanner.nextLine(); // Read artist name
        System.out.print("Enter play count: "); // Prompt for play count
        int playCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Create and add the new song to the list
        songs.add(new Song(title, artist, playCount));
        System.out.println("Song added successfully!"); // Confirmation message
    }

    // Method to remove a song from the app based on title
    private void removeSong() {
        System.out.print("Enter song title to remove: "); // Prompt for the song title to be removed
        String title = scanner.nextLine(); // Read the song title

        // Try to remove the song by matching the title
        boolean removed = songs.removeIf(song -> song.getTitle().equalsIgnoreCase(title));
        if (removed) {
            System.out.println("Song removed successfully."); // Song removed
        } else {
            System.out.println("Song not found."); // Song not found in the list
        }
    }

    // Method to print all songs in the app
    private void printAllSongs() {
        if (songs.isEmpty()) {
            System.out.println("No songs available."); // No songs to display
        } else {
            // Print each song's details
            songs.forEach(System.out::println);
        }
    }

    // Method to print songs that have a play count greater than a given value
    private void printSongsAbovePlayCount() {
        System.out.print("Enter minimum play count: "); // Prompt for minimum play count
        int minPlayCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        boolean found = false;
        // Loop through all songs and print those with play count greater than the input
        for (Song song : songs) {
            if (song.getPlayCount() > minPlayCount) {
                System.out.println(song); // Print the song details
                found = true;
            }
        }
        // If no songs are found with a play count greater than the input
        if (!found) {
            System.out.println("No songs found with more than " + minPlayCount + " plays.");
        }
    }
}
