// TODO Add Complete File Header

import java.util.ArrayList;

/**
 * A class to test the functionality of the {@code Playlist} and {@code PlaylistGenerator} classes.
 * It includes tests for simple, permutation-based, and optimal playlist generation methods.
 */
public class PlaylistTester {
    /**
     * Tests the base cases for the simple playlist generator. Ensures that an empty song list and a
     * playlist already at max duration are handled correctly.
     *
     * @return true if all base cases pass, false otherwise
     */
    public static boolean simpleGeneratorBaseCaseTest() {
        // TODO Base Case 1: Empty song list

        // TODO Base Case 2: Existing playlist already meets max duration

        return false; // default return statement
    }

    /**
     * Tests the simple playlist generator with one song adding to a non-empty playlist. Ensures that
     * a song fitting within the duration limit is added, and one exceeding the limit is not added.
     *
     * @return true if all tests pass, false otherwise
     */
    public static boolean simpleGeneratorOneStepTest() {
        // TODO Case 1: One song that fits


        // TODO Case 2: One song that does not fit

        return false; // default return statement
    }

    /**
     * Tests the recursive functionality of the simple playlist generator. Ensures that multiple songs
     * are added without exceeding the duration limit.
     *
     * @return true if the recursive addition works correctly, false otherwise
     */
    public static boolean simpleGeneratorRecursiveTest() {
        // TODO Test Case: Multiple songs, ensuring correct recursive addition

        return false; // default return statement
    }

    /**
     * Tests the permutation generation method for song lists. Verifies that all permutations are
     * generated correctly. You may consider checking the size of results and the size of each
     * permutation in results.
     *
     * @return true if this tester verifies a correct functionality, false otherwise
     */
    public static boolean generatePermutationsTest() {
        // TODO Case 1: empty song list


        // TODO Case 2: normal case (not empty song list)

        return false; // default return statement
    }

    /**
     * Tests the permutation-based playlist generation method. Ensures that multiple songs (at least
     * three) are permuted and the best playlist is selected without exceeding the maximum duration.
     *
     * @return true if the permutation-based playlist is generated correctly, false otherwise
     */
    public static boolean bestPermutationPlaylistRecursiveTest() {
        // TODO Case: Multiple songs, ensuring permutations are checked
        ArrayList<Song> testPlaylist = new ArrayList<>();

        //creating songs
        Song song1 = new Song("title1", "genre1", 20);
        Song song2 = new Song("title2", "genre2", 30);
        Song song3 = new Song("title3", "genre3", 40);
        Song song4 = new Song("title4", "genre4", 10);

        //adding songs to test playlist
        testPlaylist.add(song1);
        testPlaylist.add(song2);
        testPlaylist.add(song3);
        testPlaylist.add(song4);

        //expected results
        int expectedDuration = 80;
        int expectedSize = 3;

        //calling method to test
        Playlist resultingPlaylist = PlaylistGenerator.bestPermutationPlaylist(testPlaylist, 80);

        //checking if results match with expected results
        if (resultingPlaylist.getTotalDuration() == expectedDuration && resultingPlaylist.size() == expectedSize) {
            return true;
        }

        return false;

    }

    /**
     * Tests the optimal playlist generation with base cases. Ensures correct handling of empty song
     * lists and playlists already at max duration.
     *
     * @return true if base cases are handled correctly, false otherwise
     */
    public static boolean optimalPlaylistBaseCaseTest() {
        ArrayList<Song> emptySongPlaylist = new ArrayList<>(); //creating empty songs list
        Playlist emptyPlaylist = new Playlist(); //creating empty playlist

        //calling method to test and passing parameters
        Playlist result = PlaylistGenerator.optimalPlaylist(emptySongPlaylist, emptyPlaylist, 100);

        //testing if 0
        if ((result.getTotalDuration() == 0) && (result.size() == 0)) {
            ArrayList<Song> songsList = new ArrayList<>();

            Song song1 = new Song("song1", "genre1", 30);
            Song song2 = new Song("song2", "genre2", 40);

            //adding songs
            songsList.add(song1);
            songsList.add(song2);

            Playlist playlist = new Playlist();
            playlist = playlist.addSong(song1);
            playlist = playlist.addSong(song2);

            //calling method again
            Playlist result2 = PlaylistGenerator.optimalPlaylist(songsList, playlist, 70);

            //checking if results match what is expected
            if (result2.getTotalDuration() == 70 && result2.size() == 2) {

                return true;

            }
        }

        return false; //false if not what is expected

    }


