import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String name;
    private String email;
    private List<MediaDiary> diaries;

    public User(int userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.diaries = new ArrayList<>();
    }

    public void addDiary(MediaDiary diary) {
        diaries.add(diary);
    }

    public void removeDiary(int diaryId) {
        diaries.removeIf(d -> d.getSummary().contains("ID: " + diaryId));
    }

    public String generateSummary() {
        return name + " has " + diaries.size() + " diary(ies).";
    }
}