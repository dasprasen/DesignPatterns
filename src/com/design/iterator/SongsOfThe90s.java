package com.design.iterator;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * @author Prasenjit Kumar Das
 */
public class SongsOfThe90s implements SongIterator {
    // Create a Hashtable with an int as a key and SongInfo
    // Objects
    Hashtable<Integer, SongInfo> bestSongs = new Hashtable<Integer, SongInfo>();
    // Will increment the Hashtable key
    int hashKey = 0;
    public SongsOfThe90s() {
        addSong("Losing My Religion", "REM", 1991);
        addSong("Creep", "Radiohead", 1993);
        addSong("Walk on the Ocean", "Toad The Wet Sprocket", 1991);

    }

    // Add a new SongInfo Object to the Hashtable and then increment
    // the Hashtable key
    public void addSong(String songName, String bandName, int yearReleased){
        SongInfo songInfo = new SongInfo(songName, bandName, yearReleased);
        bestSongs.put(hashKey, songInfo);
        hashKey++;
    }

    // NEW By adding this method I'll be able to treat all
    // collections the same
    public Iterator createIterator() {
        // TODO Auto-generated method stub
        return bestSongs.values().iterator();
    }
}
