import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles saving and loading media entries from a text file.
 *
 * @author DIAMITAS_FLORES
 */
public class MediaFileManager
{
    /**
     * Saves all media entries from the library into a text file.
     *
     * @param library The media library to save.
     * @param fileName The name of the file where the data will be saved.
     * @return true if the file was saved successfully, false otherwise.
     */
    public boolean saveLibrary(MediaLibrary library, String fileName)
    {
        if (library == null || fileName == null)
        {
            return false;
        }

        try
        {
            PrintWriter writer = new PrintWriter(fileName);
            ArrayList<MediaEntry> entries = library.getAllEntries();

            for (int i = 0; i < entries.size(); i++)
            {
                writer.println(entries.get(i).toFileString());
            }

            writer.close();
            return true;
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error: File could not be saved.");
            return false;
        }
    }

    /**
     * Loads a media library from a file.
     *
     * @param fileName The name of the file to load from.
     * @return The loaded media library, or null if the file was not loaded.
     */
    public MediaLibrary loadLibrary(String fileName)
    {
        MediaLibrary library = new MediaLibrary();

        try
        {
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine())
            {
                String line = fileReader.nextLine();
                MediaEntry entry = createEntryFromLine(line);

                if (entry != null)
                {
                    library.addEntry(entry);
                }
            }

            fileReader.close();
            syncNextEntryId(library);

            return library;
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error: File not found.");
            return null;
        }
    }

    /**
     * Converts one line from the file into a MediaEntry object.
     *
     * @param line The line of text from the file.
     * @return The media entry created from the line, or null if the line is invalid.
     */
    private MediaEntry createEntryFromLine(String line)
    {
        try
        {
            String[] parts = line.split("\\|", -1);

            String mediaType = parts[0];
            int entryId = Integer.parseInt(parts[1]);
            String title = parts[2];
            String genre = parts[3];
            String status = parts[4];

            MediaEntry entry = null;

            if (mediaType.equals("Anime"))
            {
                int totalEpisodes = Integer.parseInt(parts[5]);
                int currentEpisode = Integer.parseInt(parts[6]);
                int seasonNumber = Integer.parseInt(parts[7]);
                String studio = parts[8];
                int rating = Integer.parseInt(parts[9]);
                String review = parts[10];

                entry = new Anime(entryId, title, genre, status,
                                  totalEpisodes, currentEpisode, seasonNumber, studio);

                if (rating != -1)
                {
                    entry.setRatingAndReview(rating, review);
                }
            }
            else if (mediaType.equals("Movie"))
            {
                int durationMinutes = Integer.parseInt(parts[5]);
                String director = parts[6];
                int releaseYear = Integer.parseInt(parts[7]);
                int rating = Integer.parseInt(parts[8]);
                String review = parts[9];

                entry = new Movie(entryId, title, genre, status,
                                  durationMinutes, director, releaseYear);

                if (rating != -1)
                {
                    entry.setRatingAndReview(rating, review);
                }
            }
            else if (mediaType.equals("Board Game"))
            {
                int minPlayers = Integer.parseInt(parts[5]);
                int maxPlayers = Integer.parseInt(parts[6]);
                int playTimeMinutes = Integer.parseInt(parts[7]);
                String difficultyLevel = parts[8];
                int rating = Integer.parseInt(parts[9]);
                String review = parts[10];

                entry = new BoardGame(entryId, title, genre, status,
                                      minPlayers, maxPlayers, playTimeMinutes, difficultyLevel);

                if (rating != -1)
                {
                    entry.setRatingAndReview(rating, review);
                }
            }

            return entry;
        }
        catch (NumberFormatException e)
        {
            System.out.println("Error: Invalid number found while loading a file.");
            return null;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Error: Invalid file format.");
            return null;
        }
    }

    
    /**
     * Updates the next entry ID after loading entries from a file.
     *
     * @param library The media library to update.
     */
    private void syncNextEntryId(MediaLibrary library)
    {
        int highestId = 0;
        ArrayList<MediaEntry> entries = library.getAllEntries();

        for (int i = 0; i < entries.size(); i++)
        {
            if (entries.get(i).getEntryId() > highestId)
            {
                highestId = entries.get(i).getEntryId();
            }
        }

        for (int i = 0; i < highestId; i++)
        {
            library.generateEntryId();
        }
    }
}
