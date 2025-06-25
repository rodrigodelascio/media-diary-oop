import java.util.List;

public class TimeTracker {
    public static int sumDurations(List<MediaEntry> entries) {
        int total = 0;
        for (MediaEntry e : entries) {
            total += e.getDuration();
        }
        return total;
    }
}