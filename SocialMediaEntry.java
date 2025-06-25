class SocialMediaEntry extends MediaEntry {
    private String accountName;

    public SocialMediaEntry(int entryId, String title, String platform, String purpose, String day, int duration, String emotionalResponse, String accountName) {
        super(entryId, title, platform, purpose, day, duration, emotionalResponse);
        this.accountName = accountName;
    }

    @Override
    public String getSummary() {
        return "Social Media Entry: " + title + " from " + accountName + " on " + platform + ".";
    }
}