
public class Lobby extends EventSpace implements java.io.Serializable {

    private static final double PRICE_PER_SQFT = 10.0;

    public Lobby(String resID, int day, int month, int year,
            Customer guest, int maxCapacity, int sizeInSqFt) throws InvalidDateException {
        super(resID, day, month, year, PRICE_PER_SQFT, guest, maxCapacity, sizeInSqFt);
    }

    @Override
    public double calculatePrice() {
        return price * sizeInSqFt;
    }

    @Override
    public String toString() {
        return "[Lobby] " + super.toString()
                + " | Capacity: " + maxCapacity
                + " | Size: " + sizeInSqFt + " sqft";
    }
}