    /**
     * Tests the optimal playlist generation method with one-step cases adding to a nonempty playlist.
     * Ensures that a song fitting within the maximum duration is added, and a song exceeding the
     * limit is not added.
     *
     * @return true if the optimal playlist handles one-step cases correctly, false otherwise
     */
    public static boolean optimalPlaylistOneStepTest() {
        ArrayList<Song> songList = new ArrayList<>(); //declaring songs list
        Playlist playlist1 = new Playlist(); //creating new playlist

        Song song1 = new Song("song1", "genre1", 30); //creating song
        songList.add(song1); //adding song

        //declaring maxDuration variable
        int maxDuration1 = 50;

        //calling method optimalPlaylist
        Playlist result1 = PlaylistGenerator.optimalPlaylist(songList, playlist1, maxDuration1);

        //checking if results match and if so enter if statement
        if ((result1.getTotalDuration() == 30) && (result1.size() == 1)) {
            ArrayList<Song> songList2 = new ArrayList<>();
            Playlist playlist2 = new Playlist();

            Song song2 = new Song("song2", "genre2", 60);  // Song that exceeds max duration
            songList2.add(song2);


            Playlist result2 = PlaylistGenerator.optimalPlaylist(songList2, playlist2, 50);

            if (result2.getTotalDuration() == 0 && result2.size() == 0) {

                return true;

            }
        }

        return false; //false if doesn't pass

    }


    /**
     * Tests the optimal playlist generation method with multiple songs. Ensures that recursive
     * backtracking selects the best playlist without exceeding the maximum duration.
     *
     * @return true if the optimal playlist is generated correctly, false otherwise
     */
    public static boolean optimalPlaylistRecursiveTest() {
        // TODO Case: Multiple songs, ensuring permutations are checked
        ArrayList<Song> songs = new ArrayList<>();
        Playlist testPlaylist = new Playlist();
        int maxDuration = 115; //creating maxDuration variable
        int expectedDuration = 115; //the expected duration as a variable
        int expectedSize = 5; //expected size as a variable

        //creating songs to add to playlist
        Song song1 = new Song("title1", "genre1", 20);
        Song song2 = new Song("title2", "genre2", 30);
        Song song3 = new Song("title3", "genre3", 40);
        Song song4 = new Song("title4", "genre4", 10);
        Song song5 = new Song("title5", "genre5", 35);
        Song song6 = new Song("title6", "genre6", 20);

        //adding songs
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
        songs.add(song5);
        songs.add(song6);

        //calling method
        Playlist optimalPlaylist = PlaylistGenerator.optimalPlaylist(songs, testPlaylist, maxDuration);

        //check if method returns what is expected
        if (optimalPlaylist.getTotalDuration() == expectedDuration && optimalPlaylist.size() == expectedSize) {
            return true;
        }

        return false;
    }

    /**
     * The main method runs all test cases for the playlist generator.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------------");
        System.out.println(
                "simpleGeneratorBaseCaseTest: " + (simpleGeneratorBaseCaseTest() ? "Pass" : "Failed!"));
        System.out.println("-----------------------------------------------------------");
        System.out.println(
                "simpleGeneratorOneStepTest: " + (simpleGeneratorOneStepTest() ? "Pass" : "Failed!"));
        System.out.println("-----------------------------------------------------------");
        System.out.println(
                "simpleGeneratorRecursiveTest: " + (simpleGeneratorRecursiveTest() ? "Pass" : "Failed!"));
        System.out.println("-----------------------------------------------------------");
        System.out.println(
                "generatePermutationsTest: " + (generatePermutationsTest() ? "Pass" : "Failed!"));
        System.out.println("-----------------------------------------------------------");
        System.out.println("bestPermutationPlaylistRecursiveTest: " + (bestPermutationPlaylistRecursiveTest() ?
                "Pass" :
                "Failed!"));
        System.out.println("-----------------------------------------------------------");
        System.out.println(
                "optimalPlaylistBaseCaseTest: " + (optimalPlaylistBaseCaseTest() ? "Pass" : "Failed!"));
        System.out.println("-----------------------------------------------------------");
        System.out.println(
                "optimalPlaylistOneStepTest: " + (optimalPlaylistOneStepTest() ? "Pass" : "Failed!"));
        System.out.println("-----------------------------------------------------------");
        System.out.println(
                "optimalPlaylistRecursiveTest: " + (optimalPlaylistRecursiveTest() ? "Pass" : "Failed!"));
        System.out.println("-----------------------------------------------------------");
    }


}
