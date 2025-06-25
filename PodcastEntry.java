class PodcastEntry extends MediaEntry {
    private String host;

    public PodcastEntry(int entryId, String title, String platform, String purpose, String day, int duration, String emotionalResponse, String host) {
        super(entryId, title, platform, purpose, day, duration, emotionalResponse);
        this.host = host;
    }

    @Override
    public String getSummary() {
        return "Podcast Entry: " + title + " hosted by " + host + " on " + platform + ".";
    }
}