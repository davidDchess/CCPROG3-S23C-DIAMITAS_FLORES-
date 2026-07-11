/**
 * Keeps track of specific details for a board game, including player counts, 
 * estimated play time, and its difficulty level.
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
     * Creates a new BoardGame entry with player boundaries and gameplay settings.
     *
     * @param minPlayers      The minimum number of players required.
     * @param maxPlayers      The maximum number of players allowed.
     * @param playTimeMinutes The average time a single game session takes in minutes.
     * @param difficultyLevel The perceived complexity or difficulty of the game.
     */
    public BoardGame(int minPlayers, int maxPlayers, int playTimeMinutes, String difficultyLevel) 
    {
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.playTimeMinutes = playTimeMinutes;
        this.difficultyLevel = difficultyLevel;
    }

    /**
     * Gets the minimum number of players needed to play.
     *
     * @return The minimum player count.
     */
    public int getMinPlayers() 
    {
        return minPlayers;
    }

   /**
     * Gets the maximum number of players that can join.
     *
     * @return The maximum player count.
     */
    public int getMaxPlayers() 
    {
        return maxPlayers;
    }

    /**
     * Gets the average playtime duration in minutes.
     *
     * @return The game duration in minutes.
     */
    public int getPlayTimeMinutes() 
    {
        return playTimeMinutes;
    }

    /**
     * Gets the difficulty or complexity level rating of the board game.
     *
     * @return The difficulty level description string.
     */
    public String getDifficultyLevel() 
    {
        return difficultyLevel;
    }

   /**
     * Checks if the board game can be played with a specific number of people.
     *
     * @param playerCount The number of players wanting to play.
     * @return {@code true} if the count falls within the min and max limits; {@code false} otherwise.
     */
    public boolean isPlayableWith(int playerCount) 
    {
        return playerCount >= this.minPlayers && playerCount <= this.maxPlayers;
    }

    /**
     * Creates a text summary detailing player counts, playtime, and difficulty.
     *
     * @return A formatted text string containing the board game metrics.
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
