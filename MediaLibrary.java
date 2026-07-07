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

  public boolean addEntry(Mediaentry entry) {
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
}







    
