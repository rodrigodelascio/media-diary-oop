import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<User> users = new ArrayList<>();
        int nextUserId = 1;
        int nextDiaryId = 100;
        int nextEntryId = 1000;

        boolean running = true;
        while (running) {
            System.out.println("\n===== Media Diary App =====");
            System.out.println("1. Create New User");
            System.out.println("2. Select User");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int mainOption = scanner.nextInt();
            scanner.nextLine();

            switch (mainOption) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    User newUser = new User(nextUserId++, name, email);
                    MediaDiary newDiary = new MediaDiary(nextDiaryId++);
                    newUser.addDiary(newDiary);
                    users.add(newUser);
                    System.out.println("User created and diary linked successfully.");
                    break;

                case 2:
                    if (users.isEmpty()) {
                        System.out.println("No users available. Please create a user first.");
                        break;
                    }
                    System.out.println("Available Users:");
                    for (User u : users) {
                        System.out.println("ID: " + u.getUserId() + " - " + u.generateSummary());
                    }
                    System.out.print("Enter user ID to select: ");
                    int selectedId = scanner.nextInt();
                    scanner.nextLine();
                    User selectedUser = users.stream().filter(u -> u.getUserId() == selectedId).findFirst()
                            .orElse(null);
                    if (selectedUser == null) {
                        System.out.println("User not found.");
                        break;
                    }

                    MediaDiary diary = selectedUser.getDiaries().get(0); // one diary per user for now

                    boolean userMenu = true;
                    while (userMenu) {
                        System.out.println("\n===== User Menu for " + selectedUser.getName() + " =====");
                        System.out.println("1. Add Media Entry");
                        System.out.println("2. View All Entries");
                        System.out.println("3. View Entries by Day");
                        System.out.println("4. Remove Entry by ID");
                        System.out.println("5. View Weekly Summary");
                        System.out.println("6. Back to Main Menu");
                        System.out.println("7. Compare Two Users by Purpose");
                        System.out.print("Choose an option: ");
                        int option = scanner.nextInt();
                        scanner.nextLine();

                        switch (option) {
                            case 1:
                                System.out.println(
                                        "Select Media Type: TV, PODCAST, SOCIAL_MEDIA, BOOK, VIDEO_GAME, NEWS");
                                String type = scanner.nextLine().toUpperCase();
                                System.out.print("Title: ");
                                String title = scanner.nextLine();
                                System.out.print("Platform: ");
                                String platform = scanner.nextLine();
                                System.out.print("Purpose: ");
                                String purpose = scanner.nextLine();
                                System.out.print("Day: ");
                                String day = scanner.nextLine();
                                System.out.print("Duration (in minutes): ");
                                int duration = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Emotional Response: ");
                                String emotion = scanner.nextLine();

                                MediaEntry entry = null;
                                switch (type) {
                                    case "TV":
                                        System.out.print("Channel: ");
                                        String channel = scanner.nextLine();
                                        entry = new TVEntry(nextEntryId++, title, platform, purpose, day, duration,
                                                emotion, channel);
                                        break;
                                    case "PODCAST":
                                        System.out.print("Host: ");
                                        String host = scanner.nextLine();
                                        entry = new PodcastEntry(nextEntryId++, title, platform, purpose, day, duration,
                                                emotion, host);
                                        break;
                                    case "SOCIAL_MEDIA":
                                        System.out.print("Account Name: ");
                                        String account = scanner.nextLine();
                                        entry = new SocialMediaEntry(nextEntryId++, title, platform, purpose, day,
                                                duration, emotion, account);
                                        break;
                                    case "BOOK":
                                        System.out.print("Author: ");
                                        String author = scanner.nextLine();
                                        entry = new BookEntry(nextEntryId++, title, platform, purpose, day, duration,
                                                emotion, author);
                                        break;
                                    case "VIDEO_GAME":
                                        System.out.print("Genre: ");
                                        String genre = scanner.nextLine();
                                        entry = new VideoGameEntry(nextEntryId++, title, platform, purpose, day,
                                                duration, emotion, genre);
                                        break;
                                    case "NEWS":
                                        System.out.print("Source: ");
                                        String source = scanner.nextLine();
                                        entry = new NewsEntry(nextEntryId++, title, platform, purpose, day, duration,
                                                emotion, source);
                                        break;
                                    default:
                                        System.out.println("Invalid media type.");
                                }
                                if (entry != null) {
                                    diary.addEntry(entry);
                                    System.out.println("Entry added successfully!");
                                }
                                break;
                            case 2:
                                for (MediaEntry e : diary.getAllEntries()) {
                                    System.out.println(e.getSummary());
                                }
                                break;
                            case 3:
                                Set<String> availableDays = diary.getAvailableDays();
                                System.out.println("Available Days: " + String.join(", ", availableDays));
                                System.out.print("Enter day to filter: ");
                                String filterDay = scanner.nextLine();
                                for (MediaEntry e : diary.getEntriesByDay(filterDay)) {
                                    System.out.println(e.getSummary());
                                }
                                break;
                            case 4:
                                System.out.println("Current Entries:");
                                for (MediaEntry e : diary.getAllEntries()) {
                                    System.out.println("ID: " + e.entryId + " - " + e.getSummary());
                                }
                                System.out.print("Enter Entry ID to remove: ");
                                int idToRemove = scanner.nextInt();
                                scanner.nextLine();
                                diary.removeEntry(idToRemove);
                                System.out.println(
                                        "Attempted to remove entry ID " + idToRemove + ". Check summary to confirm.");
                                break;
                            case 5:
                                System.out.println("User: " + selectedUser.generateSummary());
                                System.out.println(diary.getSummary());
                                System.out.println("Total time spent: " + diary.getTotalTimeSpent() + " minutes");

                                // Enhanced summary analytics
                                Map<String, Integer> timeByType = new HashMap<>();
                                Map<String, Integer> countByPurpose = new HashMap<>();
                                Map<String, Integer> countByDay = new HashMap<>();
                                Map<String, Integer> countByPlatform = new HashMap<>();

                                for (MediaEntry e : diary.getAllEntries()) {
                                    String mediaType = e.getClass().getSimpleName();
                                    timeByType.put(mediaType, timeByType.getOrDefault(mediaType, 0) + e.getDuration());
                                    countByPurpose.put(e.getPurpose(),
                                            countByPurpose.getOrDefault(e.getPurpose(), 0) + 1);
                                    countByDay.put(e.getDay(), countByDay.getOrDefault(e.getDay(), 0) + 1);
                                    countByPlatform.put(e.platform, countByPlatform.getOrDefault(e.platform, 0) + 1);
                                }

                                System.out.println("\n-- Time Spent by Media Type --");
                                for (var t : timeByType.entrySet()) {
                                    System.out.println(t.getKey() + ": " + t.getValue() + " mins");
                                }

                                System.out.println("\n-- Entry Count by Purpose --");
                                for (var p : countByPurpose.entrySet()) {
                                    System.out.println(p.getKey() + ": " + p.getValue());
                                }

                                System.out.println("\n-- Entries per Day --");
                                for (var d : countByDay.entrySet()) {
                                    System.out.println(d.getKey() + ": " + d.getValue());
                                }

                                System.out.println("\n-- Entries by Platform --");
                                for (var plat : countByPlatform.entrySet()) {
                                    System.out.println(plat.getKey() + ": " + plat.getValue());
                                }

                                // Enhanced insights
                                int totalEntries = diary.getAllEntries().size();
                                System.out.println("\nTotal Entries: " + totalEntries);

                                String mostUsedPlatform = countByPlatform.entrySet()
                                        .stream().max(Map.Entry.comparingByValue())
                                        .map(Map.Entry::getKey).orElse("N/A");
                                System.out.println("Most Used Platform: " + mostUsedPlatform);

                                String mostActiveDay = countByDay.entrySet()
                                        .stream().max(Map.Entry.comparingByValue())
                                        .map(Map.Entry::getKey).orElse("N/A");
                                System.out.println("Most Active Day: " + mostActiveDay);
                                break;
                            case 6:
                                userMenu = false;
                                break;
                            case 7:
                                if (users.size() < 2) {
                                    System.out.println("At least two users are required for comparison.");
                                    break;
                                }
                                System.out.println("Available Users:");
                                for (User u : users) {
                                    System.out.println("ID: " + u.getUserId() + " - " + u.getName());
                                }
                                System.out.print("Enter ID of first user: ");
                                int id1 = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Enter ID of second user: ");
                                int id2 = scanner.nextInt();
                                scanner.nextLine();

                                User user1 = users.stream().filter(u -> u.getUserId() == id1).findFirst().orElse(null);
                                User user2 = users.stream().filter(u -> u.getUserId() == id2).findFirst().orElse(null);

                                if (user1 == null || user2 == null || user1 == user2) {
                                    System.out.println("Invalid user selection.");
                                    break;
                                }

                                System.out.print("Enter purpose to compare (e.g., Education, Entertainment): ");
                                String comparePurpose = scanner.nextLine();

                                MediaComparer comparer = new CompareByPurpose(comparePurpose);
                                comparer.compare(user1, user2);
                                break;

                            default:
                                System.out.println("Invalid option. Try again.");
                        }
                    }
                    break;

                case 3:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}
