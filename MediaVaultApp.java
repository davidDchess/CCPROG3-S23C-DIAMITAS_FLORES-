import java.util.Scanner;
import java.util.ArrayList;

/**
 * The main application entry point for the MediaVault tracker system.
 * This class runs the console menu and coordinates the media library.
 *
 * @author DIAMITAS_FLORES
 */
public class MediaVaultApp
{
    private Scanner scanner;
    private UserProfile user;
    private MediaFileManager fileManager;

    /**
     * Creates a new MediaVaultApp application instance.
     */
    public MediaVaultApp()
    {
        scanner = new Scanner(System.in);
        user = new UserProfile("User");
        fileManager = new MediaFileManager();
    }

    /**
     * Starts the program.
     *
     * @param args Standard command-line arguments.
     */
    public static void main(String[] args)
    {
        MediaVaultApp app = new MediaVaultApp();
        app.showMainMenu();
    }

    /**
     * Displays the main menu and handles user choices.
     */
    private void showMainMenu()
    {
        int choice = -1;

        while (choice != 0)
        {
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
            System.out.println("12. Save Library");
            System.out.println("13. Load Library");
            System.out.println("0. Exit");
            System.out.println("--------------------");
            System.out.print("Enter choice: ");

            if (scanner.hasNextInt())
            {
                choice = scanner.nextInt();
                scanner.nextLine();
            }
            else
            {
                System.out.println("INVALID INPUT. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            if (choice == 1)
            {
                addAnime();
            }
            else if (choice == 2)
            {
                addMovie();
            }
            else if (choice == 3)
            {
                addBoardGame();
            }
            else if (choice == 4)
            {
                updateEntryStatus();
            }
            else if (choice == 5)
            {
                addRatingAndReview();
            }
            else if (choice == 6)
            {
                displayAllEntries();
            }
            else if (choice == 7)
            {
                displayEntriesByStatus();
            }
            else if (choice == 8)
            {
                displayEntriesByMediaType();
            }
            else if (choice == 9)
            {
                displayLibrarySummary();
            }
            else if (choice == 10)
            {
                removeEntry();
            }
            else if (choice == 11)
            {
                searchEntryByTitle();
            }
            else if (choice == 12)
            {
               saveLibraryToFile();
            }
            else if (choice == 13)
            {
               loadLibraryFromFile();
            }
            else if (choice == 0)
            {
                System.out.println("Thank you for using MediaVault.");
            }
            else
            {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Adds an anime entry to the library.
     */
    private void addAnime()
    {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();

        System.out.print("Enter status (Planned/In Progress/Completed): ");
        String status = scanner.nextLine();

        if (!isValidStatus(status))
        {
            System.out.println("Invalid status. Entry was not added.");
            return;
        }

        System.out.print("Enter total episodes: ");
        int totalEpisodes = scanner.nextInt();

        System.out.print("Enter current episode: ");
        int currentEpisode = scanner.nextInt();

        System.out.print("Enter season number: ");
        int seasonNumber = scanner.nextInt();
        scanner.nextLine();

        if (!isValidAnimeEpisodes(totalEpisodes, currentEpisode))
        {
            System.out.println("Invalid episode count. Entry was not added.");
            return;
        }

        if (!isPositiveNumber(seasonNumber))
        {
            System.out.println("Invalid season number. Entry was not added.");
            return;
        }

        System.out.print("Enter studio: ");
        String studio = scanner.nextLine();

        int entryId = user.getLibrary().generateEntryId();

        MediaEntry entry = new Anime(entryId, title, genre, status, totalEpisodes, currentEpisode, seasonNumber, studio);

        user.getLibrary().addEntry(entry);
        System.out.println("Anime entry added successfully.");
    }

    /**
    * Adds a movie entry to the library.
    */
    private void addMovie()
    {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();

        System.out.print("Enter status (Planned/In Progress/Completed): ");
        String status = scanner.nextLine();

        if (!isValidStatus(status))
        {
            System.out.println("Invalid status. Entry was not added.");
            return;
        }

        System.out.print("Enter duration in minutes: ");
        int durationMinutes = scanner.nextInt();
        scanner.nextLine();

        if (!isPositiveNumber(durationMinutes))
        {
            System.out.println("Invalid duration. Entry was not added.");
            return;
        }

        System.out.print("Enter director: ");
        String director = scanner.nextLine();

        System.out.print("Enter release year: ");
        int releaseYear = scanner.nextInt();
        scanner.nextLine();

        if (!isPositiveNumber(releaseYear))
        {
            System.out.println("Invalid release year. Entry was not added.");
            return;
        }

        int entryId = user.getLibrary().generateEntryId();

        MediaEntry entry = new Movie(entryId, title, genre, status, durationMinutes, director, releaseYear);

        user.getLibrary().addEntry(entry);
        System.out.println("Movie entry added successfully.");
    }

    /**
     * Adds a board game entry to the library.
     */
    private void addBoardGame()
    {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter genre/category: ");
        String genre = scanner.nextLine();

        System.out.print("Enter status (Planned/In Progress/Completed): ");
        String status = scanner.nextLine();

        if (!isValidStatus(status))
        {
            System.out.println("Invalid status. Entry was not added.");
            return;
        }

        System.out.print("Enter minimum players: ");
        int minPlayers = scanner.nextInt();

        System.out.print("Enter maximum players: ");
        int maxPlayers = scanner.nextInt();

        System.out.print("Enter play time in minutes: ");
        int playTimeMinutes = scanner.nextInt();
        scanner.nextLine();

        if (!isValidBoardGamePlayers(minPlayers, maxPlayers))
        {
            System.out.println("Invalid player count. Entry was not added.");
            return;
        }

        if (!isPositiveNumber(playTimeMinutes))
        {
            System.out.println("Invalid play time. Entry was not added.");
            return;
        }

        System.out.print("Enter difficulty level: ");
        String difficultyLevel = scanner.nextLine();

        int entryId = user.getLibrary().generateEntryId();

        MediaEntry entry = new BoardGame(entryId, title, genre, status, minPlayers, maxPlayers, playTimeMinutes, difficultyLevel);

        user.getLibrary().addEntry(entry);
        System.out.println("Board game entry added successfully.");
    }

    /**
     * Updates the status of an entry.
     */
    private void updateEntryStatus()
    {
        if (!hasEntries())
        {
            return;
        }


        System.out.print("Enter entry ID: ");
        int entryId = scanner.nextInt();
        scanner.nextLine();

        MediaEntry entry = user.getLibrary().getEntryById(entryId);

        if (entry == null)
        {
            System.out.println("Entry not found.");
        }
        else
        {
            System.out.print("Enter new status (Planned/In Progress/Completed): ");
            String newStatus = scanner.nextLine();

            if (entry.updateStatus(newStatus))
            {
                if (newStatus.equalsIgnoreCase("Completed") && entry instanceof Anime)
                {
                    Anime anime = (Anime) entry;
                    anime.updateCurrentEpisode(anime.getTotalEpisodes());
                }

                System.out.println("Status updated successfully.");
            }
            else
            {
                System.out.println("Invalid status.");
            }
        }
    }

    /**
     * Adds a rating and review to a completed entry.
     */
    private void addRatingAndReview()
    {
        if (!hasEntries())
        {
            return;
        }


        System.out.print("Enter entry ID: ");
        int entryId = scanner.nextInt();

        System.out.print("Enter rating from 1 to 10: ");
        int rating = scanner.nextInt();
        scanner.nextLine();

        if (rating < 1 || rating > 10)
        {
            System.out.println("Rating must be from 1 to 10.");
            return;
        }

        System.out.print("Enter review: ");
        String review = scanner.nextLine();

        MediaEntry entry = user.getLibrary().getEntryById(entryId);

        if (entry == null)
        {
            System.out.println("Entry not found.");
        }
        else
        {
            if (entry.setRatingAndReview(rating, review))
            {
                System.out.println("Rating and review added successfully.");
            }
            else
            {
                System.out.println("Rating and review can only be added to completed entries.");
            }
        }
    }

    /**
     * Displays all entries in the library.
     */
    private void displayAllEntries()
    {
        ArrayList<MediaEntry> entries = user.getLibrary().getAllEntries();

        if (entries.size() == 0)
        {
            System.out.println("No entries in the library.");
        }
        else
        {
            for (int i = 0; i < entries.size(); i++)
            {
                System.out.println(entries.get(i));
            }
        }
    }

    /**
     * Displays entries that match a given status.
     */
    private void displayEntriesByStatus()
    {
        if (!hasEntries())
        {
            return;
        }

        
        System.out.print("Enter status to filter (Planned/In Progress/Completed): ");
        String status = scanner.nextLine();

        ArrayList<MediaEntry> entries = user.getLibrary().filterByStatus(status);

        if (entries.size() == 0)
        {
            System.out.println("No entries found with that status.");
        }
        else
        {
            for (int i = 0; i < entries.size(); i++)
            {
                System.out.println(entries.get(i));
            }
        }
    }

    /**
     * Displays entries that match a given media type.
     */
    private void displayEntriesByMediaType()
    {
        if (!hasEntries())
        {
            return;
        }

        
        System.out.print("Enter media type to filter (Anime/Movie/Board Game): ");
        String mediaType = scanner.nextLine();

        ArrayList<MediaEntry> entries = user.getLibrary().filterByMediaType(mediaType);

        if (entries.size() == 0)
        {
            System.out.println("No entries found with that media type.");
        }
        else
        {
            for (int i = 0; i < entries.size(); i++)
            {
                System.out.println(entries.get(i));
            }
        }
    }

    /**
     * Displays a summary of the library.
     */
    private void displayLibrarySummary()
    {
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
     * Removes an entry from the library.
     */
    private void removeEntry()
    {
        if (!hasEntries())
        {
            return;
        }


        System.out.print("Enter entry ID to remove: ");
        int entryId = scanner.nextInt();
        scanner.nextLine();

        if (user.getLibrary().removeEntry(entryId))
        {
            System.out.println("Entry removed successfully.");
        }
        else
        {
            System.out.println("Entry not found.");
        }
    }

    /**
     * Searches for entries by title.
     */
    private void searchEntryByTitle()
    {
        if (!hasEntries())
        {
            return;
        }


        System.out.print("Enter title keyword: ");
        String keyword = scanner.nextLine();

        ArrayList<MediaEntry> results = user.getLibrary().searchByTitle(keyword);

        if (results.size() == 0)
        {
            System.out.println("No entries found.");
        }
        else
        {
            System.out.println("Search results:");
            for (int i = 0; i < results.size(); i++)
            {
                System.out.println(results.get(i));
            }
        }
    }


    /**
     * Saves the current media library to a file.
     */
    private void saveLibraryToFile()
    {
        System.out.print("Enter file name to save: ");
        String fileName = scanner.nextLine();

        if (fileName.trim().equals(""))
        {
            System.out.println("Invalid file name.");
            return;
        }

        boolean savedFile = fileManager.saveLibrary(user.getLibrary(), fileName);

        if (savedFile)
        {
            System.out.println("Library saved successfully.");
        }
        else
        {
            System.out.println("Library was not saved.");
        }
    }


    /**
     * Loads a media library from a file.
     */
    private void loadLibraryFromFile()
    {
        System.out.print("Enter file name to load: ");
        String fileName = scanner.nextLine();

        if (fileName.trim().equals(""))
        {
            System.out.println("Invalid file name.");
            return;
        }

        MediaLibrary loadedLibrary = fileManager.loadLibrary(fileName);

        if (loadedLibrary != null)
        {
            user.setLibrary(loadedLibrary);
            System.out.println("Library loaded successfully.");
        }
        else
        {
            System.out.println("Library was not loaded.");
        }
    }


    /**
    * Checks if a status is valid.
    *
    * @param status The status to check.
    * @return true if the status is valid, false otherwise.
    */
    private boolean isValidStatus(String status)
    {
        return status.equalsIgnoreCase("Planned") || status.equalsIgnoreCase("In Progress") || status.equalsIgnoreCase("Completed");
    }

    /**
     * Checks if a number is greater than zero.
     *
     * @param number The number to check.
     * @return true if the number is greater than zero, false otherwise.
     */
    private boolean isPositiveNumber(int number)
    {
        return number > 0;
    }

    /**
     * Checks if the anime episode values are valid.
     *
     * @param totalEpisodes The total number of episodes.
     * @param currentEpisode The current episode progress.
     * @return true if the episode values are valid, false otherwise.
     */
    private boolean isValidAnimeEpisodes(int totalEpisodes, int currentEpisode)
    {
        return totalEpisodes > 0 && currentEpisode >= 0 && currentEpisode <= totalEpisodes;
    }

    /**
     * Checks if the board game player values are valid.
     *
     * @param minPlayers The minimum number of players.
     * @param maxPlayers The maximum number of players.
     * @return true if the player values are valid, false otherwise.
     */
    private boolean isValidBoardGamePlayers(int minPlayers, int maxPlayers)
    {
        return minPlayers > 0 && maxPlayers > 0 && minPlayers <= maxPlayers;
    }

    /**
     * Checks if the library has at least one entry.
     *
     * @return true if the library has entries, false otherwise.
     */
    private boolean hasEntries()
    {
        if (user.getLibrary().getTotalEntries() == 0)
        {
            System.out.println("No entries in the library.");
            return false;
        }

        return true;
    }

    /**
     * Prints blank lines to make the menu easier to read.
     */
    private void printBlankLines()
    {
        for (int i = 0; i < 6; i++)
        {
            System.out.println();
        }
    }
}
