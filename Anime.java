/**
 * Represents an Anime entry in the media tracker, tracking its seasonal
 * progress, total episodes, current watch status, and production studio.
 *
 * @author DIAMITAS_FLORES
 */
public class Anime extends MediaEntry {
    // Attributes
    private int totalEpisodes;
    private int currentEpisode;
    private int seasonNumber;
    private String studio;

    /**
     * Creates a new Anime entry with your current watching progress, studio
     * information, and media tracker details.
     *
     * @param entryId        The unique ID of the entry.
     * @param title          The title of the anime.
     * @param genre          The genre of the anime.
     * @param status         The current status of the anime.
     * @param totalEpisodes  The total number of episodes available in this season.
     * @param currentEpisode The specific episode number you are currently on.
     * @param seasonNumber   The number of the season you are tracking.
     * @param studio         The animation studio that made the show.
     */
    public Anime(int entryId, String title, String genre, String status,
            int totalEpisodes, int currentEpisode, int seasonNumber, String studio) {
        super(entryId, title, genre, status);
        this.totalEpisodes = totalEpisodes;
        this.currentEpisode = currentEpisode;
        this.seasonNumber = seasonNumber;
        this.studio = studio;
    }

    /**
     * Gets the total number of episodes in this season.
     *
     * @return The total episode count.
     */
    public int getTotalEpisodes() {
        return totalEpisodes;
    }

    /**
     * Gets the episode number you are currently watching.
     *
     * @return The current episode number.
     */
    public int getCurrentEpisode() {
        return currentEpisode;
    }

    /**
     * Gets the season number of this anime.
     *
     * @return The season number.
     */
    public int getSeasonNumber() {
        return seasonNumber;
    }

    /**
     * Gets the name of the studio that animated the series.
     *
     * @return The studio name text string.
     */
    public String getStudio() {
        return studio;
    }

    /**
     * Updates the current episode tracking number if it falls within a valid
     * boundary.
     * The input must be greater than or equal to 0, and cannot exceed the total
     * episodes.
     *
     * @param currentEpisode The new current episode number.
     * @return {@code true} if the episode was successfully updated; {@code false}
     *         if the provided number was out of valid bounds.
     */
    public boolean updateCurrentEpisode(int currentEpisode) {
        if (currentEpisode >= 0 && currentEpisode <= this.totalEpisodes) {
            this.currentEpisode = currentEpisode;
            return true;
        }
        return false; // Invalid episode number
    }

    /**
     * Checks if the viewer has completely finished watching this season of the
     * anime.
     *
     * @return {@code true} if the current episode matches the total episode count;
     *         {@code false} otherwise.
     */
    public boolean isFinished() {
        return this.currentEpisode == this.totalEpisodes;
    }

    /**
     * Generates a cleanly formatted metadata string detailing the season,
     * production studio, and overall viewing progress.
     *
     * @return A formatted summary string of the anime's metrics.
     */
    public String getDetails() {
        return "Season: " + seasonNumber + " | Studio: " + studio +
                " | Progress: Episode " + currentEpisode + " of " + totalEpisodes;
    }

    /**
     * Identifies the specific media type associated with this entry.
     *
     * @return The literal string {@code "Anime"}.
     */
    @Override
    public String getMediaType() {
        return "Anime";
    }

    /**
     * Provides specific details for this anime entry by going to
     * {@link #getDetails()}.
     *
     * @return The detailed text breakdown of this anime instance.
     */
    @Override
    public String getSpecificDetails() {
        return getDetails();
    }

    /**
     * Organizes the anime's information into a standardized format ready for file
     * storage.
     *
     * @return A single formatted data row representing this anime entry.
     */
    @Override
    public String toFileString() {
        return "Anime|" + getEntryId() + "|" + getTitle() + "|" + getGenre() + "|" + getStatus() + "|" +
                totalEpisodes + "|" + currentEpisode + "|" + seasonNumber + "|" + studio + "|" +
                getRating() + "|" + getReview();
    }
}
