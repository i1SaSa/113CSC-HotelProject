public class EventHall extends EventSpace {
    private boolean hasStage;
    private static final int PRICE_PER_SQFT = 20;

    public EventHall(String resID, int day, int month, int year,
                     Customer guest, int maxCapacity, int sizeInSqFt, boolean hasStage) {
        super(resID, day, month, year, PRICE_PER_SQFT, guest, maxCapacity, sizeInSqFt);
        this.hasStage = hasStage;
    }

    public boolean isHasStage() { return hasStage; }
    public void setHasStage(boolean hasStage) { this.hasStage = hasStage; }

    @Override
    public int calculatePrice() {
        int total = price * sizeInSqFt;
        if (hasStage) total += 2000;
        return total;
    }

    @Override
    public String toString() {
        return "[Event Hall] " + super.toString()
                + " | Capacity: " + maxCapacity
                + " | Size: " + sizeInSqFt + " sqft"
                + " | Stage: " + (hasStage ? "Yes" : "No");
    }
}
