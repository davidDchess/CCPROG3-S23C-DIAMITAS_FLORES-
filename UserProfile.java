public class UserProfile {
  
    private String username;
    private MediaLibrary library;

    public UserProfile(String username) {
      this.username = username;
      library = new MediaLibrary();
    }

    public String getUsername() {
      return username;
    }

    public void setUsername(String username) {
      this.username = username;

    }

    public MediaLibrary getLibrary() {
      return library;
    }
  }


