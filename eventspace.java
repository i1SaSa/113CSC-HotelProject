public abstract class EventSpace extends Reservation {
    protected int maxCapacity;
    protected int sizeInSqFt;

    public EventSpace(String resID, int day, int month, int year, double price,
                      Customer guest, int maxCapacity, int sizeInSqFt) {
        super(resID, day, month, year, price, guest);
        this.maxCapacity = maxCapacity;
        this.sizeInSqFt = sizeInSqFt;
    }

    public int getMaxCapacity() { return maxCapacity; }
    public void setMaxCapacity(int maxCapacity) { this.maxCapacity = maxCapacity; }

    public int getSizeInSqFt() { return sizeInSqFt; }
    public void setSizeInSqFt(int sizeInSqFt) { this.sizeInSqFt = sizeInSqFt; }

    @Override
    public abstract double calculatePrice();
}
