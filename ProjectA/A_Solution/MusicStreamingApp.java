package ProjectA.A_Solution;

import java.util.*;

class Song {
    private final String title;
    private final String artist;
    private final int playCount;

    public Song(String title, String artist, int playCount) {
        this.title = title;
        this.artist = artist;
        this.playCount = playCount;
    }

    public String getTitle() {
        return title;
    }

    public int getPlayCount() {
        return playCount;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Artist: " + artist + ", Play Count: " + playCount;
    }
}

public class MusicStreamingApp {
    private final List<Song> songs = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MusicStreamingApp app = new MusicStreamingApp();
        app.run();
    }

    public void run() {
        initializeSongs();
        while (true) {
            System.out.println("\nMusic Streaming Service");
            System.out.println("1. Add a new song");
            System.out.println("2. Remove a song");
            System.out.println("3. Print all songs");
            System.out.println("4. Print songs over a given play count");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: addSong(); break;
                case 2: removeSong(); break;
                case 3: printAllSongs(); break;
                case 4: printSongsAbovePlayCount(); break;
                case 5:
                    System.out.println("Exiting application.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void initializeSongs() {
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

    private void addSong() {
        System.out.print("Enter song title: ");
        String title = scanner.nextLine();
        System.out.print("Enter artist name: ");
        String artist = scanner.nextLine();
        System.out.print("Enter play count: ");
        int playCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        songs.add(new Song(title, artist, playCount));
        System.out.println("Song added successfully!");
    }

    private void removeSong() {
        System.out.print("Enter song title to remove: ");
        String title = scanner.nextLine();

        boolean removed = songs.removeIf(song -> song.getTitle().equalsIgnoreCase(title));
        if (removed) {
            System.out.println("Song removed successfully.");
        } else {
            System.out.println("Song not found.");
        }
    }

    private void printAllSongs() {
        if (songs.isEmpty()) {
            System.out.println("No songs available.");
        } else {
            songs.forEach(System.out::println);
        }
    }

    private void printSongsAbovePlayCount() {
        System.out.print("Enter minimum play count: ");
        int minPlayCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        boolean found = false;
        for (Song song : songs) {
            if (song.getPlayCount() > minPlayCount) {
                System.out.println(song);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No songs found with more than " + minPlayCount + " plays.");
        }
    }
}
