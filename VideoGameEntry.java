class VideoGameEntry extends MediaEntry {
    private String genre;

    public VideoGameEntry(int entryId, String title, String platform, String purpose, String day, int duration, String emotionalResponse, String genre) {
        super(entryId, title, platform, purpose, day, duration, emotionalResponse);
        this.genre = genre;
    }

    @Override
    public String getSummary() {
        return "Video Game Entry: " + title + " (" + genre + ") played on " + platform + ".";
    }
}