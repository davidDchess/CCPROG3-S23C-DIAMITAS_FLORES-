public class Anime {
    // Attributes
    private int totalEpisodes;
    private int currentEpisode;
    private int seasonNumber;
    private String studio;

    // Constructor
    public Anime(int totalEpisodes, int currentEpisode, int seasonNumber, String studio) {
        this.totalEpisodes = totalEpisodes;
        this.currentEpisode = currentEpisode;
        this.seasonNumber = seasonNumber;
        this.studio = studio;
    }

    // Getters
    public int getTotalEpisodes() {
        return totalEpisodes;
    }

    public int getCurrentEpisode() {
        return currentEpisode;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public String getStudio() {
        return studio;
    }

    // Updates the current episode if it is a valid number.
    // Ensures the episode doesn't go below 0 or exceed the total episodes.
    public boolean updateCurrentEpisode(int currentEpisode) {
        if (currentEpisode >= 0 && currentEpisode <= this.totalEpisodes) {
            this.currentEpisode = currentEpisode;
            return true;
        }
        return false; // Invalid episode number
    }

    // Checks if the anime is completed.
    public boolean isFinished() {
        return this.currentEpisode == this.totalEpisodes;
    }

    // Returns a formatted string of the specific anime details.
    public String getDetails() {
        return "Season: " + seasonNumber + " | Studio: " + studio +
                " | Progress: Episode " + currentEpisode + " of " + totalEpisodes;
    }

    // Replaces the default toString method to print clean details.
    public String toString() {
        return getDetails();
    }
}