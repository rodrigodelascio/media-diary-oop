class BookEntry extends MediaEntry {
    private String author;

    public BookEntry(int entryId, String title, String platform, String purpose, String day, int duration, String emotionalResponse, String author) {
        super(entryId, title, platform, purpose, day, duration, emotionalResponse);
        this.author = author;
    }

    @Override
    public String getSummary() {
        return "Book Entry: " + title + " by " + author + " read on " + day + ".";
    }
}