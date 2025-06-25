class NewsEntry extends MediaEntry {
    private String source;

    public NewsEntry(int entryId, String title, String platform, String purpose, String day, int duration, String emotionalResponse, String source) {
        super(entryId, title, platform, purpose, day, duration, emotionalResponse);
        this.source = source;
    }

    @Override
    public String getSummary() {
        return "News Entry: " + title + " from " + source + " on " + platform + ".";
    }
}