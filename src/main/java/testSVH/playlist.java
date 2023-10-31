package testSVH;

import java.util.*;

import static java.util.Collections.emptyList;

public class playlist {

    Map<String, List<String>> playlistPerUser;
    private int capacity;

    public playlist(int initialCapacity) {
        this.capacity = initialCapacity;
        this.playlistPerUser = new HashMap<String, List<String>>();
       
    }

    /**
     * This method will store the user and songname in hash map.
     * and list and remove if the duplicate name exist.
     * @param user
     * @param songname
     */
    public void recentlyPlayedSong(String user, String songname) {
        List<String> userPlaylist = playlistPerUser.getOrDefault(user, new ArrayList());
        userPlaylist.remove(songname);
        userPlaylist.add(songname);
        playlistPerUser.put(user, userPlaylist);
    }

    //return the playlist with mention capacity, if user doesn't have written the emptylist
    public List<String> getRecentlyPlayedSongs(String user) {
    	List<String> list = emptyList();
        List<String> userPlaylist = playlistPerUser.getOrDefault(user, list);

        if (userPlaylist.size() <= capacity) {
            return userPlaylist;
        }
        return userPlaylist.subList(userPlaylist.size() - capacity, userPlaylist.size());
    }
    
    /**
     * Get the list of all songs for perticular user.
     * @param user
     * @return
     */
    public List<String> getlistof_available_songs(String user) {
    	
        List<String> songlist = playlistPerUser.getOrDefault(user, new ArrayList());
        return songlist;
    }
    
}
