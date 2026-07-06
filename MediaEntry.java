public class MediaEntry {

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

}