public abstract class MediaEntry implements Summarisable {
    protected int entryId;
    protected String title;
    protected String platform;
    protected String purpose;
    protected String day;
    protected int duration; // in minutes
    protected String emotionalResponse;

    public MediaEntry(int entryId, String title, String platform, String purpose, String day, int duration, String emotionalResponse) {
        this.entryId = entryId;
        this.title = title;
        this.platform = platform;
        this.purpose = purpose;
        this.day = day;
        this.duration = duration;
        this.emotionalResponse = emotionalResponse;
    }

    public int getDuration() {
        return duration;
    }

    public String getDay() {
        return day;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setEmotionalResponse(String response) {
        this.emotionalResponse = response;
    }

    public void setDuration(int minutes) {
        this.duration = minutes;
    }

    public abstract String getSummary();
}