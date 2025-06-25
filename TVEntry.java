class TVEntry extends MediaEntry {
    private String channel;

    public TVEntry(int entryId, String title, String platform, String purpose, String day, int duration, String emotionalResponse, String channel) {
        super(entryId, title, platform, purpose, day, duration, emotionalResponse);
        this.channel = channel;
    }

    @Override
    public String getSummary() {
        return "TV Entry: " + title + " on " + platform + " (" + channel + ") for " + duration + " mins.";
    }
}