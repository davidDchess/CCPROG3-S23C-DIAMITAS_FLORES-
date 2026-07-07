import java.util.ArrayList;

public class MediaLibrary {
  private ArrayList<MediaEntry> entries;
  private int nextEntryId;

  public MediaLibrary() {
    entries = new ArrayList<MediaEntry>();
    nextEntryId = 1;

  }

  public int generateEntryId() {
    int id = nextEntryId;
    nextEntryId++;
    return id;
  }

  public boolean addEntry(MediaEntry entry) {
    if (entry == null) {
      return false;
    }

    entries.add(entry);
    return true;
  }

  public MediaEntry getEntryById(int entryId) {
    for (int i = 0; i < entries.size(); i++) {
      MediaEntry entry = entries.get(i);

      if (entry.getEntryId() == entryId) {
        return entry;
      }
    }
    return null;
  }

  public boolean removeEntry(int entryId) {
    MediaEntry entry = getEntryById(entryId);

    if (entry == null) {
      return false;
    }

    entries.remove(entry);
    return true;
  }

  public ArrayList<MediaEntry> getAllEntries() {
    return entries;
  }

  public ArrayList<MediaEntry> filterByStatus(String status) {
    ArrayList<MediaEntry> filteredEntries = new ArrayList<MediaEntry>();

    for (int i = 0; i < entries.size(); i++) {
      MediaEntry entry = entries.get(i);

      if (entry.getStatus().equalsIgnoreCase(status)) {
        filteredEntries.add(entry);

      }
    }

    return filteredEntries;
  }

  public ArrayList<MediaEntry> filterByMediaType(String mediaType) {
    ArrayList<MediaEntry> filteredEntries = new ArrayList<MediaEntry>();

    for (int i = 0; i < entries.size(); i++) {
      MediaEntry entry = entries.get(i);

      if (entry.getMediaType().equalsIgnoreCase(mediaType)) {
          filteredEntries.add(enry);
      }
    }

    return filteredEntries;
  }
  public ArrayList<MediaEntry> searchByTitle(String keyword) {
    ArrayList<MediaEntry> results = new ArrayList<MediaEntry>();

    for (int i = 0; i < entries.size(); i++) {
      MediaEntry entry = entries.get(i);

      if (entry.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
        results.add(entry);
      }
    }

    return results;

  }
  
  public int getTotalEntries() {
    return entries.size();
}

public int countByStatus(String status) {
    int count = 0;

    for (int i = 0; i < entries.size(); i++) {
        MediaEntry entry = entries.get(i);

        if (entry.getStatus().equalsIgnoreCase(status)) {
            count++;
        }
    }

    return count;
}

public int countByMediaType(String mediaType) {
    int count = 0;

    for (int i = 0; i < entries.size(); i++) {
        MediaEntry entry = entries.get(i);

        if (entry.getMediaType().equalsIgnoreCase(mediaType)) {
            count++;
        }
    }

    return count;
}

public double getAverageRating() {
    int totalRating = 0;
    int ratedEntries = 0;

    for (int i = 0; i < entries.size(); i++) {
        MediaEntry entry = entries.get(i);

        if (entry.hasRating()) {
            totalRating += entry.getRating();
            ratedEntries++;
        }
    }

    if (ratedEntries == 0) {
        return 0.0;
    }

    return (double) totalRating / ratedEntries;
  }
}
