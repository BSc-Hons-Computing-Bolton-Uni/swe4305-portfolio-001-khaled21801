package ProjectA.A_Solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {

    private Song song;
    private MusicStreamingApp app; // Declare a MusicStreamingApp instance for testing addSong(), removeSong(), printAllSongs(), and printSongsAbovePlayCount()

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalSystemOut = System.out; // Store original System.out to restore later

    @BeforeEach
    void setUp() {
        // Initialize a Song object before each test
        song = new Song("Song A", "Artist A", 1000);

        // Initialize the MusicStreamingApp instance before each test
        app = new MusicStreamingApp();

        // Redirect System.out to capture printed output
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testSongTitle() {
        // Test the getTitle() method
        assertEquals("Song A", song.getTitle(), "The title should be 'Song A'");
    }


    @Test
    void testPlayCount() {
        // Test the getPlayCount() method
        assertEquals(1000, song.getPlayCount(), "The play count should be 1000");
    }

    @Test
    void testToString() {
        // Test the toString() method for expected string format
        String expectedString = "Title: Song A, Artist: Artist A, Play Count: 1000";
        assertEquals(expectedString, song.toString(), "toString() method did not return the expected string");
    }

    @Test
    void testAddSong() {
        // Create a new song to add
        Song newSong = new Song("Song X", "Artist X", 5000);

        // Add the song to the app
        app.addSong(newSong);

        // Verify that the song has been added
        assertEquals(1, app.getSongs().size(), "The song should be added to the list.");

        // Verify that the song details are correct
        Song addedSong = (Song) app.getSongs().get(0);
        assertEquals("Song X", addedSong.getTitle(), "The title of the added song should be 'Song X'");
        assertEquals("Artist X", addedSong.getArtist(), "The artist of the added song should be 'Artist X'");
        assertEquals(5000, addedSong.getPlayCount(), "The play count of the added song should be 5000");
    }

    @Test
    void testRemoveSong() {
        // Add a song to the app
        Song newSong = new Song("Song X", "Artist X", 5000);
        app.addSong(newSong);

        // Ensure the song was added
        assertEquals(1, app.getSongs().size(), "The song should be added to the list.");

        // Now remove the song
        app.removeSong("Song X");

        // Verify that the song has been removed
        assertEquals(0, app.getSongs().size(), "The song should be removed from the list.");

        // Try to remove a song that doesn't exist
        app.removeSong("Nonexistent Song");

        // Verify that no song was removed and the list is still empty
        assertEquals(0, app.getSongs().size(), "The list should still be empty.");
    }

    @Test
    void testPrintAllSongs() {
        // Add some songs to the app
        Song song1 = new Song("Song A", "Artist A", 1000);
        Song song2 = new Song("Song B", "Artist B", 5000);
        app.addSong(song1);
        app.addSong(song2);

        // Call printAllSongs method
        app.printAllSongs();

        // Check if the output is as expected
        String expectedOutput = "Title: Song A, Artist: Artist A, Play Count: 1000\n" +
                "Title: Song B, Artist: Artist B, Play Count: 5000\n";

        // Verify that the printed output matches the expected output
        assertEquals(expectedOutput, outputStreamCaptor.toString(), "The printed output did not match the expected format.");
    }

    @Test
    void testPrintSongsAbovePlayCount() {
        // Add some songs to the app
        Song song1 = new Song("Song A", "Artist A", 1000);
        Song song2 = new Song("Song B", "Artist B", 5000);
        Song song3 = new Song("Song C", "Artist C", 15000);
        app.addSong(song1);
        app.addSong(song2);
        app.addSong(song3);

        // Set the minimum play count to 5000

        // Call printSongsAbovePlayCount method (simulate user input for minPlayCount)
        app.printSongsAbovePlayCount();

        // Expected output after filtering songs with play count > 5000
        String expectedOutput = "Title: Song C, Artist: Artist C, Play Count: 15000\n";

        // Verify that the printed output matches the expected output
        assertEquals(expectedOutput, outputStreamCaptor.toString(), "The printed output did not match the expected songs.");
    }

    // Restore System.out to its original state after tests
    @AfterEach
    void restoreSystemOutStream() {
        System.setOut(originalSystemOut);
    }
}