import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            User user = new User(i, "User" + i, "user" + i + "@example.com");
            MediaDiary diary = new MediaDiary(100 + i);

            diary.addEntry(new TVEntry(i * 10 + 1, "Show " + i, "Netflix", "Entertainment", "Monday", 45, "Engaged", "Channel " + i));
            diary.addEntry(new PodcastEntry(i * 10 + 2, "Podcast " + i, "Spotify", "Education", "Tuesday", 30, "Curious", "Host " + i));
            diary.addEntry(new BookEntry(i * 10 + 3, "Book " + i, "Kindle", "Relaxation", "Wednesday", 60, "Relaxed", "Author " + i));
            diary.addEntry(new VideoGameEntry(i * 10 + 4, "Game " + i, "Xbox", "Entertainment", "Thursday", 90, "Excited", "Action"));
            diary.addEntry(new NewsEntry(i * 10 + 5, "News " + i, "BBC App", "Informative", "Friday", 20, "Informed", "BBC"));

            user.addDiary(diary);
            users.add(user);

            // Showcase user interactions
            // Modify emotional response for one entry
            diary.getEntriesByDay("Monday").get(0).setEmotionalResponse("Changed Mood");

            // Remove an entry
            diary.removeEntry(i * 10 + 3); // Remove BookEntry

            // Add a new entry manually
            diary.addEntry(new SocialMediaEntry(i * 10 + 6, "Reel " + i, "Instagram", "Entertainment", "Saturday", 15, "Amused", "@user" + i));
        }

        for (User user : users) {
            System.out.println("\n=== " + user.generateSummary() + " ===");
            for (MediaDiary diary : user.getDiaries()) {
                System.out.println(diary.getSummary());
                System.out.println("Total time: " + diary.getTotalTimeSpent() + " mins");

                for (String day : Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")) {
                    List<MediaEntry> entries = diary.getEntriesByDay(day);
                    System.out.println("- " + day + " entries:");
                    for (MediaEntry entry : entries) {
                        System.out.println("  • " + entry.getSummary());
                    }
                }
            }
        }
    }
}