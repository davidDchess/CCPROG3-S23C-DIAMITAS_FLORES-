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
        this.mediaType = "BoardGame";
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
        return s.equals("plan to watch") || s.equals("watching") || s.equals("plan to play") || s.equals("playing") || s.equals("completed") || s.equals("dropped");
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
        return !this.status.equalsIgnoreCase("plan to watch") && !this.status.equalsIgnoreCase("plan to play");
    }

}
