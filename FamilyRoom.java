public class FamilyRoom extends Room {
    private boolean hasKitchenette;
    private int extraCots;
    private static final int BASE_PRICE_PER_NIGHT = 500;
    private static final int COT_PRICE = 75;

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
    public int calculatePrice() {
        int total = price * numberOfNights;
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
