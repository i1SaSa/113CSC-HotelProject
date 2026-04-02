public class Suite extends Room implements ComesWithDesignatedParking {
    private boolean hasBalcony;
    private static final double BASE_PRICE_PER_NIGHT = 1200.0;

    public Suite(String resID, int day, int month, int year,
                 Customer guest, int beds, String roomNumber,
                 int numberOfNights, boolean hasBalcony) {
        super(resID, day, month, year, BASE_PRICE_PER_NIGHT, guest, beds, roomNumber, numberOfNights);
        this.hasBalcony = hasBalcony;
    }

    public boolean isHasBalcony() { return hasBalcony; }
    public void setHasBalcony(boolean hasBalcony) { this.hasBalcony = hasBalcony; }

    @Override
    public void assignParking() {
        System.out.println("Suite " + roomNumber + " has been assigned a VIP parking spot.");
    }

    @Override
    public double calculatePrice() {
        double total = price * numberOfNights;
        if (hasBalcony) total += 300 * numberOfNights;
        return total;
    }

    @Override
    public String toString() {
        return "[Suite] " + super.toString()
                + " | Nights: " + numberOfNights
                + " | Balcony: " + (hasBalcony ? "Yes" : "No");
    }
}
