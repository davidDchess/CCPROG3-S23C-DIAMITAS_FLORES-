import java.util.Scanner;
import java.util.ArrayList;

public class MediaVaultApp {
  
    private Scanner scanner;
    private UserProfile user;

    public MediaVaultApp() {
      scanner = new Scanner(System.in);
      user = new UserProfile("User");
    }

    public static void main(String[] args) {
      MediaVaultApp app = new MediaVaultApp();
      app.showMainMenu();
    }

    private void showMainMenu() {
      int choice = -1;

      while (choice != 0) {
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
        System.out.print("Enter choice: ");

        choice = scanner.nextInt();
        scanner.nextLine();

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

    private void addAnime() {
      System.out.println("Add anime feature is not yet available.");
    }

    private void addMovie() {
      System.out.println("Add movie feature is not yet available.");
    }

    private void addBoardGame() {
      System.out.println("Add board game feature is not yet available.");
    }

    private void updateEntryStatus() {
      System.out.println("Update status feature is not yet available.");
    }

    private void addRatingAndReview() {
      System.out.println("Add rating and review feature is not yet available.");
    }

    private void displayAllEntries() {
      System.out.println("Display all entries feature is not yet available.");
    }

    private void displayEntriesByStatus() {
      System.out.println("Filter by status feature is not yet available.");
    }

    private void displayEntriesByMediaType() {
      System.out.println("Filter by media type feature is not yet available.");
    }

    private void displayLibrarySummary() {
      System.out.println("Library summary feature is not yet available.");
    }

    private void removeEntry() {
      System.out.println("Remove entry feature is not yet available.");
    }

    private void searchEntryByTitle() {
      System.out.println("Search by title feature is not yet available.");
    }
}
