/**
 * Represents a Board Game entry in the media tracker, tracking player count
 * constraints, expected playtime, and overall difficulty level.
 *
 * @author DIAMITAS_FLORES
 */
public class BoardGame extends MediaEntry {
    // Attributes
    private int minPlayers;
    private int maxPlayers;
    private int playTimeMinutes;
    private String difficultyLevel;

    /**
     * Creates a new BoardGame entry with player capacity ranges, session length,
     * and difficulty properties.
     *
     * @param entryId         The unique ID of the entry.
     * @param title           The title of the board game.
     * @param genre           The genre or category of the board game.
     * @param status          The current status of the board game.
     * @param minPlayers      The minimum number of players required to play.
     * @param maxPlayers      The maximum number of players supported.
     * @param playTimeMinutes The estimated play time per session in minutes.
     * @param difficultyLevel The learning and strategic difficulty rating of the
     *                        game.
     */
    public BoardGame(int entryId, String title, String genre, String status,
            int minPlayers, int maxPlayers, int playTimeMinutes, String difficultyLevel) {
        super(entryId, title, genre, status);
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.playTimeMinutes = playTimeMinutes;
        this.difficultyLevel = difficultyLevel;
    }

    /**
     * Gets the minimum number of players required for a session.
     *
     * @return The minimum player count.
     */
    public int getMinPlayers() {
        return minPlayers;
    }

    /**
     * Gets the maximum number of players supported in a single game session.
     *
     * @return The maximum player count.
     */
    public int getMaxPlayers() {
        return maxPlayers;
    }

    /**
     * Gets the estimated playtime for a single game session in minutes.
     *
     * @return The playtime duration in minutes.
     */
    public int getPlayTimeMinutes() {
        return playTimeMinutes;
    }

    /**
     * Gets the overall difficulty level rating of the board game.
     *
     * @return The difficulty level text string.
     */
    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    /**
     * Determines whether a given group size fits within the supported player
     * limits.
     * The input must be greater than or equal to minimum players, and cannot exceed
     * maximum players.
     *
     * @param playerCount The target number of participants for a game session.
     * @return {@code true} if the player count is supported; {@code false} if the
     *         group size falls outside valid boundaries.
     */
    public boolean isPlayableWith(int playerCount) {
        if (playerCount >= this.minPlayers && playerCount <= this.maxPlayers) {
            return true;
        }
        return false; // Group size outside supported boundaries
    }

    /**
     * Generates a cleanly formatted details string detailing supported player
     * ranges, estimated runtime, and game complexity.
     *
     * @return A formatted summary string of the board game's metrics.
     */
    public String getDetails() {
        return "Players: " + minPlayers + "-" + maxPlayers +
                " | Play Time: " + playTimeMinutes + " mins" +
                " | Difficulty: " + difficultyLevel;
    }

    /**
     * Identifies the specific media type associated with this entry.
     *
     * @return The literal string {@code "Board Game"}.
     */
    @Override
    public String getMediaType() {
        return "Board Game";
    }

    /**
     * Provides specific details for this board game entry by delegating to
     * {@link #getDetails()}.
     *
     * @return The detailed text breakdown of this board game instance.
     */
    @Override
    public String getSpecificDetails() {
        return getDetails();
    }

    /**
     * Formats all board game property values into a pipe-delimited string
     * structured for file storage.
     *
     * @return A single formatted data row representing this board game entry.
     */
    @Override
    public String toFileString() {
        return "Board Game|" + getEntryId() + "|" + getTitle() + "|" + getGenre() + "|" + getStatus() + "|" +
                minPlayers + "|" + maxPlayers + "|" + playTimeMinutes + "|" + difficultyLevel + "|" +
                getRating() + "|" + getReview();
    }
}
