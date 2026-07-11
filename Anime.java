/**
 * Represents an Anime series, tracking its seasonal progress, total episodes, current watch status, and production studio.
 *
 * @author DIAMITAS_FLORES
 */
public class Anime 
{
    // Attributes
    private int totalEpisodes;
    private int currentEpisode;
    private int seasonNumber;
    private String studio;

    /**
     * Creates a new Anime item with your current watching progress and studio information.
     *
     * @param totalEpisodes  The total number of episodes available in this season.
     * @param currentEpisode The specific episode number you are currently on.
     * @param seasonNumber   The number of the season you are tracking.
     * @param studio         The animation studio that made the show.
     */
    public Anime(int totalEpisodes, int currentEpisode, int seasonNumber, String studio) 
    {
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
    public int getTotalEpisodes() 
    {
        return totalEpisodes;
    }

    /**
     * Gets the episode number you are currently watching.
     *
     * @return The current episode number.
     */
    public int getCurrentEpisode() 
    {
        return currentEpisode;
    }

   /**
     * Gets the season number of this anime.
     *
     * @return The season number.
     */
    public int getSeasonNumber() 
    {
        return seasonNumber;
    }

  /**
     * Gets the name of the studio that animated the series.
     *
     * @return The studio name text string.
     */
    public String getStudio() 
    {
        return studio;
    }

    /**
     * Updates the current episode tracking number if it falls within a valid boundary.
     * The input must be greater than or equal to 0, and cannot exceed the total episodes.
     *
     * @param currentEpisode The new current episode number.
     * @return {@code true} if the episode was successfully updated; {@code false} if the provided number was out of valid bounds.
     */
    public boolean updateCurrentEpisode(int currentEpisode) 
    {
        if (currentEpisode >= 0 && currentEpisode <= this.totalEpisodes) {
            this.currentEpisode = currentEpisode;
            return true;
        }
        return false; // Invalid episode number
    }

    /**
     * Checks if the viewer has completely finished watching this season of the anime.
     *
     * @return {@code true} if the current episode matches the total episode count; {@code false} otherwise.
     */
    public boolean isFinished() 
    {
        return this.currentEpisode == this.totalEpisodes;
    }

    /**
     * Generates a cleanly formatted metadata string detailing the season, production studio, and overall viewing progress.
     *
     * @return A formatted summary string of the anime's metrics.
     */
    public String getDetails() 
    {
        return "Season: " + seasonNumber + " | Studio: " + studio +
                " | Progress: Episode " + currentEpisode + " of " + totalEpisodes;
    }

    /**
     * Provides a string representation of the Anime object, falling back on the structured summary provided by the {@link #getDetails()} method.
     *
     * @return The detailed text breakdown of this anime instance.
     */
    public String toString() 
    {
        return getDetails();
    }
}
