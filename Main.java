public class Main {
    public static void main(String[] args) {
        User user = new User(1, "Rodrigo", "rodrigo@example.com");
        MediaDiary diary = new MediaDiary(101);

        MediaEntry entry1 = new TVEntry(201, "The Last of Us", "Now", "Entertainment", "Monday", 60, "Curious", "HBO");
        MediaEntry entry2 = new PodcastEntry(202, "Football Decodified", "Spotify", "Entertainment", "Tuesday", 60, "Excited", "Ronaldo Nazario");
        MediaEntry entry3 = new SocialMediaEntry(203, "Football Highlights", "Instagram", "Entertainment", "Wednesday", 30, "Inspired", "@FIFA");

        diary.addEntry(entry1);
        diary.addEntry(entry2);
        diary.addEntry(entry3);

        user.addDiary(diary);

        System.out.println(entry1.getSummary());
        System.out.println(entry2.getSummary());
        System.out.println(entry3.getSummary());
        System.out.println("Total time spent: " + diary.getTotalTimeSpent() + " mins");
        System.out.println(user.generateSummary());
    }
}
