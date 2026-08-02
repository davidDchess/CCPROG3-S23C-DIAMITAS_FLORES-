/**
 * Represents a Movie production, tracking runtime duration, directing credits,
 * and when it was released.
 *
 * @author DIAMITAS_FLORES
 */
public class Movie extends MediaEntry {
    // Attributes
    private int durationMinutes;
    private String director;
    private int releaseYear;

    /**
     * Constructs a new Movie instance with the specified runtime, director, release
     * year, and media tracker details.
     *
     * @param entryId         The unique ID of the entry.
     * @param title           The title of the movie.
     * @param genre           The genre of the movie.
     * @param status          The current status of the movie.
     * @param durationMinutes The total runtime of the movie in minutes.
     * @param director        The name of the movie director.
     * @param releaseYear     The calendar year the movie was officially released.
     */
    public Movie(int entryId, String title, String genre, String status,
            int durationMinutes, String director, int releaseYear) {
        super(entryId, title, genre, status);
        this.durationMinutes = durationMinutes;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    /**
     * Retrieves the total runtime duration of the movie.
     *
     * @return The movie runtime in minutes.
     */
    public int getDurationMinutes() {
        return durationMinutes;
    }

    /**
     * Retrieves the director credited for the movie production.
     *
     * @return The director name string.
     */
    public String getDirector() {
        return director;
    }

    /**
     * Retrieves the year the movie premiered.
     *
     * @return The integer release year.
     */
    public int getReleaseYear() {
        return releaseYear;
    }

    /**
     * Returns a formatted string of the specific movie details.
     *
     * @return A formatted summary string outlining the production director, release
     *         timeline, and runtime metrics.
     */
    public String getDetails() {
        return "Director: " + director + " | Release Year: " + releaseYear +
                " | Duration: " + durationMinutes + " mins";
    }

    /**
     * Identifies the specific media type associated with this entry.
     *
     * @return The literal string {@code "Movie"}.
     */
    @Override
    public String getMediaType() {
        return "Movie";
    }

    /**
     * Provides specific details for this movie entry by delegating to
     * {@link #getDetails()}.
     *
     * @return The detailed text breakdown of this movie instance.
     */
    @Override
    public String getSpecificDetails() {
        return getDetails();
    }

    /**
     * Formats all movie property values into a pipe-delimited string structured for
     * file storage.
     *
     * @return A single formatted data row representing this movie entry.
     */
    @Override
    public String toFileString() {
        return "Movie|" + getEntryId() + "|" + getTitle() + "|" + getGenre() + "|" + getStatus() + "|" +
                durationMinutes + "|" + director + "|" + releaseYear + "|" + getRating() + "|" + getReview();
    }
}
