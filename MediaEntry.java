/**
 * Represents a single item in your tracker, storing shared info like title and status.
 * It also holds onto the unique, extra details required for Animes, Movies, or Board Games.
 *
 * @author DIAMITAS_FLORES
 */
public class MediaEntry 
{
    // Attributes
    private int entryId;
    private String title;
    private String genre;
    private String status;
    private int rating;
    private String review;
    private String mediaType;
    
    // Composition attributes for specific media types
    private Anime animeDetails;
    private Movie movieDetails;
    private BoardGame boardGameDetails;

    /**
     * Constructs a new MediaEntry specifically tracking an {@link Anime} series.
     *
     * @param entryId      The unique tracking identifier for this entry.
     * @param title        The title of the anime series.
     * @param genre        The main thematic genre of the content.
     * @param status       The user's consumption state (e.g., "Planned", "In Progress", "Completed").
     * @param animeDetails The specific details object containing anime-only information.
     */
    public MediaEntry(int entryId, String title, String genre, String status, Anime animeDetails) 
    {
        this.entryId = entryId;
        this.title = title;
        this.genre = genre;
        this.status = status;
        this.mediaType = "Anime";
        this.animeDetails = animeDetails;
        this.rating = -1; // -1 indicates unrated initially
        this.review = ""; // makes sure that review is empty, not null
    }

    /**
     * Constructs a new MediaEntry specifically tracking a {@link Movie}.
     *
     * @param entryId The unique tracking identifier for this entry.
     * @param title The title of the movie production.
     * @param genre The main genre of the content.
     * @param status The user's consumption state (e.g., "Planned", "In Progress", "Completed").
     * @param movieDetails The specific details object containing movie-only information.
     */
    public MediaEntry(int entryId, String title, String genre, String status, Movie movieDetails) 
    {
        this.entryId = entryId;
        this.title = title;
        this.genre = genre;
        this.status = status;
        this.mediaType = "Movie";
        this.movieDetails = movieDetails;
        this.rating = -1; // -1 indicates unrated initially
        this.review = ""; // makes sure that review is empty, not null
    }

    /**
     * Constructs a new MediaEntry specifically tracking a {@link BoardGame}.
     *
     * @param entryId The unique tracking identifier for this entry.
     * @param title The name of the board game.
     * @param genre The main thematic genre or category of the game.
     * @param status The user's play status state (e.g., "Planned", "In Progress", "Completed").
     * @param boardGameDetails The specific details object containing board game-only information.
     */
    public MediaEntry(int entryId, String title, String genre, String status, BoardGame boardGameDetails) 
    {
        this.entryId = entryId;
        this.title = title;
        this.genre = genre;
        this.status = status;
        this.mediaType = "Board Game";
        this.boardGameDetails = boardGameDetails;
        this.rating = -1; // -1 indicates unrated initially
        this.review = ""; // makes sure that review is empty, not null
    }

    /**
     * Retrieves the unique identifier linked to this tracking entry.
     *
     * @return The unique integer entry ID.
     */
    public int getEntryId() 
    {
        return entryId;
    }

    /**
     * Retrieves the title assigned to this tracking log.
     *
     * @return The media title text.
     */
    public String getTitle() 
    {
        return title;
    }

    /**
     * Retrieves the genre grouping classification.
     *
     * @return The text string of the genre tag.
     */
    public String getGenre() 
    {
        return genre;
    }

    /**
     * Retrieves the current user viewing or play tracking status.
     *
     * @return The current progression status value.
     */
    public String getStatus() 
    {
        return status;
    }

    /**
     * Retrieves the numerical evaluation rating scored out of 10.
     *
     * @return The evaluation index value, where -1 indicates unrated status.
     */
    public int getRating() 
    {
        return rating;
    }

    /**
     * Retrieves the written review notes provided by the user.
     *
     * @return The block text describing the user summary review.
     */
    public String getReview() 
    {
        return review;
    }

    /**
     * Retrieves the general structural type tag of the media wrapper.
     *
     * @return The specific string classification of the media layout.
     */
    public String getMediaType() 
    {
        return mediaType;
    }

