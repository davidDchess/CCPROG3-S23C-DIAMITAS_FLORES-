import java.util.ArrayList;

/**
 * Manages a list of media entries. It handles basic tracking tasks like 
 * adding new items, removing items, searching by title, filtering by type, 
 * and calculating the average rating of the collection.
 *
 * @author DIAMITAS_FLORES
 */
public class MediaLibrary {
    // Attributes
    private ArrayList<MediaEntry> entries;
    private int nextEntryId;

    /**
     * Constructs a new, empty MediaLibrary with the starting ID counter set to 1.
     */
    public MediaLibrary() {
        entries = new ArrayList<MediaEntry>();
        nextEntryId = 1;
    }

    /**
     * Generates a unique tracking ID number by incrementing the counter by one.
     *
     * @return The next available integer ID.
     */
    public int generateEntryId() {
        int id = nextEntryId;
        nextEntryId++;
        return id;
    }

    /**
     * Adds a media entry to the library list.
     *
     * @param entry The {@link MediaEntry} object you want to add to the library.
     * @return {@code true} if the item is not null and was successfully added; {@code false} otherwise.
     */
    public boolean addEntry(MediaEntry entry) {
        if (entry == null) {
            return false; // Safety check to prevent tracking nonexistent entries
        }

        entries.add(entry);
        return true;
    }

    /**
     * Searches for a specific media entry using its unique ID number.
     *
     * @param entryId The ID number of the item you are looking for.
     * @return The matching {@link MediaEntry} object, or {@code null} if it cannot be found.
     */
    public MediaEntry getEntryById(int entryId) {
        for (int i = 0; i < entries.size(); i++) {
            MediaEntry entry = entries.get(i);

            if (entry.getEntryId() == entryId) {
                return entry;
            }
        }
        return null; // Returns null if no record matches the target ID
    }

    /**
     * Removes a media entry from the library list using its unique ID number.
     *
     * @param entryId The ID number of the item you want to delete.
     * @return {@code true} if the item was found and removed; {@code false} if the item does not exist.
     */
    public boolean removeEntry(int entryId) {
        MediaEntry entry = getEntryById(entryId);

        if (entry == null) {
            return false; // Cannot remove if item does not exist
        }

        entries.remove(entry);
        return true;
    }

    /**
     * Returns the full list of all media entries stored in the library.
     *
     * @return An ArrayList containing every media entry.
     */
    public ArrayList<MediaEntry> getAllEntries() {
        return entries;
    }

    /**
     * Filters the library to find entries that match a specific status, such as "Planned" or "Completed".
     *
     * @param status The status string to filter by.
     * @return A list of media entries that have the matching status.
     */
    public ArrayList<MediaEntry> filterByStatus(String status) {
        ArrayList<MediaEntry> filteredEntries = new ArrayList<MediaEntry>();

        for (int i = 0; i < entries.size(); i++) {
            MediaEntry entry = entries.get(i);

            if (entry.getStatus().equalsIgnoreCase(status)) {
                filteredEntries.add(entry);
            }
        }

        return filteredEntries;
    }

    /**
     * Filters the library to find entries that match a specific media type, such as "Movie" or "Board Game".
     *
     * @param mediaType The type of media to filter by.
     * @return A list of media entries that belong to the specified type.
     */
    public ArrayList<MediaEntry> filterByMediaType(String mediaType) {
        ArrayList<MediaEntry> filteredEntries = new ArrayList<MediaEntry>();

        for (int i = 0; i < entries.size(); i++) {
            MediaEntry entry = entries.get(i);

            if (entry.getMediaType().equalsIgnoreCase(mediaType)) {
                filteredEntries.add(entry);
            }
        }

        return filteredEntries;
    }

    /**
     * Searches for media entries whose titles contain the specified keyword (case-insensitive).
     *
     * @param keyword The text phrase to look for inside the titles.
     * @return A list of media entries that contain the search keyword.
     */
    public ArrayList<MediaEntry> searchByTitle(String keyword) {
        ArrayList<MediaEntry> results = new ArrayList<MediaEntry>();

        if (keyword == null) {
            return results; // Safety check to avoid potential null pointer issues
        }

        for (int i = 0; i < entries.size(); i++) {
            MediaEntry entry = entries.get(i);

            if (entry.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(entry);
            }
        }

        return results;
    }

    /**
     * Returns the total number of media entries currently saved in the library.
     *
     * @return The size of the entries list.
     */
    public int getTotalEntries() {
        return entries.size();
    }

    /**
     * Counts how many entries match a specific status tag.
     *
     * @param status The status string to count.
     * @return The total number of entries with that status.
     */
    public int countByStatus(String status) {
        int count = 0;

        for (int i = 0; i < entries.size(); i++) {
            MediaEntry entry = entries.get(i);

            if (entry.getStatus().equalsIgnoreCase(status)) {
                count++;
            }
        }

        return count;
    }

    /**
     * Counts how many entries match a specific media type.
     *
     * @param mediaType The type string to count.
     * @return The total number of entries belonging to that media type.
     */
    public int countByMediaType(String mediaType) {
        int count = 0;

        for (int i = 0; i < entries.size(); i++) {
            MediaEntry entry = entries.get(i);

            if (entry.getMediaType().equalsIgnoreCase(mediaType)) {
                count++;
            }
        }

        return count;
    }

    /**
     * Calculates the mathematical average of all rated items in the library. 
     * Unrated items are skipped and do not affect the average score.
     *
     * @return The average score as a double out of 10, or 0.0 if no entries have ratings.
     */
    public double getAverageRating() {
        int totalRating = 0;
        int ratedEntries = 0;

        for (int i = 0; i < entries.size(); i++) {
            MediaEntry entry = entries.get(i);

            if (entry.hasRating()) {
                totalRating += entry.getRating();
                ratedEntries++;
            }
        }

        if (ratedEntries == 0) {
            return 0.0; // Prevents a division by zero error if no entries are rated
        }

        return (double) totalRating / ratedEntries;
    }
}
