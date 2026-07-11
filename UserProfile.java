/**
 * Represents a user's profile in the tracking application. 
 * It manages the user's name and holds their personal media library collection.
 *
 * @author DIAMITAS_FLORES
 */
public class UserProfile {
  
    private String username;
    private MediaLibrary library;

    /**
     * Constructs a new UserProfile with the given username and sets up a fresh, empty media library.
     *
     * @param username The name chosen by the user for their profile.
     */
    public UserProfile(String username) {
        this.username = username;
        this.library = new MediaLibrary();
    }

    /**
     * Gets the user's profile name.
     *
     * @return The username text string.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Changes or updates the user's profile name.
     *
     * @param username The new username to apply.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the personal media library collection connected to this profile.
     *
     * @return The {@link MediaLibrary} object belonging to the user.
     */
    public MediaLibrary getLibrary() {
        return library;
    }
}
