/**
 * Represents a Movie production, tracking runtime duration, directing credits and theatrical release timelines.
 *
 * @author DIAMITAS_FLORES
 */
public class Movie extends MediaEntry
{
    // Attributes
    private int durationMinutes;
    private String director;
    private int releaseYear;

    /**
     * Constructs a new Movie instance with the specified runtime, director, and release year.
     *
     * @param durationMinutes The total runtime of the movie in minutes.
     * @param director        The name of the movie director.
     * @param releaseYear     The calendar year the movie was officially released.
     */
    public Movie(int entryId, String title, String genre, String status, int durationMinutes, String director, int releaseYear) 
    {
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
    public int getDurationMinutes() 
    {
        return durationMinutes;
    }

    /**
     * Retrieves the director credited for the movie production.
     *
     * @return The director name string.
     */
    public String getDirector() 
    {
        return director;
    }

    /**
     * Retrieves the historical calendar year the movie premiered.
     *
     * @return The integer release year.
     */
    public int getReleaseYear() 
    {
        return releaseYear;
    }

    /**
     * Returns a formatted string of the specific movie details.
     *
     * @return A formatted summary string outlining the production director, release timeline, and runtime metrics.
     */
    public String getDetails() 
    {
        return "Director: " + director + " | Release Year: " + releaseYear +
                " | Duration: " + durationMinutes + " mins";
    }

    @Override
    public String getMediaType()
    {
        return "Movie";
    }

    @Override
    public String getSpecificDetails()
    {
        return getDetails();
    }

    @Override
    public String toFileString()
    {
        return "Movie|" + getEntryId() + "|" + getTitle() + "|" + getGenre() + "|" + getStatus() + "|" +
               durationMinutes + "|" + director + "|" + releaseYear + "|" + getRating() + "|" + getReview();
    }
}
