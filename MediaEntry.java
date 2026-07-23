/**
 * Represents a single item in your tracker, storing shared info like title and status.
 * It also holds onto the unique, extra details required for Animes, Movies, or Board Games.
 *
 * @author DIAMITAS_FLORES
 */
public abstract class MediaEntry 
{
    // Attributes
    private int entryId;
    private String title;
    private String genre;
    private String status;
    private int rating;
    private String review;
    
    

    /**
     * Constructs a new MediaEntry specifically tracking an {@link Anime} series.
     *
     * @param entryId      The unique tracking identifier for this entry.
     * @param title        The title of the anime series.
     * @param genre        The main thematic genre of the content.
     * @param status       The user's consumption state (e.g., "Planned", "In Progress", "Completed").
     */
    public MediaEntry(int entryId, String title, String genre, String status) 
    {
        this.entryId = entryId;
        this.title = title;
        this.genre = genre;
        this.status = status;
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
            
            if (review == null) {

                this.review = "";
            }
            else
            {
                this.review = review;
            }

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
     * Returns the media type of the entry.
     * 
     * @return the media type.
     */
    public abstract String getMediaType();

      /** 
     * Returns the media type of the entry.
     * 
     * @return the media type.
     */
    public abstract String getSpecificDetails();

      /** 
     * Returns the media type of the entry.
     * 
     * @return the media type.
     */
    public abstract String toFileString();
    
    /**
     * Combines general tracker attributes and specific media category details into a single printable text block.
     *
     * @return A complete formatted data visualization summary block profile representing this container context.
     */
    public String toString() 
    {
        String base = "[" + getMediaType() + "] ID: " + entryId + " | Title: " + title + " | Genre: " + genre + " | Status: " + status;
       
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
       
