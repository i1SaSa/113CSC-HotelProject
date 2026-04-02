public class FamilyRoom extends Room {
    private boolean hasKitchenette;
    private int extraCots;
    private static final double BASE_PRICE_PER_NIGHT = 500.0;
    private static final double COT_PRICE = 75.0;

    public FamilyRoom(String resID, int day, int month, int year,
                      Customer guest, int beds, String roomNumber,
                      int numberOfNights, boolean hasKitchenette) {
        super(resID, day, month, year, BASE_PRICE_PER_NIGHT, guest, beds, roomNumber, numberOfNights);
        this.hasKitchenette = hasKitchenette;
        this.extraCots = 0;
    }

    public boolean isHasKitchenette() { return hasKitchenette; }
    public void setHasKitchenette(boolean hasKitchenette) { this.hasKitchenette = hasKitchenette; }
    public int getExtraCots() { return extraCots; }

    public void addCot() {
        extraCots++;
        System.out.println("Extra cot added to Family Room " + roomNumber + ". Total cots: " + extraCots);
    }

    @Override
    public double calculatePrice() {
        double total = price * numberOfNights;
        if (hasKitchenette) total += 100 * numberOfNights;
        total += extraCots * COT_PRICE * numberOfNights;
        return total;
    }

    @Override
    public String toString() {
        return "[Family Room] " + super.toString()
                + " | Nights: " + numberOfNights
                + " | Kitchenette: " + (hasKitchenette ? "Yes" : "No")
                + " | Extra Cots: " + extraCots;
    }
}
