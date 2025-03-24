package ProjectA.A_Solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {

    private Song song;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalSystemOut = System.out;

    @BeforeEach
    void setUp() {
        song = new Song("Song A", "Artist A", 1000);
        new MusicStreamingApp();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testSongTitle() {
        assertEquals("Song A", song.getTitle(), "The title should be 'Song A'");
    }

    @Test
    void testPlayCount() {
        assertEquals(1000, song.getPlayCount(), "The play count should be 1000");
    }

    @Test
    void testToString() {
        String expectedString = "Title: Song A, Artist: Artist A, Play Count: 1000";
        assertEquals(expectedString, song.toString(), "toString() method did not return the expected string");
    }

    @Test
    void testAddSong() {
        provideInput("1\nSong X\nArtist X\n5000\n5\n");
        MusicStreamingApp.main(new String[]{});
        assertTrue(getOutput().contains("Song added successfully!"));
    }

    @Test
    public void testRemoveSong() {
        provideInput("2\nSong A\n5\n");
        MusicStreamingApp.main(new String[]{});
        assertTrue(getOutput().contains("Song removed successfully."));
    }

    @Test
    public void testPrintAllSongs() {
        provideInput("3\n5\n");
        MusicStreamingApp.main(new String[]{});
        assertTrue(getOutput().contains("Song A"));
        assertTrue(getOutput().contains("Song J"));
    }

    @Test
    public void testPrintSongsAbovePlayCount() {
        // Step 1: Add songs first
        provideInput("1\nSong C\nArtist C\n150000\n1\nSong E\nArtist E\n200000\n1\nSong H\nArtist H\n300000\n5\n");
        MusicStreamingApp.main(new String[]{});

        // Step 2: Verify songs exist
        provideInput("3\n5\n");
        MusicStreamingApp.main(new String[]{});
        String allSongsOutput = getOutput();
        assertTrue(allSongsOutput.contains("Song C"), "Expected 'Song C' to be stored.");
        assertTrue(allSongsOutput.contains("Song E"), "Expected 'Song E' to be stored.");
        assertTrue(allSongsOutput.contains("Song H"), "Expected 'Song H' to be stored.");

        // Step 3: Test filtering with play count 100000
        provideInput("4\n100000\n5\n");
        MusicStreamingApp.main(new String[]{});
        String output = getOutput();
        assertTrue(output.contains("Song C"), "Expected 'Song C' to be printed.");
        assertTrue(output.contains("Song E"), "Expected 'Song E' to be printed.");
        assertTrue(output.contains("Song H"), "Expected 'Song H' to be printed.");

        // Step 4: Test filtering with play count 1000000 (expect no songs)
        provideInput("4\n1000000\n5\n");
        MusicStreamingApp.main(new String[]{});
        assertTrue(getOutput().contains("No songs found with more than 1000000 plays."),
                "Expected message for no songs found.");
    }


    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    private String getOutput() {
        return outputStreamCaptor.toString().trim();
    }

    @AfterEach
    void restoreSystemOutStream() {
        System.setOut(originalSystemOut);
        outputStreamCaptor.reset();
    }
}
