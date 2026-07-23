/**
 * Represents an Anime entry in the media tracker.
 *
 * @author DIAMITAS_FLORES
 */
public class Anime extends MediaEntry
{
    private int totalEpisodes;
    private int currentEpisode;
    private int seasonNumber;
    private String studio;

    /**
     * Creates a new Anime entry.
     *
     * @param entryId The unique ID of the entry.
     * @param title The title of the anime.
     * @param genre The genre of the anime.
     * @param status The current status of the anime.
     * @param totalEpisodes The total number of episodes.
     * @param currentEpisode The current episode progress.
     * @param seasonNumber The season number.
     * @param studio The animation studio.
     */
    public Anime(int entryId, String title, String genre, String status,
                 int totalEpisodes, int currentEpisode, int seasonNumber, String studio)
    {
        super(entryId, title, genre, status);
        this.totalEpisodes = totalEpisodes;
        this.currentEpisode = currentEpisode;
        this.seasonNumber = seasonNumber;
        this.studio = studio;
    }

    public int getTotalEpisodes()
    {
        return totalEpisodes;
    }

    public int getCurrentEpisode()
    {
        return currentEpisode;
    }

    public int getSeasonNumber()
    {
        return seasonNumber;
    }

    public String getStudio()
    {
        return studio;
    }

    public boolean updateCurrentEpisode(int currentEpisode)
    {
        if (currentEpisode >= 0 && currentEpisode <= this.totalEpisodes)
        {
            this.currentEpisode = currentEpisode;
            return true;
        }

        return false;
    }

    public boolean isFinished()
    {
        return this.currentEpisode == this.totalEpisodes;
    }

    public String getDetails()
    {
        return "Season: " + seasonNumber +
               " | Studio: " + studio +
               " | Progress: Episode " + currentEpisode + " of " + totalEpisodes;
    }

    @Override
    public String getMediaType()
    {
        return "Anime";
    }

    @Override
    public String getSpecificDetails()
    {
        return getDetails();
    }

    @Override
    public String toFileString()
    {
        return "Anime|" + getEntryId() + "|" + getTitle() + "|" + getGenre() + "|" + getStatus() + "|" +
               totalEpisodes + "|" + currentEpisode + "|" + seasonNumber + "|" + studio + "|" +
               getRating() + "|" + getReview();
    }
}
