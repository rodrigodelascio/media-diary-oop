import java.util.*; // Unnecessary import right now, but included for completeness and future use

public class Main {
    public static void main(String[] args) {
        User user = new User(1, "Rodrigo", "rodrigo@example.com");
        MediaDiary diary = new MediaDiary(101);

        MediaEntry entry1 = new TVEntry(201, "The Last of Us", "Now", "Entertainment", "Monday", 60, "Curious", "HBO");
        MediaEntry entry2 = new PodcastEntry(202, "Football Decodified", "Spotify", "Entertainment", "Tuesday", 60, "Excited", "Ronaldo Nazario");
        MediaEntry entry3 = new SocialMediaEntry(203, "Football Highlights", "Instagram", "Entertainment", "Wednesday", 30, "Inspired", "@FIFA");
        MediaEntry entry4 = new BookEntry(204, "Atomic Habits", "Paperback", "Self-improvement", "Thursday", 90, "Motivated", "James Clear");
        MediaEntry entry5 = new VideoGameEntry(205, "FIFA 23", "PlayStation", "Entertainment", "Friday", 120, "Excited", "Sports");
        MediaEntry entry6 = new NewsEntry(206, "Global Markets Update", "BBC News App", "Informative", "Saturday", 30, "Informed", "BBC");

        diary.addEntry(entry1);
        diary.addEntry(entry2);
        diary.addEntry(entry3);
        diary.addEntry(entry4);
        diary.addEntry(entry5);
        diary.addEntry(entry6);

        user.addDiary(diary);

        System.out.println("--- Individual Entry Summaries ---");
        for (MediaEntry entry : diary.getEntriesByDay("Friday")) {
            System.out.println(entry.getSummary());
        }

        System.out.println("\n--- Diary Summary ---");
        System.out.println(diary.getSummary());
        System.out.println("Total time spent: " + diary.getTotalTimeSpent() + " mins");

        System.out.println("\n--- User Summary ---");
        System.out.println(user.generateSummary());
    }
}
