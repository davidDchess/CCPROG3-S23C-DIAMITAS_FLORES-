/**
 * Acts as the main application runner and console interface for MediaVault. 
 * It displays the user menu, reads keyboard entries, and coordinates all tasks 
 * like adding, removing, updating, and searching items in the library collection.
 *
 * @author DIAMITAS_FLORES
 */
import java.util.Scanner;
import java.util.ArrayList;

public class MediaVaultApp {
  
    private Scanner scanner;
    private UserProfile user;

    /**
     * Creates a new MediaVaultApp application instance by setting up the text scanner 
     * and initializing a default user profile.
     */
    public MediaVaultApp() {
        scanner = new Scanner(System.in);
        user = new UserProfile("User");
    }

    /**
     * The main entry point of the program that starts up the application.
     *
     * @param args Standard command-line arguments array.
     */
    public static void main(String[] args) {
        MediaVaultApp app = new MediaVaultApp();
        app.showMainMenu();
    }

    /**
     * Displays the main menu choices in a continuous loop and routes the user's number 
     * selection to the correct management action.
     */
    private void showMainMenu() {
        int choice = -1;

        while (choice != 0) {
            printBlankLines();
            System.out.println("\n===== MediaVault =====");
            System.out.println("1. Add Anime");
            System.out.println("2. Add Movie");
            System.out.println("3. Add Board Game");
            System.out.println("4. Update Media Status");
            System.out.println("5. Add Rating and Review");
            System.out.println("6. Display All Entries");
            System.out.println("7. Filter by Status");
            System.out.println("8. Filter by Media Type");
            System.out.println("9. Display Library Summary");
            System.out.println("10. Remove Entry");
            System.out.println("11. Search by Title");
            System.out.println("0. Exit");
            System.out.println("--------------------");
            System.out.print("Enter choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } 
            else {
                System.out.println("INVALID INPUT. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            if (choice == 1) {
                addAnime();
            } else if (choice == 2) {
                addMovie();
            } else if (choice == 3) {
                addBoardGame();
            } else if (choice == 4) {
                updateEntryStatus();
            } else if (choice == 5) {
                addRatingAndReview();
            } else if (choice == 6) {
                displayAllEntries();
            } else if (choice == 7) {
                displayEntriesByStatus();
            } else if (choice == 8) {
                displayEntriesByMediaType();
            } else if (choice == 9) {
                displayLibrarySummary();
            } else if (choice == 10) {
                removeEntry();
            } else if (choice == 11) {
                searchEntryByTitle();
            } else if (choice == 0) {
                System.out.println("Thank you for using MediaVault.");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Prompts the user to enter text and number details for an anime series, 
     * packs it into an entry, and adds it to the collection.
     */
    private void addAnime() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();

        System.out.print("Enter status (Planned/In Progress): ");
        String status = scanner.nextLine();

        System.out.print("Enter total episodes: ");
        int totalEpisodes = scanner.nextInt();

        System.out.print("Enter current episode: ");
        int currentEpisode = scanner.nextInt();

        System.out.print("Enter season number: ");
        int seasonNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter studio: ");
        String studio = scanner.nextLine();

        Anime anime = new Anime(totalEpisodes, currentEpisode, seasonNumber, studio);

        int entryId = user.getLibrary().generateEntryId();
        MediaEntry entry = new MediaEntry(entryId, title, genre, status, anime);

        user.getLibrary().addEntry(entry);
        System.out.println("Anime entry added successfully.");
    }

    /**
     * Prompts the user to enter text and number details for a movie production, 
     * packs it into an entry, and adds it to the collection.
     */
    private void addMovie() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();

        System.out.print("Enter status (Planned/In Progress): ");
        String status = scanner.nextLine();

        System.out.print("Enter duration in minutes: ");
        int durationMinutes = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter director: ");
        String director = scanner.nextLine();

        System.out.print("Enter release year: ");
        int releaseYear = scanner.nextInt();
        scanner.nextLine();

        Movie movie = new Movie(durationMinutes, director, releaseYear);

        int entryId = user.getLibrary().generateEntryId();
        MediaEntry entry = new MediaEntry(entryId, title, genre, status, movie);

        user.getLibrary().addEntry(entry);
        System.out.println("Movie entry added successfully.");
    }

    /**
     * Prompts the user to enter details for a board game profile, packs it 
     * into a unified tracking entry, and registers it into the collection.
     */
    private void addBoardGame() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter genre/category: ");
        String genre = scanner.nextLine();

        System.out.print("Enter status (Planned/In Progress): ");
        String status = scanner.nextLine();

        System.out.print("Enter minimum players: ");
        int minPlayers = scanner.nextInt();

        System.out.print("Enter maximum players: ");
        int maxPlayers = scanner.nextInt();

        System.out.print("Enter play time in minutes: ");
        int playTimeMinutes = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter difficulty level: ");
        String difficultyLevel = scanner.nextLine();

        BoardGame boardGame = new BoardGame(minPlayers, maxPlayers, playTimeMinutes, difficultyLevel);

        int entryId = user.getLibrary().generateEntryId();
        MediaEntry entry = new MediaEntry(entryId, title, genre, status, boardGame);

        user.getLibrary().addEntry(entry);
        System.out.println("Board game entry added successfully.");
    }

    /**
     * Looks up an existing item by its unique ID number and changes its current tracking status. 
     * If an anime is marked as completed, it automatically sets its watch progress to the final episode.
     */
    private void updateEntryStatus() {
        System.out.print("Enter entry ID: ");
        int entryId = scanner.nextInt();
        scanner.nextLine();

        MediaEntry entry = user.getLibrary().getEntryById(entryId);

        if (entry == null) {
            System.out.println("Entry not found.");
        } else {
            System.out.print("Enter new status (Planned/In Progress/Completed): ");
            String newStatus = scanner.nextLine();

            if (entry.updateStatus(newStatus)) {
                if (newStatus.equalsIgnoreCase("Completed") && entry.getAnimeDetails() != null) {
                    Anime anime = entry.getAnimeDetails();
                    anime.updateCurrentEpisode(anime.getTotalEpisodes());
                }
                System.out.println("Status updated successfully.");
            } 
            else {
                System.out.println("Invalid status.");
            }
        }
    }

    /**
     * Finds a media entry using its ID code and saves a numerical score evaluation 
     * and text review comments, provided the item has already been finished.
     */
    private void addRatingAndReview() {
        System.out.print("Enter entry ID: ");
        int entryId = scanner.nextInt();

        System.out.print("Enter rating from 1 to 10: ");
        int rating = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter review: ");
        String review = scanner.nextLine();

        MediaEntry entry = user.getLibrary().getEntryById(entryId);

        if (entry == null) {
            System.out.println("Entry not found.");
        } else {
            if (entry.setRatingAndReview(rating, review)) {
                System.out.println("Rating and review added successfully.");
            } else {
                System.out.println("Rating and review can only be added to completed entries.");
            }
        }
    }

    /**
     * Grabs every single entry saved inside the tracker registry database and prints out 
     * their structured text details to the screen.
     */
    private void displayAllEntries() {
        ArrayList<MediaEntry> entries = user.getLibrary().getAllEntries();

        if (entries.size() == 0) {
            System.out.println("No entries in the library.");
        } else {
            for (int i = 0; i < entries.size(); i++) {
                System.out.println(entries.get(i));
            }
        }
    }

    /**
     * Asks the user for a filter status string and displays only the media entries 
     * that match that specific completion criteria.
     */
    private void displayEntriesByStatus() {
        System.out.print("Enter status to filter (Planned/In Progress/Completed): ");
        String status = scanner.nextLine();

        ArrayList<MediaEntry> entries = user.getLibrary().filterByStatus(status);

        if (entries.size() == 0) {
            System.out.println("No entries found with that status.");
        } else {
            for (int i = 0; i < entries.size(); i++) {
                System.out.println(entries.get(i));
            }
        }
    }

    /**
     * Asks the user for a media category string and prints out only the items that match 
     * that type classification (like Anime, Movie, or Board Game).
     */
    private void displayEntriesByMediaType() {
        System.out.print("Enter media type to filter (Anime/Movie/Board Game): ");
        String mediaType = scanner.nextLine();

        ArrayList<MediaEntry> entries = user.getLibrary().filterByMediaType(mediaType);

        if (entries.size() == 0) {
            System.out.println("No entries found with that media type.");
        } else {
            for (int i = 0; i < entries.size(); i++) {
                System.out.println(entries.get(i));
            }
        }
    }

    /**
     * Generates and prints a summary layout dashboard showing overall statistics, 
     * including category amounts, progress distributions, and the calculated library rating average.
     */
    private void displayLibrarySummary() {
        System.out.println("\n===== Library Summary =====");
        System.out.println("Total entries: " + user.getLibrary().getTotalEntries());
        System.out.println("Planned: " + user.getLibrary().countByStatus("Planned"));
        System.out.println("In Progress: " + user.getLibrary().countByStatus("In Progress"));
        System.out.println("Completed: " + user.getLibrary().countByStatus("Completed"));
        System.out.println("Anime: " + user.getLibrary().countByMediaType("Anime"));
        System.out.println("Movie: " + user.getLibrary().countByMediaType("Movie"));
        System.out.println("Board Game: " + user.getLibrary().countByMediaType("Board Game"));
        System.out.println("Average rating: " + user.getLibrary().getAverageRating());
    }

    /**
     * Prompts for an index number code and wipes that specific tracking profile 
     * completely out of the active data registry storage list.
     */
    private void removeEntry() {
        System.out.print("Enter entry ID to remove: ");
        int entryId = scanner.nextInt();
        scanner.nextLine();

        if (user.getLibrary().removeEntry(entryId)) {
            System.out.println("Entry removed successfully.");
        } else {
            System.out.println("Entry not found.");
        }
    }

    /**
     * Prompts the user for a word or phrase keyword and displays all media logs whose 
     * titles contain that text sequence (case-insensitive).
     */
    private void searchEntryByTitle() {
        System.out.print("Enter title keyword: ");
        String keyword = scanner.nextLine();

        ArrayList<MediaEntry> results = user.getLibrary().searchByTitle(keyword);

        if (results.size() == 0) {
            System.out.println("No entries found.");
        } else {
            System.out.println("Search results:");
            for (int i = 0; i < results.size(); i++) {
                System.out.println(results.get(i));
            }
        }
    }

    /**
     * Outputs several empty lines to clear out space on the console terminal window 
     * and make the menu cleaner to look at.
     */
    private void printBlankLines() {
        for (int i = 0; i < 6; i++) {
            System.out.println();
        }
    }
}
