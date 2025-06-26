import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MediaDiary implements Summarisable {
    private int diaryId;
    private List<MediaEntry> entries;

    public MediaDiary(int diaryId) {
        this.diaryId = diaryId;
        this.entries = new ArrayList<>();
    }

    public void addEntry(MediaEntry entry) {
        entries.add(entry);
    }

    public void removeEntry(int entryId) {
        entries.removeIf(e -> e.entryId == entryId);
    }

    public List<MediaEntry> getEntriesByDay(String day) {
        List<MediaEntry> result = new ArrayList<>();
        for (MediaEntry e : entries) {
            if (e.getDay().equalsIgnoreCase(day)) {
                result.add(e);
            }
        }
        return result;
    }

    public int getTotalTimeSpent() {
        return TimeTracker.sumDurations(entries);
    }

    public List<MediaEntry> getAllEntries() {
        return entries;
    }

    public Set<String> getAvailableDays() {
    Set<String> days = new HashSet<>();
    for (MediaEntry e : entries) {
        days.add(e.getDay());
    }
    return days;
    }

    @Override
    public String getSummary() {
        return "Media Diary ID: " + diaryId + ", Entries: " + entries.size();
    }
}