package testSVH;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Enter the initial capacity for play-list.
        System.out.print("Enter the initial capacity for playlist : ");
        int initialCapacity = scanner.nextInt();

        playlist holdsong = new playlist(initialCapacity);

        boolean exit = false;
        
        //choose option
        while (!exit) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add song to playlist");
            System.out.println("2. Fetch recent playlist");
            System.out.println("3. Available songs for User");
            System.out.println("4. Exit");
            
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter user name: ");
                    String user = scanner.next();
                    System.out.print("Enter song name: ");
                    String songName = scanner.next();
                    holdsong.recentlyPlayedSong(user, songName);
                    break;
                case 2:
                    System.out.print("Enter user name: ");
                    user = scanner.next();
                    List<String> recentPlaylist = holdsong.getRecentlyPlayedSongs(user);
                    System.out.println("Recent playlist for " + user + ": " + recentPlaylist);
                    break;
                case 3:
                	System.out.print("Enter user name: ");
                    user = scanner.next();
                    List<String> songsList = holdsong.getlistof_available_songs(user);
                    System.out.println("Available songs for User " + user + ": " + songsList);
                    break; 
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
