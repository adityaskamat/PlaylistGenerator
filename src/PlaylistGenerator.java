// TODO Add a Complete File Header
// Geeks for Geeks: https://www.geeksforgeeks.org/arraylist-sublist-method-in-java-with-examples/
// YouTube Video: https://www.youtube.com/watch?v=Q83nN97LVOU
// YouTube Video: https://www.youtube.com/watch?v=ngCos392W4w
// W3Schools: https://www.w3schools.com/java/java_recursion.asp
// Stack Overflow: https://stackoverflow.com/questions/26041546/how-to-understand-the-concept-of-recursion-in-java


import java.util.ArrayList;
import java.util.Collections;
// No additional imports are allowed




/**
 * A utility class for generating playlists based on different strategies. This class provides
 * methods to generate playlists using simple, permutation-based, and optimal backtracking
 * approaches.
 */
public class PlaylistGenerator {


    /**
     * RECURSIVE method: Generates a simple playlist by adding the first available songs until the
     * maximum duration is reached.
     *
     * @param songs       the list of available songs
     * @param playlist    the current playlist being generated
     * @param maxDuration the maximum allowed duration for the playlist
     * @return a playlist containing songs that fit within the specified duration
     */
    public static Playlist simplePlaylist(ArrayList<Song> songs, Playlist playlist, int maxDuration) {
        // TODO implement this method recursively
        // This method MUST NOT use any loop


        //Base Case 1:
        //Ask why?
        if(songs.isEmpty()){
            return playlist;
        }
        //Base Case 2: maximum duration
        if(playlist.getTotalDuration() >= maxDuration){
            return playlist;
        }


        //Recursive Case:
        Song firstSong = songs.get(0);


        //CITE: Geeks for Geeks
        ArrayList<Song> remainingSongs = new ArrayList<>(songs.subList(1, songs.size()));


        if(playlist.canAddSong(firstSong,maxDuration)){
            Playlist updatedPlaylist = playlist.addSong(firstSong);


            return simplePlaylist(remainingSongs,updatedPlaylist, maxDuration);


        } else{
            return simplePlaylist(remainingSongs,playlist,maxDuration);
        }


    }//end of simplePlaylist method


    /**
     * RECURSIVE method: Generates all permutations of the given song list.
     *
     * @param songs  the list of songs to permute
     * @param index  the current index for generating permutations
     * @param result the list to store ALL the generated permutations
     */
    public static void generatePermutations(ArrayList<Song> songs, int index,
                                            ArrayList<ArrayList<Song>> result) {
        // TODO implement this method recursively


        //Base Case:
        if(index == songs.size() - 1){
            result.add(new ArrayList<>(songs));
            return;
        }


        //Recursive Case:


        for(int i = index; i < songs.size(); i++){
            swap(songs, index, i);// no collections
            generatePermutations(songs, index + 1, result);
            swap(songs, index, i);


        }




    }// end of generatePermutations method




    /**
     * This is a helper method for the generatePermutations method. This is
     * used to
     *
     * @param songs       the list of available songs
     * @param var1        this is the first element in the ArrayList that we are swapping
     * @param var2        this is the second element in the ArrayList that we are swapping
     *
     */
    private static void swap(ArrayList<Song> songs, int var1, int var2){
        Song temp = songs.get(var1);
        songs.set(var1, songs.get(var2));
        songs.set(var2,temp);


    }//end of swap method


    /**
     * Generates the best possible playlist by evaluating all permutations of the song list. It
     * selects the permutation that maximizes the total playlist duration without exceeding the
     * limit.
     *
     * @param songs       the list of available songs
     * @param maxDuration the maximum allowed duration for the playlist
     * @return the best possible playlist based on all song permutations
     */
    public static Playlist bestPermutationPlaylist(ArrayList<Song> songs, int maxDuration) {
        // TODO implement this method
        // [HINT] Use generatePermutations() and simplePlaylist() methods to implement this behavior
        // YouTube Video: https://www.youtube.com/watch?v=Q83nN97LVOU
        // YouTube Video: https://www.youtube.com/watch?v=ngCos392W4w


        //create array list of array list of songs
        ArrayList<ArrayList<Song>> listOfPermutations = new ArrayList<>();

        //call generatePermutations method
        generatePermutations(new ArrayList<>(songs),0,listOfPermutations);


        Playlist bestPlaylist = new Playlist(); //create arrayList to represent best permutation
        int bestDuration = 0; //initialize value

        //enhanced for loop to run through listOfPermutations
        // W3Schools: https://www.w3schools.com/java/java_recursion.asp
        for(ArrayList<Song> perm : listOfPermutations) {
            //assign the current playlist by calling simplePlaylist
            Playlist currentPlaylist = simplePlaylist(perm, new Playlist(), maxDuration);
            int currentDuration = currentPlaylist.getTotalDuration();

            //if the current duration of playlist is greater than the best playlist then
            // assign bestPlaylist and bestDuration
            if (currentDuration > bestDuration) {
                bestPlaylist = currentPlaylist;
                bestDuration = currentDuration;
            }
        }


        return bestPlaylist; //return the best permutation
    }// end of bestPermutationPlaylist




    /**
     * RECURSIVE method: Generates an optimal playlist using a backtracking approach to maximize the
     * total duration while staying within the maximum allowed duration.
     *
     * @param songs       the list of available songs
     * @param playlist    the current playlist being generated
     * @param maxDuration the maximum allowed duration for the playlist
     * @return the optimal playlist with the maximum possible duration based on the backtracking
     * approach
     */
    public static Playlist optimalPlaylist(ArrayList<Song> songs, Playlist playlist,
                                           int maxDuration) {
        // TODO implement this method recursively
        // This method MUST NOT use any loop
        // W3Schools: https://www.w3schools.com/java/java_recursion.asp

        //base case
        if(playlist.getTotalDuration() >= maxDuration){
            return playlist;
        }

        //base case
        if(songs.isEmpty()){
            return playlist;
        }


        Playlist bestPlaylist = playlist; //start by assigning bestPlaylist with first playlist
        int bestDuration = playlist.getTotalDuration();


        for(int i = 0; i < songs.size(); i++) {
            Song currentSong = songs.get(i);

            //check if song can be added
            if(playlist.canAddSong(currentSong, maxDuration)){
                Playlist updatedPlaylist = playlist.addSong(currentSong);


                ArrayList<Song> remainingSongs = new ArrayList<>(songs);
                remainingSongs.remove(i);

                //recursive call of optimalPlaylist
                Playlist resultPlaylist = optimalPlaylist(remainingSongs,
                        updatedPlaylist, maxDuration);

                //if the total duration of the result is greater than the best duration
                //assign bestPlaylist and bestDuration with values
                // Stack Overflow: https://stackoverflow.com/questions/26041546/
                // how-to-understand-the-concept-of-recursion-in-java
                if(resultPlaylist.getTotalDuration() > bestDuration){
                    bestPlaylist = resultPlaylist;
                    bestDuration = resultPlaylist.getTotalDuration();
                }
            }
        }




        return bestPlaylist; //return the best playlist
    }//end of optimalTest method




}//end of class

