public class Lobby extends EventSpace {
    private static final int PRICE_PER_SQFT = 10;

    public Lobby(String resID, int day, int month, int year,
                 Customer guest, int maxCapacity, int sizeInSqFt) {
        super(resID, day, month, year, PRICE_PER_SQFT, guest, maxCapacity, sizeInSqFt);
    }

    @Override
    public int calculatePrice() {
        return price * sizeInSqFt;
    }

    @Override
    public String toString() {
        return "[Lobby] " + super.toString()
                + " | Capacity: " + maxCapacity
                + " | Size: " + sizeInSqFt + " sqft";
    }
}
