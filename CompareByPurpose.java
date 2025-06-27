public class CompareByPurpose implements MediaComparer {
    private String targetPurpose;

    public CompareByPurpose(String purpose) {
        this.targetPurpose = purpose;
    }

    @Override
    public void compare(User u1, User u2) {
        int total1 = getPurposeTime(u1, targetPurpose);
        int total2 = getPurposeTime(u2, targetPurpose);
        System.out.println("\n=== Comparison: Time Spent on '" + targetPurpose + "' ===");
        System.out.println(u1.getName() + ": " + total1 + " mins");
        System.out.println(u2.getName() + ": " + total2 + " mins");

        if (total1 == total2) {
            System.out.println("Both users spent the same amount of time.");
        } else if (total1 > total2) {
            System.out.println(u1.getName() + " spent more time on this purpose.");
        } else {
            System.out.println(u2.getName() + " spent more time on this purpose.");
        }
    }

    private int getPurposeTime(User user, String purpose) {
        int total = 0;
        for (MediaDiary d : user.getDiaries()) {
            for (MediaEntry e : d.getAllEntries()) {
                if (e.getPurpose().equalsIgnoreCase(purpose)) {
                    total += e.getDuration();
                }
            }
        }
        return total;
    }
}