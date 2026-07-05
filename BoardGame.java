public class BoardGame {
    // Attributes
    private int minPlayers;
    private int maxPlayers;
    private int playTimeMinutes;
    private String difficultyLevel;

    // Constructor
    public BoardGame(int minPlayers, int maxPlayers, int playTimeMinutes, String difficultyLevel) {
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.playTimeMinutes = playTimeMinutes;
        this.difficultyLevel = difficultyLevel;
    }

    // Getters
    public int getMinPlayers() {
        return minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getPlayTimeMinutes() {
        return playTimeMinutes;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    // Checks if the game can be played with the given number of players.
    public boolean isPlayableWith(int playerCount) {
        return playerCount >= this.minPlayers && playerCount <= this.maxPlayers;
    }

    // Returns a formatted string of the specific board game details.
    public String getDetails() {
        return "Players: " + minPlayers + "-" + maxPlayers +
                " | Play Time: " + playTimeMinutes + " mins" +
                " | Difficulty: " + difficultyLevel;
    }

    // Replaces the default toString method to print clean details.
    public String toString() {
        return getDetails();
    }
}