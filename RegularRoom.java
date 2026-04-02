public class RegularRoom extends Room {
    private boolean hasMiniFridge;
    private static final double BASE_PRICE_PER_NIGHT = 300.0;

    public RegularRoom(String resID, int day, int month, int year,
                       Customer guest, int beds, String roomNumber,
                       int numberOfNights, boolean hasMiniFridge) {
        super(resID, day, month, year, BASE_PRICE_PER_NIGHT, guest, beds, roomNumber, numberOfNights);
        this.hasMiniFridge = hasMiniFridge;
    }

    public boolean isHasMiniFridge() { return hasMiniFridge; }
    public void setHasMiniFridge(boolean hasMiniFridge) { this.hasMiniFridge = hasMiniFridge; }

    @Override
    public double calculatePrice() {
        double total = price * numberOfNights;
        if (hasMiniFridge) total += 50;
        return total;
    }

    @Override
    public String toString() {
        return "[Regular Room] " + super.toString()
                + " | Nights: " + numberOfNights
                + " | Mini Fridge: " + (hasMiniFridge ? "Yes" : "No");
    }
}
