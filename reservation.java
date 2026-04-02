public abstract class Reservation {
    protected String resID;
    protected int price;
    protected char status;
    protected Customer guest;
    protected Date date;
    // Possible status: A (Active), R (Refunded), C (Cancelled), F (Finished)

    public Reservation(String resID, int day, int month, int year, int price, Customer guest) {
        this.resID = resID;
        this.date = new Date(day, month, year);
        this.price = price;
        this.status = 'A'; // Active by default
        this.guest = guest;
    }

    public String getResID() {
        return resID;
    }

    public void setResID(String resID) {
        this.resID = resID;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        status = Character.toUpperCase(status);
        if ("ARCF".indexOf(status) != -1) {
            this.status = status;
        } else {
            this.status = 'R';
            System.out.println("Invalid status. Status set to 'R' (Refunded) by default.");
        }
    }

    public Customer getGuest() {
        return guest;
    }

    public void setGuest(Customer guest) {
        this.guest = guest;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(int day, int month, int year) {
        this.date = new Date(day, month, year);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // Polymorphic method — each subclass calculates price differently
    public abstract int calculatePrice();

    @Override
    public String toString() {
        return "Reservation ID: " + resID
                + " | Guest: " + (guest != null ? guest.getName() : "N/A")
                + " | Date: " + date.getDate()
                + " | Status: " + status
                + " | Price: " + calculatePrice() + " SAR";
    }
}
