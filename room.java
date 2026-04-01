public abstract class room extends reservation { 
    protected int beds;
    protected String roomnum;
    protected boolean isOccupied;

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public room(String resID, int day, int month, int year, int price, int beds, String roomnum) {
        super(resID, day, month, year, price);
        this.beds = beds;
        this.roomnum = roomnum;
        this.isOccupied = false; 
    }

    public void checkIn() {
        if (!isOccupied) {
            isOccupied = true;
            System.out.println("Success! Guest has checked into Room " + roomnum + ".");
        } else {
            System.out.println("Error: Cannot check in. Room " + roomnum + " is already occupied!");
        }
    }
  
    public void checkOut() {
        if (isOccupied) {
            isOccupied = false;
            this.isreserved = false; 
            System.out.println("Guest has checked out of Room " + roomnum + ". Please send housekeeping.");
        } else {
            System.out.println("Error: Room " + roomnum + " is already empty!");
        }
    }
   
}