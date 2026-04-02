public abstract class Room extends Reservation {
    protected int beds;
    protected String roomNumber;
    protected boolean isOccupied;
    protected int numberOfNights;

    public Room(String resID, int day, int month, int year, double price,
                Customer guest, int beds, String roomNumber, int numberOfNights) {
        super(resID, day, month, year, price, guest);
        this.beds = beds;
        this.roomNumber = roomNumber;
        this.numberOfNights = numberOfNights;
        this.isOccupied = false;
    }

    public int getBeds() { return beds; }
    public void setBeds(int beds) { this.beds = beds; }

    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public boolean isOccupied() { return isOccupied; }
    public void setOccupied(boolean isOccupied) { this.isOccupied = isOccupied; }

    public int getNumberOfNights() { return numberOfNights; }
    public void setNumberOfNights(int numberOfNights) { this.numberOfNights = numberOfNights; }

    public void checkIn() {
        if (!isOccupied) {
            isOccupied = true;
            setStatus('A');
            System.out.println("Success! Guest " + guest.getName() + " checked into Room " + roomNumber + ".");
        } else {
            System.out.println("Error: Room " + roomNumber + " is already occupied!");
        }
    }

    public void checkOut() {
        if (isOccupied) {
            isOccupied = false;
            setStatus('F');
            System.out.println("Guest checked out of Room " + roomNumber + ". Please send housekeeping.");
        } else {
            System.out.println("Error: Room " + roomNumber + " is already empty!");
        }
    }

    @Override
    public abstract double calculatePrice();
}
