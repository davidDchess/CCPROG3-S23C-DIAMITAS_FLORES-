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
     * Constructs a new Anime instance with the specified progression details and studio.
     *
     * @param totalEpisodes  The total number of episodes in this season.
     * @param currentEpisode The episode number the viewer is currently on.
     * @param seasonNumber   The number of the specific season.
     * @param studio         The animation studio producing the series.
     */
    public Anime(int totalEpisodes, int currentEpisode, int seasonNumber, String studio) 
    {
        this.totalEpisodes = totalEpisodes;
        this.currentEpisode = currentEpisode;
        this.seasonNumber = seasonNumber;
        this.studio = studio;
    }

    /**
     * Retrieves the total episodes available in this season.
     *
     * @return The total episode count.
     */
    public int getTotalEpisodes() 
    {
        return totalEpisodes;
    }

    /**
     * Retrieves the episode number currently being watched.
     *
     * @return The current episode number.
     */
    public int getCurrentEpisode() 
    {
        return currentEpisode;
    }

    /**
     * Retrieves the season number of this anime series.
     *
     * @return The season number.
     */
    public int getSeasonNumber() 
    {
        return seasonNumber;
    }

    /**
     * Retrieves the name of the studio that produced the anime.
     *
     * @return The studio name.
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
