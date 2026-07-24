/**
 * Represents a Board Game entry in the media tracker.
 *
 * @author DIAMITAS_FLORES
 */
public class BoardGame extends MediaEntry
{
    private int minPlayers;
    private int maxPlayers;
    private int playTimeMinutes;
    private String difficultyLevel;

    /**
     * Creates a new BoardGame entry.
     *
     * @param entryId The unique ID of the entry.
     * @param title The title of the board game.
     * @param genre The genre or category of the board game.
     * @param status The current status of the board game.
     * @param minPlayers The minimum number of players.
     * @param maxPlayers The maximum number of players.
     * @param playTimeMinutes The estimated play time in minutes.
     * @param difficultyLevel The difficulty level of the board game.
     */
    public BoardGame(int entryId, String title, String genre, String status,
                     int minPlayers, int maxPlayers, int playTimeMinutes, String difficultyLevel)
    {
        super(entryId, title, genre, status);
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.playTimeMinutes = playTimeMinutes;
        this.difficultyLevel = difficultyLevel;
    }

    public int getMinPlayers()
    {
        return minPlayers;
    }

    public int getMaxPlayers()
    {
        return maxPlayers;
    }

    public int getPlayTimeMinutes()
    {
        return playTimeMinutes;
    }

    public String getDifficultyLevel()
    {
        return difficultyLevel;
    }

    public boolean isPlayableWith(int playerCount)
    {
        return playerCount >= this.minPlayers && playerCount <= this.maxPlayers;
    }

    public String getDetails()
    {
        return "Players: " + minPlayers + "-" + maxPlayers +
               " | Play Time: " + playTimeMinutes + " mins" +
               " | Difficulty: " + difficultyLevel;
    }

    @Override
    public String getMediaType()
    {
        return "Board Game";
    }

    @Override
    public String getSpecificDetails()
    {
        return getDetails();
    }

    @Override
    public String toFileString()
    {
        return "Board Game|" + getEntryId() + "|" + getTitle() + "|" + getGenre() + "|" + getStatus() + "|" +
               minPlayers + "|" + maxPlayers + "|" + playTimeMinutes + "|" + difficultyLevel + "|" +
               getRating() + "|" + getReview();
    }
}
