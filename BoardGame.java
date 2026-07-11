/**
 * Represents a Board Game, tracking player counts, average playtime, and difficulty level.
 *
 * @author DIAMITAS_FLORES
 */
public class BoardGame 
{
    // Attributes
    private int minPlayers;
    private int maxPlayers;
    private int playTimeMinutes;
    private String difficultyLevel;

    /**
     * Constructs a new BoardGame instance with specified player constraints, duration, and difficulty.
     *
     * @param minPlayers The minimum number of players required.
     * @param maxPlayers The maximum number of players allowed.
     * @param playTimeMinutes The average duration of a single game session in minutes.
     * @param difficultyLevel The perceived complexity or difficulty level of the game.
     */
    public BoardGame(int minPlayers, int maxPlayers, int playTimeMinutes, String difficultyLevel) 
    {
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.playTimeMinutes = playTimeMinutes;
        this.difficultyLevel = difficultyLevel;
    }

    /**
     * Retrieves the minimum number of players required for the game.
     *
     * @return The minimum player count.
     */
    public int getMinPlayers() 
    {
        return minPlayers;
    }

    /**
     * Retrieves the maximum number of players supported by the game.
     *
     * @return The maximum player count.
     */
    public int getMaxPlayers() 
    {
        return maxPlayers;
    }

    /**
     * Retrieves the estimated play time for a full game session.
     *
     * @return The play time duration in minutes.
     */
    public int getPlayTimeMinutes() 
    {
        return playTimeMinutes;
    }

    /**
     * Retrieves the difficulty level classification of the board game.
     *
     * @return The difficulty description string.
     */
    public String getDifficultyLevel() 
    {
        return difficultyLevel;
    }

    /**
     * Checks if the game can be played with the given number of players.
     *
     * @param playerCount The number of players attempting to join the game.
     * @return {@code true} if the player count falls between the minimum and maximum boundaries; {@code false} otherwise.
     */
    public boolean isPlayableWith(int playerCount) 
    {
        return playerCount >= this.minPlayers && playerCount <= this.maxPlayers;
    }

    /**
     * Returns a formatted string of the specific board game details.
     *
     * @return A formatted summary string outlining player ranges, runtime, and difficulty metrics.
     */
    public String getDetails() 
    {
        return "Players: " + minPlayers + "-" + maxPlayers +
                " | Play Time: " + playTimeMinutes + " mins" +
                " | Difficulty: " + difficultyLevel;
    }

    /**
     * Replaces the default toString method to print clean details.
     *
     * @return The detailed textual summary provided by the {@link #getDetails()} method.
     */
    public String toString() 
    {
        return getDetails();
    }
}
