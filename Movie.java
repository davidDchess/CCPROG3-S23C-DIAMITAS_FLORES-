public class Movie {
    // Attributes
    private int durationMinutes;
    private String director;
    private int releaseYear;

    // Constructor
    public Movie(int durationMinutes, String director, int releaseYear) {
        this.durationMinutes = durationMinutes;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    // Getters
    public int getDurationMinutes() {
        return durationMinutes;
    }

    public String getDirector() {
        return director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    // Returns a formatted string of the specific movie details.
    public String getDetails() {
        return "Director: " + director + " | Release Year: " + releaseYear +
                " | Duration: " + durationMinutes + " mins";
    }

    // Replaces the default toString method to print clean details.
    public String toString() {
        return getDetails();
    }
}
