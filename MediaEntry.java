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

    // Constructor for Anime entries
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

    // Constructor for Movie entries
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

    // Constructor for Board Game entries
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

    // Getters
    public int getEntryId() 
    {
        return entryId;
    }

    public String getTitle() 
    {
        return title;
    }

    public String getGenre() 
    {
        return genre;
    }

    public String getStatus() 
    {
        return status;
    }

    public int getRating() 
    {
        return rating;
    }

    public String getReview() 
    {
        return review;
    }

    public String getMediaType() 
    {
        return mediaType;
    }

    public Anime getAnimeDetails() 
    {
        return animeDetails;
    }

    public Movie getMovieDetails() 
    {
        return movieDetails;
    }

    public BoardGame getBoardGameDetails() 
    {
        return boardGameDetails;
    }

    // Validates if the given status string is allowed in the application.
    public boolean isValidStatus(String status) 
    {
        if (status == null) 
            return false;
        String s = status.trim().toLowerCase();
        return s.equals("planned") || s.equals("in progress") || s.equals("completed");
    }

    // Updates the media status if the new status passes validation.
    public boolean updateStatus(String newStatus) 
    {
        if (isValidStatus(newStatus)) 
        {
            this.status = newStatus;
            return true;
        }
        return false;
    }

    // Logic helper checking if an item is eligible for evaluation (e.g., not completely unplayed/unwatched).
    public boolean canBeRated() 
    {
        return this.status.equalsIgnoreCase("Completed");
    }

    // Submits a standard score out of 10 and a corresponding written review text.
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

    // Helper returning whether a valid score has been added to this container.
    public boolean hasRating() 
    {
        return this.rating != -1;
    }

    // Pulls information from whichever internal format is loaded.
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
    
    // Displays standard details combined cleanly alongside specific child data.
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