    /**
     * Retrieves the extra details object linked to an anime entry.
     *
     * @return The child {@link Anime} structure, or {@code null} if this is a different media layout.
     */
    public Anime getAnimeDetails() 
    {
        return animeDetails;
    }

    /**
     * Retrieves the extra details object linked to a movie entry.
     *
     * @return The child {@link Movie} structure, or {@code null} if this is a different media layout.
     */
    public Movie getMovieDetails() 
    {
        return movieDetails;
    }

    /**
     * Retrieves the extra details object linked to a board game entry.
     *
     * @return The child {@link BoardGame} structure, or {@code null} if this is a different media layout.
     */
    public BoardGame getBoardGameDetails() 
    {
        return boardGameDetails;
    }

    /**
     * Validates if the given status string matches allowed vocabulary parameters within the tracker application.
     * Allowed status variants include "planned", "in progress", and "completed".
     *
     * @param status The target testing string input representing progression tracking.
     * @return {@code true} if the input text matches valid, supported status strings after formatting checks; {@code false} otherwise.
     */
    public boolean isValidStatus(String status) 
    {
        if (status == null) 
            return false;
        String s = status.trim().toLowerCase();
        return s.equals("planned") || s.equals("in progress") || s.equals("completed");
    }

    /**
     * Updates the active tracking profile progression descriptor if the prospective text input passes validation checks.
     *
     * @param newStatus The proposed entry status label string.
     * @return {@code true} if the target label passed checking validations and successfully changed properties; {@code false} otherwise.
     */
    public boolean updateStatus(String newStatus) 
    {
        if (isValidStatus(newStatus)) 
        {
            this.status = newStatus;
            return true;
        }
        return false;
    }

    /**
     * Verifies if this tracking item container is fundamentally eligible for review and score additions based on its status.
     *
     * @return {@code true} if the progression marker evaluates to a finished or completed state; {@code false} otherwise.
     */
    public boolean canBeRated() 
    {
        return this.status.equalsIgnoreCase("Completed");
    }

    /**
     * Commits a standardized quantitative metric score out of 10 alongside qualitative review description logs.
     *
     * @param rating The numeric rating input bounded comprehensively from 1 to 10 inclusive.
     * @param review The qualitative review overview remarks string.
     * @return {@code true} if the status evaluates to a valid review state and bounds constraints check out properly; {@code false} otherwise.
     */
    public boolean setRatingAndReview(int rating, String review) 
    {
        if (canBeRated() && rating >= 1 && rating <= 10) 
        {
            this.rating = rating;
            this.review = review;
            return true;
        }
        return false;
    }

    /**
     * Assesses whether a qualitative evaluation entry metric profile is verified and active on this instance.
     *
     * @return {@code true} if a user-supplied score evaluation is current; {@code false} if the log profile is unrated.
     */
    public boolean hasRating() 
    {
        return this.rating != -1;
    }

    /**
     * Resolves and extracts textual tracking context variables depending directly on the active structural wrapper layout mode.
     *
     * @return A consolidated custom string signature corresponding to sub-profile details, or an error fallback string.
     */
    public String getSpecificDetails() 
    {
        if (mediaType.equals("Anime") && animeDetails != null) 
        {
            return animeDetails.getDetails();
        } 
        else if (mediaType.equals("Movie") && movieDetails != null) 
        {
            return movieDetails.getDetails();
        } 
        else if (mediaType.equals("Board Game") && boardGameDetails != null) 
        {
            return boardGameDetails.getDetails();
        }
        return "No specific details available.";
    }
    
    /**
     * Combines general tracker attributes and specific media category details into a single printable text block.
     *
     * @return A complete formatted data visualization summary block profile representing this container context.
     */
    public String toString() 
    {
        String base = "[" + mediaType + "] ID: " + entryId + " | Title: " + title + " | Genre: " + genre + " | Status: " + status;
        if (hasRating()) 
        {
            base += " | Rating: " + rating + "/10 | Review: \"" + review + "\"";
        } 
        else 
        {
            base += " | Rating: Unrated";
        }
        return base + "\n    -> " + getSpecificDetails();
    }
}
